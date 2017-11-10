package com.gt.inside.api.dto;

import java.util.List;

/**
 * 菜单DTO
 * Created by psr on 2017/10/19 0019.
 */
public class MenuDTO {

    /**
     * 菜单id
     */
    private Integer id;

    /**
     * 父菜单id
     */
    private Integer pId;

    /**
     * 菜单名
     */
    private String menuName;
    /**
     * 菜单路径
     */
    private String menuUrl;
    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 子菜单（0：无，1：有）
     */
    private Integer menuSub;

    /**
     * 子菜单
     */
    private List<MenuDTO> subMenuList;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public List<MenuDTO> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<MenuDTO> subMenuList) {
        this.subMenuList = subMenuList;
    }

    public Integer getMenuSub() {
        return menuSub;
    }

    public void setMenuSub(Integer menuSub) {
        this.menuSub = menuSub;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "id=" + id +
                ", pId=" + pId +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuSub=" + menuSub +
                ", subMenuList=" + subMenuList +
                '}';
    }
}
