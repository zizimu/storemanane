package org.rainbow.pojo;

import java.io.Serializable;

public class TbStockKey implements Serializable {
    private Long batchId;

    /**
     * 商品编号
     */
    private Long goodsId;

    private static final long serialVersionUID = 1L;

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}