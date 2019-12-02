package com.fsy.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;



/**
 * <p>
 * 会员卡信息表
 * </p>
 *
 * @author haha
 * @since 2018-10-05
 */
@TableName("t_vip")
@SuppressWarnings("serial")
public class TVip extends BaseModel {

    /**
     * 会员卡类型 1=月卡 2=季卡 3= 年卡
     */
    @TableField("card_type")
    private Integer cardType;
    /**
     * 价格
     */
    private Double price;
    /**
     * 缓存次数
     */
    @TableField("cache_num")
    private Integer cacheNum;


    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCacheNum() {
        return cacheNum;
    }

    public void setCacheNum(Integer cacheNum) {
        this.cacheNum = cacheNum;
    }

}