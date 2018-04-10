package org.rainbow.pojo;

import java.util.Date;

/**
 * 
 * 
 * @author ross
 * 
 * @date 2018-04-10
 */
public class TbStore {
    /**
     * 门店编号
     */
    private Integer sid;

    /**
     * 门店名称
     */
    private String sname;

    /**
     * 所属地区
     */
    private String sarea;

    /**
     * 详细地址
     */
    private String saddress;

    /**
     * 门店主管
     */
    private String smanager;

    /**
     * 主管电话
     */
    private String mtel;

    /**
     * 注册日期
     */
    private Date sdate;

    /**
     * 备注
     */
    private String mark;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSarea() {
        return sarea;
    }

    public void setSarea(String sarea) {
        this.sarea = sarea == null ? null : sarea.trim();
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress == null ? null : saddress.trim();
    }

    public String getSmanager() {
        return smanager;
    }

    public void setSmanager(String smanager) {
        this.smanager = smanager == null ? null : smanager.trim();
    }

    public String getMtel() {
        return mtel;
    }

    public void setMtel(String mtel) {
        this.mtel = mtel == null ? null : mtel.trim();
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}