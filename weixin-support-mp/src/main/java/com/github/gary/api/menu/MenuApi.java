package com.github.gary.api.menu;

import com.github.gary.api.BaseApi;
import com.github.gary.api.token.TokenApi;
import com.github.gary.bean.BaseResult;
import com.github.gary.bean.menu.*;
import com.github.gary.bean.token.Token;
import com.github.gary.client.LocalHttpClient;
import com.github.gary.tool.JsonTool;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author garygao
 **/
public class MenuApi extends BaseApi {
    /**
     * 默认菜单创建uri
     */
    private final static String CREATE = "/cgi-bin/menu/create";
    /**
     * 默认菜单获取uri(包含默认菜单和个性化菜单)
     */
    private final static String GET = "/cgi-bin/menu/get";
    /**
     * 删除所有菜单uri(包含默认菜单和个性化菜单)
     */
    private final static String DELETE = "/cgi-bin/menu/delete";
    /**
     * 个性化菜单新增uri
     */
    private final static String ADDCONDITIONAL = "/cgi-bin/menu/addconditional";
    /**
     * 个性化菜单删除uri
     */
    private final static String DELCONDITIONAL = "/cgi-bin/menu/delconditional";
    /**
     * 测试个性化菜单匹配结果uri
     */
    private final static String TRYMATCH = "/cgi-bin/menu/trymatch";

    /**
     * 自定义菜单[创建]接口(包含默认菜单和个性化菜单)
     *
     * @param access_token
     * @param menuJson     菜单json结构
     * @return
     */
    public static BaseResult menuCreate(String access_token, String menuJson) {
        HttpUriRequest request = RequestBuilder.post()
                .setUri(BASE_URI + CREATE)
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setHeader(jsonHeader)
                .setEntity(new StringEntity(menuJson, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(request, BaseResult.class);
    }

    /**
     * 自定义菜单[创建]接口(包含默认菜单和个性化菜单)
     *
     * @param access_token
     * @param menu         菜单实体结构
     * @return
     */
    public static BaseResult menuCreate(String access_token, MenuButtons menu) {
        return menuCreate(access_token, JsonTool.toJSONString(menu));
    }

    /**
     * 自定义菜单[查询]接口
     *
     * @param access_token
     * @return
     */
    public static Menu menuGet(String access_token) {
        HttpUriRequest request = RequestBuilder.get()
                .setUri(BASE_URI + GET)
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .build();
        return LocalHttpClient.executeJsonResult(request, Menu.class);
    }

    /**
     * 自定义菜单[删除]接口(包含默认菜单和个性化菜单)
     *
     * @param access_token
     * @return
     */
    public static BaseResult menuDelete(String access_token) {
        HttpUriRequest request = RequestBuilder.get()
                .setUri(BASE_URI + DELETE)
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .build();
        return LocalHttpClient.executeJsonResult(request, BaseResult.class);
    }

    /**
     * 个性化菜单[创建]接口
     *
     * @param access_token
     * @param menuButtons
     * @return
     */
    public static Menu menuAddConditional(String access_token, MenuButtons menuButtons) {
        return menuAddConditional(access_token, JsonTool.toJSONString(menuButtons));
    }

    /**
     * 个性化菜单[创建]接口
     *
     * @param access_token
     * @param menuJson     菜单json结构
     * @return
     */
    public static Menu menuAddConditional(String access_token, String menuJson) {
        HttpUriRequest request = RequestBuilder.post()
                .setUri(BASE_URI + ADDCONDITIONAL)
                .setHeader(jsonHeader)
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(menuJson, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(request, Menu.class);
    }

    /**
     * 个性化菜单[删除]接口
     *
     * @param access_token
     * @param menuid       菜单实体结构
     * @return
     */
    public static BaseResult menuDelConditional(String access_token, String menuid) {
        HttpUriRequest request = RequestBuilder.post()
                .setUri(BASE_URI + DELCONDITIONAL)
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity("{\"menuid\":\"" + menuid + "\"}", Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(request, BaseResult.class);
    }

    /**
     * 测试个性化菜单匹配结果
     *
     * @param access_token
     * @param user_id      user_id可以是粉丝的OpenID，也可以是粉丝的微信号。
     * @return
     */
    public static Menu menuTryMatch(String access_token, String user_id) {
        HttpUriRequest request = RequestBuilder.post()
                .setUri(BASE_URI + TRYMATCH)
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity("{\"user_id\":\"" + user_id + "\"}", Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(request, Menu.class);
    }
}
