package com.fsy.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;



/**
 * <p>
 * 点赞次数
 * </p>
 *
 * @author haha
 * @since 2018-10-05
 */
@TableName("t_care_times")
@SuppressWarnings("serial")
public class TCareTimes extends BaseModel {

    /**
     * 类型 1=赞成 2=反对
     */
    @TableField("care_type")
    private Integer careType;
    /**
     * 视频ID
     */
    @TableField("video_id")
    private Integer videoId;
    /**
     * 会员ID
     */
    @TableField("member_id")
    private Integer memberId;


    public Integer getCareType() {
        return careType;
    }

    public void setCareType(Integer careType) {
        this.careType = careType;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

}