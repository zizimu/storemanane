package org.rainbow.pojo;

import java.sql.Date;

public class TbTransfer {
	
	private Long transfer_id;
	
	private Long store_fromid;
	
	private Long store_toid;
	
	private Long goods_id;
	
	private int goods_num;
	
	private Date createtime;
	
	private int status;
	
	private TbStore store;
	
	private TbStore toStore;
	
	private TbGoods goods;

	public Long getTransfer_id() {
		return transfer_id;
	}

	public void setTransfer_id(Long transfer_id) {
		this.transfer_id = transfer_id;
	}

	public Long getStore_fromid() {
		return store_fromid;
	}

	public void setStore_fromid(Long store_fromid) {
		this.store_fromid = store_fromid;
	}

	public Long getStore_toid() {
		return store_toid;
	}

	public void setStore_toid(Long store_toid) {
		this.store_toid = store_toid;
	}

	public Long getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Long goods_id) {
		this.goods_id = goods_id;
	}

	public int getGoods_num() {
		return goods_num;
	}

	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public TbStore getStore() {
		return store;
	}

	public void setStore(TbStore store) {
		this.store = store;
	}

	public TbGoods getGoods() {
		return goods;
	}

	public void setGoods(TbGoods goods) {
		this.goods = goods;
	}

	public TbStore getToStore() {
		return toStore;
	}

	public void setToStore(TbStore toStore) {
		this.toStore = toStore;
	}

	
	

}
