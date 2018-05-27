package org.rainbow.pojo;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TbStore implements Serializable {
	/**
	 * 门店编号
	 */
	private Long storeId;

	/**
	 * 门店名称
	 */
	private String storeName;

	/**
	 * 所属地区
	 */
	private String storeArea;

	/**
	 * 详细地址
	 */
	private String storeAddress;

	/**
	 * 门店主管
	 */
	private String storeManager;

	/**
	 * 主管电话
	 */
	private String staffPhone;

	/**
	 * 注册日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createTime;

	/**
	 * 1店铺存在
	 */
	private Integer status;


	private String mark;
	/**
	 * 是否总部
	 */
	private int ishead;
	
	public int getIshead() {
		return ishead;
	}

	public void setIshead(int ishead) {
		this.ishead = ishead;
	}

	private static final long serialVersionUID = 1L;

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName == null ? null : storeName.trim();
	}

	public String getStoreArea() {
		return storeArea;
	}

	public void setStoreArea(String storeArea) {
		this.storeArea = storeArea == null ? null : storeArea.trim();
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress == null ? null : storeAddress.trim();
	}

	public String getStoreManager() {
		return storeManager;
	}

	public void setStoreManager(String storeManager) {
		this.storeManager = storeManager == null ? null : storeManager.trim();
	}

	public String getStaffPhone() {
		return staffPhone;
	}

	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone == null ? null : staffPhone.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark == null ? null : mark.trim();
	}
}