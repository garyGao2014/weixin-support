package com.github.gary.mp.bean;

import com.alibaba.fastjson.JSON;

/**
 * @author garygao
 **/
public class BaseResult {

    private final static String SUCCESS_CODE = "0";

    /**
     * 错误码(注意:errcode=0是代表成功)
     */
    private String errcode;
    /**
     * 错误码官方解释
     */
    private String errmsg;

    /**
     * 错误码中文解释
     */
    private String errmsgcn;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getErrmsgcn() {
        return ReturnCode.get(errcode);
    }

    public boolean isSuccess() {
        return errcode == null || errcode.isEmpty() || SUCCESS_CODE.equals(errcode);
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }
}
