package org.rainbow.pojo;

import java.util.Date;

/**
 * 
 * 
 * @author ross
 * 
 * @date 2018-04-10
 */
public class TbGoodstype {
    private Long typeid;

    private String typename;

    private Date createtime;

    private String mark;

    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
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