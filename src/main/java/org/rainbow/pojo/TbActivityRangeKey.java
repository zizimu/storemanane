package org.rainbow.pojo;

import java.io.Serializable;

public class TbActivityRangeKey implements Serializable {
    private Long activityId;

    private Long goodsId;

    private static final long serialVersionUID = 1L;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}