package com.sys.vo;
/**
 * 用户查询条件
 */
public class UserVO {
    private int id;//id
    private String username;//用户名
    private String password;//密码
    private int role;//权限
    private String queryUsername;//查询条件
    private String phoneNumber;
    private String email;

    public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQueryUsername() {
        return queryUsername;
    }

    public void setQueryUsername(String queryUsername) {
        this.queryUsername = queryUsername;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
