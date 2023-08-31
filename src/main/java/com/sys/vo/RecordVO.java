package com.sys.vo;

import java.sql.Timestamp;

//记录
public class RecordVO {
	private int id;//主键
	private int userId;//用户id
	private Timestamp recordTime; // 结算时间
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
