package com.github.gary.mp.api;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;

/**
 * @author garygao
 **/
public abstract class BaseApi {
    /**
     * 通用域名，使用该域名将访问官方指定就近的接入点；
     */
    protected final static String BASE_URI = "https://api.weixin.qq.com";

    /**
     * Content-Type是application/json的请求header
     */
    protected static Header jsonHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
    /**
     * Content-Type是application/xml的请求header
     */
    protected static Header xmlHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_XML.toString());

    /**
     * access_token请求参数
     */
    protected static final String PARAM_ACCESS_TOKEN = "access_token";

    /**
     * 默认的请求编码
     */
    protected static final String REQ_CHARSET_UTF_8 = "utf-8";


}
