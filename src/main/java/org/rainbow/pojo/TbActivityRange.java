package org.rainbow.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author ross
 * 
 * @date 2018-04-12
 */
public class TbActivityRange extends TbActivityRangeKey implements Serializable {
    private Date createTime;

    private Integer status;

    private String mark;

    private static final long serialVersionUID = 1L;

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