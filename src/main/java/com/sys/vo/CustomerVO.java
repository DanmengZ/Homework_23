package com.sys.vo;

import java.sql.Timestamp;

import com.sys.model.User;

/**
 * 查询条件
 */
public class CustomerVO {
	private Integer id; // 客户ID
    private String userLevel; // 用户级别（金牌客户、银牌客户、铜牌客户）
    private Timestamp registerTime; // 用户注册时间
    private double totalConsumption; // 客户累计消费总金额
    private String phoneNumber; // 用户手机号
    private String email; // 用户邮箱
    private String username;
    private String password;
    
    public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private int userId;
    public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private User user;
    
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserLevel() {
		if(totalConsumption>1000 && totalConsumption < 20000)return "银牌客户";
		if(totalConsumption>=20000)return "金牌客户";
		return "铜牌客户";
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	public Timestamp getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}
	public double getTotalConsumption() {
		return totalConsumption;
	}
	public void setTotalConsumption(double totalConsumption) {
		this.totalConsumption = totalConsumption;
	}
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
}
