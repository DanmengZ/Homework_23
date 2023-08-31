package com.sys.model;

/**
 * 用户表
 */
public class User {
    private int id; //id
    private String username;//用户名
    private String password;//密码
    private int role;//权限 0 普通用户 1 管理员

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
