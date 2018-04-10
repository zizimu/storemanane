package org.rainbow.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * @author ross
 * 
 * @date 2018-04-10
 */
public class TbOrder {
    /**
     * 订单编号
     */
    private Integer oid;

    /**
     * 商品编号
     */
    private Integer gid;

    /**
     * 商品名称
     */
    private String gname;

    /**
     * 商品数量
     */
    private Integer gnum;

    /**
     * 活动名称
     */
    private Integer pid;

    /**
     * 总价
     */
    private BigDecimal total;

    private Date createtime;

    private String mark;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public Integer getGnum() {
        return gnum;
    }

    public void setGnum(Integer gnum) {
        this.gnum = gnum;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}