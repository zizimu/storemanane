package org.rainbow.pojo;

/**
 * 
 * 
 * @author ross
 * 
 * @date 2018-04-10
 */
public class TbStaff {
    /**
     * 员工编号
     */
    private Integer uid;

    /**
     * 员工姓名
     */
    private String uname;

    /**
     * 所属门店编号
     */
    private String sid;

    private String mark;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}