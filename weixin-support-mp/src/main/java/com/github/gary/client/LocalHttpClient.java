package com.github.gary.client;

import com.github.gary.Version;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @author garygao
 **/
public class LocalHttpClient {
    private static final Logger logger = LoggerFactory.getLogger(LocalHttpClient.class);

    private static int timeout = 8000;

    private static int retryExecutionCount = 2;

    protected static CloseableHttpClient httpClient = HttpClientFactory.createHttpClient(100, 10, timeout, retryExecutionCount);

    private static ResultErrorHandler resultErrorHandler;

    protected static final Header userAgentHeader = new BasicHeader(HttpHeaders.USER_AGENT, "weixin-support sdk java -v " + Version.VERSION);

    public static CloseableHttpResponse execute(HttpUriRequest request) {
        loggerRequest(request);
        userAgent(request);
        try {
            return httpClient.execute(request, HttpClientContext.create());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return null;
    }

    public static <T> T execute(HttpUriRequest request, ResponseHandler<T> responseHandler) {
        String uriId = loggerRequest(request);
        userAgent(request);
        if (responseHandler instanceof LocalResponseHandler) {
            LocalResponseHandler lrh = (LocalResponseHandler) responseHandler;
            lrh.setUriId(uriId);
        }
        try {
            T t = httpClient.execute(request, responseHandler, HttpClientContext.create());
            if (resultErrorHandler != null) {
                resultErrorHandler.doHandle(uriId, request, t);
            }
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     * 日志记录
     *
     * @param request request
     * @return log request id
     */
    private static String loggerRequest(HttpUriRequest request) {
        String id = UUID.randomUUID().toString();
        if (request instanceof HttpEntityEnclosingRequestBase) {
            HttpEntityEnclosingRequestBase request_base = (HttpEntityEnclosingRequestBase) request;
            HttpEntity entity = request_base.getEntity();
            String content = null;
            //MULTIPART_FORM_DATA 请求类型判断
            if (entity.getContentType().toString().indexOf(ContentType.MULTIPART_FORM_DATA.getMimeType()) == -1) {
                try {
                    content = EntityUtils.toString(entity);
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error(e.getMessage());
                }
            }
            logger.info("URI[{}] {} {} ContentLength:{} Content:{}",
                    id,
                    request.getURI().toString(),
                    entity.getContentType(),
                    entity.getContentLength(),
                    content == null ? "multipart_form_data" : content);
        } else {
            logger.info("URI[{}] {}", id, request.getURI().toString());
        }
        return id;
    }

    /**
     * 数据返回自动JSON对象解析
     *
     * @param request request
     * @param clazz   clazz
     * @return result
     */
    public static <T> T executeJsonResult(HttpUriRequest request, Class<T> clazz) {
        return execute(request, JsonResponseHandler.createResponseHandler(clazz));
    }

    private static void userAgent(HttpUriRequest httpUriRequest) {
        httpUriRequest.addHeader(userAgentHeader);
    }
}
