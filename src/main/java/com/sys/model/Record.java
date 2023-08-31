package com.sys.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

//记录
public class Record {
	private int id;//主键
	private int userId;//用户id
	private Timestamp recordTime; // 结算时间
	private String username;//消费人
	private double totalAmount;//总金额
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getTotalAmount() {
		for (Cart cart : carts) {
			totalAmount += cart.getQuantity() * cart.getRetailPrice();
		}
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	private List<Cart> carts = new ArrayList<Cart>();
	
	public List<Cart> getCarts() {
		return carts;
	}
	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Timestamp getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}
	
	
}
