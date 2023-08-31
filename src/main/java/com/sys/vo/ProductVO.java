package com.sys.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * 查询条件
 */
public class ProductVO {
	private Integer id; // 商品编号
    private String productName; // 商品名称
    private String manufacturer; // 生产厂家
    @DateTimeFormat(pattern = "yyyy-MM-dd") //接收时间类型
    private Date productionDate; // 生产日期
    private String model; // 型号
    private double purchasePrice; // 进货价
    private double retailPrice; // 零售价格
    private Integer quantity; // 数量
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Date getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
    
    
}
