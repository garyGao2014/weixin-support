package com.github.gary.bean.token;

import com.alibaba.fastjson.JSON;
import com.github.gary.bean.BaseResult;

/**
 * @author garygao
 **/
public class Token extends BaseResult {
    private String access_token;
    /**
     * access_token有效期
     */
    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
