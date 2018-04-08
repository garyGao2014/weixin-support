package com.github.gary.bean.menu;

/**
 * @author garygao
 **/
public enum ButtonType {
    /**
     * 点击类型
     */
    click(),
    /**
     * 网页类型
     */
    view(),
    /**
     * 扫码带提示类型
     */
    scancode_waitmsg(),
    /**
     * 扫码推事件类型
     */
    scancode_push(),
    /**
     * 系统拍照发图片类型
     */
    pic_sysphoto(),
    /**
     * 拍照或者相册发图类型
     */
    pic_photo_or_album(),
    /**
     * 微信相册发图类型
     */
    pic_weixin(),
    /**
     * 发送位置类型
     */
    location_select(),
    media_id(),
    view_limited(),
    /**
     * 小程序类型
     */
    miniprogram;
}
