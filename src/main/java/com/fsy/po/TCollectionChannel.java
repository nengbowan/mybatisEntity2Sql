package com.fsy.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;



/**
 * <p>
 * 采集渠道
 * </p>
 *
 * @author haha
 * @since 2018-10-05
 */
@TableName("t_collection_channel")
@SuppressWarnings("serial")
public class TCollectionChannel extends BaseModel {

    /**
     * 渠道名称
     */
    @TableField("channel_name")
    private String channelName;


    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

}