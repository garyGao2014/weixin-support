package com.github.gary.bean.menu;

/**
 * @author garygao
 **/
public class MenuButtons {

    /**
     * 菜单内容
     */
    private Button[] button;
    /**
     * 个性化菜单规则
     */
    private Matchrule matchrule;

    /**
     * 菜单id
     */
    private String menuid;

    public MenuButtons() {
    }

    public MenuButtons(Button[] button) {
        this.button = button;
    }

    public Button[] getButton() {
        return button;
    }

    public void setButton(Button[] button) {
        this.button = button;
    }

    public Matchrule getMatchrule() {
        return matchrule;
    }

    public void setMatchrule(Matchrule matchrule) {
        this.matchrule = matchrule;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }
}
