package com.github.gary.api;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;

/**
 * @author garygao
 **/
public abstract class BaseApi {
    protected final static String BASE_URI = "https://api.weixin.qq.com";

    protected static Header jsonHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
    protected static Header xmlHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_XML.toString());

    protected static final String PARAM_ACCESS_TOKEN = "access_token";

}
