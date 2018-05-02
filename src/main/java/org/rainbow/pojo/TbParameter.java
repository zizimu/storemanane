package org.rainbow.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author ross
 * 
 * @date 2018-04-02
 */
public class TbParameter implements Serializable {
    /**
     * 参数ID
     */
    private Integer parameterid;

    /**
     * 参数名
     */
    private String parametername;

    /**
     * 参数内容
     */
    private String parametercontent;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 备注
     */
    private String mark;

    private static final long serialVersionUID = 1L;

    public Integer getParameterid() {
        return parameterid;
    }

    public void setParameterid(Integer parameterid) {
        this.parameterid = parameterid;
    }

    public String getParametername() {
        return parametername;
    }

    public void setParametername(String parametername) {
        this.parametername = parametername == null ? null : parametername.trim();
    }

    public String getParametercontent() {
        return parametercontent;
    }

    public void setParametercontent(String parametercontent) {
        this.parametercontent = parametercontent == null ? null : parametercontent.trim();
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