package com.gt.inside.api.dto;

import java.util.List;

/**
 * 用户DTO
 * Created by psr on 2017/10/19 0019.
 */
public class UserDTO {

    private Integer userId; // 用户id

    private String userName; // 用户名

    private Integer roleStatus; // 权限状态

    private List<MenuDTO> menuDTOList; // 菜单

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }

    public List<MenuDTO> getMenuDTOList() {
        return menuDTOList;
    }

    public void setMenuDTOList(List<MenuDTO> menuDTOList) {
        this.menuDTOList = menuDTOList;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", roleStatus=" + roleStatus +
                ", menuDTOList=" + menuDTOList +
                '}';
    }
}
