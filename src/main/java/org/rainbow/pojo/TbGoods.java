package org.rainbow.pojo;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * 
 * 
 * @author ross
 * 
 * @date 2018-04-10
 */
public class TbGoods {
    /**
     * 商品编号
     */
    private Long gid;

    /**
     * 商品名称
     */
    private String gname;

    /**
     * 商品价格
     */
    private BigDecimal gprice;

    /**
     * 商品类型
     */
    private Long gtype;

    /**
     * 商品品牌
     */
    private Long gbrand;

    /**
     * 格规
     */
    private Integer gspc;

    private String gpic;

    /**
     * 生产日期
     */
    private Date gcreatedate;

    /**
     * 保质期（整年）
     */
    private Integer gshelflife;

    private String mark;

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public BigDecimal getGprice() {
        return gprice;
    }

    public void setGprice(BigDecimal gprice) {
        this.gprice = gprice;
    }

    public Long getGtype() {
        return gtype;
    }

    public void setGtype(Long gtype) {
        this.gtype = gtype;
    }

    public Long getGbrand() {
        return gbrand;
    }

    public void setGbrand(Long gbrand) {
        this.gbrand = gbrand;
    }

    public Integer getGspc() {
        return gspc;
    }

    public void setGspc(Integer gspc) {
        this.gspc = gspc;
    }

    public String getGpic() {
        return gpic;
    }

    public void setGpic(String gpic) {
        this.gpic = gpic == null ? null : gpic.trim();
    }

    public Date getGcreatedate() {
        return gcreatedate;
    }

    public void setGcreatedate(Date gcreatedate) {
        this.gcreatedate = gcreatedate;
    }

    public Integer getGshelflife() {
        return gshelflife;
    }

    public void setGshelflife(Integer gshelflife) {
        this.gshelflife = gshelflife;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}