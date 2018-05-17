package org.rainbow.pojo;

import java.io.Serializable;
import java.sql.Date;

/**
 * 
 * 
 * @author ross
 * 
 * @date 2018-04-12
 */
public class TbStock extends TbStockKey implements Serializable {
    /**
     * 库存
     */
    private Integer goodsStock;

    /**
     * 已销售数量
     */
    private Integer goodsSold;

    /**
     * 所属门店
     */
    private Long storeId;

    private Date createTime;

    /**
     * 1有货  0售空  2采购中
     */
    private Integer status;

    private String mark;

	private static final long serialVersionUID = 1L;

    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

    public Integer getGoodsSold() {
        return goodsSold;
    }

    public void setGoodsSold(Integer goodsSold) {
        this.goodsSold = goodsSold;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
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