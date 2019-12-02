package com.fsy.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;


import java.util.Date;


/**
 * <p>
 * 会员浏览记录
 * </p>
 *
 * @author haha
 * @since 2018-10-05
 */
@TableName("t_views_history")
@SuppressWarnings("serial")
public class TViewsHistory extends BaseModel {

    /**
     * 会员ID
     */
    @TableField("member_id")
    private Integer memberId;
    /**
     * 视频Id
     */
    @TableField("video_id")
    private Integer videoId;
    /**
     * 浏览时间
     */
    @TableField("view_time")
    private Date viewTime;


    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Date getViewTime() {
        return viewTime;
    }

    public void setViewTime(Date viewTime) {
        this.viewTime = viewTime;
    }

}