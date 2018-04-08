package com.github.gary.mp.bean.menu;

import com.github.gary.mp.bean.BaseResult;

import java.util.List;


public class Menu extends BaseResult {

    /**
     * 默认菜单
     */
    private MenuButtons menu;

    /**
     * 个性化菜单列表
     */
    private List<MenuButtons> conditionalmenu;

    /**
     * 微信返回的菜单id
     */
    private String menuid;

    public MenuButtons getMenu() {
        return menu;
    }

    public void setMenu(MenuButtons menu) {
        this.menu = menu;
    }

    public List<MenuButtons> getConditionalmenu() {
        return conditionalmenu;
    }

    public void setConditionalmenu(List<MenuButtons> conditionalmenu) {
        this.conditionalmenu = conditionalmenu;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }
}
