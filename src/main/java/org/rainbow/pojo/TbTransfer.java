package org.rainbow.pojo;

import java.sql.Date;

public class TbTransfer {
	
	private Long transferId;
	
	private Long storeFromId;
	
	private Long storeToId;
	
	private Long goodsId;
	
	private int goodsNum;
	
	private Date createTime;
	
	private int status;

	public Long getTransferId() {
		return transferId;
	}

	public void setTransferId(Long transferId) {
		this.transferId = transferId;
	}

	public Long getStoreFromId() {
		return storeFromId;
	}

	public void setStoreFromId(Long storeFromId) {
		this.storeFromId = storeFromId;
	}

	public Long getStoreToId() {
		return storeToId;
	}

	public void setStoreToId(Long storeToId) {
		this.storeToId = storeToId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
