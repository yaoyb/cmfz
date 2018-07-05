package com.baizhi.cmfz.entity;

/**
 * Created by 姚亚博 on 2018/7/5.
 */
public class Menu {
    private String id;
    private String menu_name;
    private String menu_icon;
    private String menu_url;
    private String menu_level;
    private String menu_parent_id;

    public Menu() {
    }

    public Menu(String id, String menu_name, String menu_icon, String menu_url, String menu_level, String menu_parent_id) {
        this.id = id;
        this.menu_name = menu_name;
        this.menu_icon = menu_icon;
        this.menu_url = menu_url;
        this.menu_level = menu_level;
        this.menu_parent_id = menu_parent_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_icon() {
        return menu_icon;
    }

    public void setMenu_icon(String menu_icon) {
        this.menu_icon = menu_icon;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public String getMenu_level() {
        return menu_level;
    }

    public void setMenu_level(String menu_level) {
        this.menu_level = menu_level;
    }

    public String getMenu_parent_id() {
        return menu_parent_id;
    }

    public void setMenu_parent_id(String menu_parent_id) {
        this.menu_parent_id = menu_parent_id;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", menu_name='" + menu_name + '\'' +
                ", menu_icon='" + menu_icon + '\'' +
                ", menu_url='" + menu_url + '\'' +
                ", menu_level='" + menu_level + '\'' +
                ", menu_parent_id='" + menu_parent_id + '\'' +
                '}';
    }
}
