package org.rainbow.pojo;

/**
 * 
 * 
 * @author ross
 * 
 * @date 2018-04-10
 */
public class TbStockManage {
    /**
     * 商品编号
     */
    private Integer gid;

    /**
     * 库存
     */
    private Integer gstock;

    /**
     * 已销售数量
     */
    private Integer gsold;

    /**
     * 所属门店
     */
    private Integer sid;

    private String mark;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getGstock() {
        return gstock;
    }

    public void setGstock(Integer gstock) {
        this.gstock = gstock;
    }

    public Integer getGsold() {
        return gsold;
    }

    public void setGsold(Integer gsold) {
        this.gsold = gsold;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}