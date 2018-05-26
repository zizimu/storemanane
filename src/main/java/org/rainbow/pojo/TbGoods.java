package org.rainbow.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;


public class TbGoods implements Serializable {
    /**
     * 商品编号
     */
    private Long goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;

    /**
     * 商品类型
     */
    private Long goodsType;

    /**
     * 商品品牌
     */
    private Long goodsBrand;

    /**
     * 格规
     */
    private Integer goodsSpc;

    /**
     * 主图
     */
    private String goodsPic;

    /**
     * 生产日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date goodsCreatedate;

    /**
     * 保质期（整年）
     */
    private Integer goodsShelflife;

    private Date createTime;

    /**
     * 1 正常 2 
     */
    private Integer status;

    private String mark;

    private static final long serialVersionUID = 1L;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Long getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Long goodsType) {
        this.goodsType = goodsType;
    }

    public Long getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(Long goodsBrand) {
        this.goodsBrand = goodsBrand;
    }

    public Integer getGoodsSpc() {
        return goodsSpc;
    }

    public void setGoodsSpc(Integer goodsSpc) {
        this.goodsSpc = goodsSpc;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic == null ? null : goodsPic.trim();
    }

    public Date getGoodsCreatedate() {
        return goodsCreatedate;
    }

    public void setGoodsCreatedate(Date goodsCreatedate) {
        this.goodsCreatedate = goodsCreatedate;
    }

    public Integer getGoodsShelflife() {
        return goodsShelflife;
    }

    public void setGoodsShelflife(Integer goodsShelflife) {
        this.goodsShelflife = goodsShelflife;
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