package org.rainbow.pojo;

import java.io.Serializable;
import java.sql.Date;


public class TbGoodsType implements Serializable {
    private Long typeId;

    private String typeName;

    private Date createTime;

    private Integer status;

    private String mark;

    private String units;

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    private static final long serialVersionUID = 1L;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
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