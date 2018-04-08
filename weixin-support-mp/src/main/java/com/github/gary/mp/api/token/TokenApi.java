package com.github.gary.mp.api.token;

import com.github.gary.mp.api.BaseApi;
import com.github.gary.mp.bean.token.Token;
import com.github.gary.mp.client.LocalHttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

/**
 * access_token api
 *
 * @author garygao
 **/
public class TokenApi extends BaseApi {
    /**
     * 获取access_token uri
     */
    private static final String TOKEN = "/cgi-bin/token";

    private static final String GRANT_TYPE = "client_credential";

    /**
     * 获取access_token
     *
     * @param appid  微信appid
     * @param secret 微信appsecret
     * @return
     */
    public static Token token(String appid, String secret) {
        HttpUriRequest request = RequestBuilder.get()
                .setUri(BASE_URI + TOKEN)
                .addParameter("grant_type", GRANT_TYPE)
                .addParameter("appid", appid)
                .addParameter("secret", secret)
                .build();
        return LocalHttpClient.executeJsonResult(request, Token.class);
    }
}
