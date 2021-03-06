package org.rainbow.pojo;

import java.io.Serializable;
import java.sql.Date;

public class TbActivity implements Serializable {
    /**
     * 活动编码
     */
    private int activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动内容
     */
    private String activityContent;

    /**
     * 活动开始时间
     */
    private Date activityStartdate;

    /**
     * 活动结束时间
     */
    private Date activityEnddate;

    private String activityRange;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 1启用
     */
    private Integer status;

    /**
     * 备注
     */
    private String mark;

    private static final long serialVersionUID = 1L;

    public String getActivityRange() {
        return activityRange;
    }

    public void setActivityRange(String activityRange) {
        this.activityRange = activityRange;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(int id) {
        this.activityId = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent == null ? null : activityContent.trim();
    }

    public Date getActivityStartdate() {
        return activityStartdate;
    }

    public void setActivityStartdate(Date activityStartdate) {
        this.activityStartdate = activityStartdate;
    }

    public Date getActivityEnddate() {
        return activityEnddate;
    }

    public void setActivityEnddate(Date activityEnddate) {
        this.activityEnddate = activityEnddate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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