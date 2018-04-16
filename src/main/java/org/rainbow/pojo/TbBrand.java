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
public class TbBrand implements Serializable {
    private Long brandId;

    private String brandName;

    private Date createTime;

    private Integer status;

    private String mark;

    private static final long serialVersionUID = 1L;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
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