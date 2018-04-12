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
public class TbStaff implements Serializable {
    /**
     * 员工编号
     */
    private Long staffId;

    /**
     * 员工姓名
     */
    private String staffName;

    /**
     * 联系电话
     */
    private String staffPhone;

    /**
     * 所属门店编号
     */
    private String storeId;

    private Date createTime;

    private Integer status;

    private String mark;

    private static final long serialVersionUID = 1L;

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone == null ? null : staffPhone.trim();
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
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