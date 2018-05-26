package org.rainbow.pojo;

import java.io.Serializable;
import java.sql.Date;

public class TbRole implements Serializable {
    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 创建时间
     */
    private Date createTime;
    
    private int status;

    public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	/**
     * 备注
     */
    private String mark;

    private static final long serialVersionUID = 1L;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}