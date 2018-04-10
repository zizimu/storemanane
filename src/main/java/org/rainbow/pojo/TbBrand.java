package org.rainbow.pojo;

import java.util.Date;

/**
 * 
 * 
 * @author ross
 * 
 * @date 2018-04-10
 */
public class TbBrand {
    private Long brandid;

    private String brandname;

    private Date createtime;

    private String mark;

    public Long getBrandid() {
        return brandid;
    }

    public void setBrandid(Long brandid) {
        this.brandid = brandid;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname == null ? null : brandname.trim();
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