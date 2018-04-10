package org.rainbow.pojo;

/**
 * 
 * 
 * @author ross
 * 
 * @date 2018-04-10
 */
public class TbPreact {
    /**
     * 活动编码
     */
    private Integer pid;

    /**
     * 活动名称
     */
    private String pname;

    /**
     * 活动内容
     */
    private String pact;

    /**
     * 备注
     */
    private String mark;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getPact() {
        return pact;
    }

    public void setPact(String pact) {
        this.pact = pact == null ? null : pact.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}