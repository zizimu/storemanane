package org.rainbow.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class TbOrder implements Serializable {
    /**
     * 订单编号
     */
    private Long orderId;

    /**
     * 商品编号
     */
    private Long goodsId;

    /**
     * 商品数量
     */
    private Integer goodsNum;

    /**
     * 活动名称
     */
    private Integer activityId;

    /**
     * 总价
     */
    private BigDecimal totalPrice;

    private Date createTime;

    /**
     * 1启用 0删除 2取消
     */
    private Integer status;

    private String mark;
    
   private Long store_id;
   
   


	public Long getStore_id() {
		return store_id;
	}

	public void setStore_id(Long store_id) {
		this.store_id = store_id;
	}


	private static final long serialVersionUID = 1L;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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