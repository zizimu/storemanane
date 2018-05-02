package org.rainbow.pojo;

import java.io.Serializable;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-05-02
 */
public class TbAccount implements Serializable {
    /**
     * 主键
     */
    private Long sid;

    /**
     * 登陆名
     */
    private String loginname;

    /**
     * 密码
     */
    private String password;

    /**
     * 账号状态，0为封禁;1为正常;2及以上越大权限越大
     */
    private Integer status;

    /**
     * 备注
     */
    private String mark;

    private static final long serialVersionUID = 1L;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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