package com.fsy.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;


/**
 * <p>
 * 统计表
 * </p>
 *
 * @author haha
 * @since 2018-10-05
 */
@TableName("t_report")
@SuppressWarnings("serial")
public class TReport extends BaseModel {

    /**
     * 用户ID
     */
    @TableField("member_id")
    private Integer memberId;
    /**
     * 使用类型 1=注册 2=登录 3=充值
     */
    @TableField("action_type")
    private Integer actionType;
    /**
     * 当前时间
     */
    @TableField("curent_day")
    private String curentDay;
    /**
     * 充值次数
     */
    @TableField("rechange_num")
    private Integer rechangeNum;
    /**
     * 充值金额
     */
    @TableField("rechange_price")
    private Double rechangePrice;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

    public String getCurentDay() {
        return curentDay;
    }

    public void setCurentDay(String curentDay) {
        this.curentDay = curentDay;
    }

    public Double getRechangePrice() {
        return rechangePrice;
    }

    public void setRechangePrice(Double rechangePrice) {
        this.rechangePrice = rechangePrice;
    }

    public Integer getRechangeNum() {
        return rechangeNum;
    }

    public void setRechangeNum(Integer rechangeNum) {
        this.rechangeNum = rechangeNum;
    }


}