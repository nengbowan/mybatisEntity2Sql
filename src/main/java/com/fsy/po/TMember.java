package com.fsy.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;


import java.util.Date;


/**
 * <p>
 * 会员信息
 * </p>
 *
 * @author haha
 * @since 2018-10-05
 */
@TableName("t_member")
@SuppressWarnings("serial")
public class TMember extends BaseModel {

    /**
     * 手机号
     */
    private String tel;
    /**
     * 头像
     */
    private String headpic;
    /**
     * 1=男 2=女 3=未知
     */
    private Integer sex;
    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;
    /**
     * 级别ID
     */
    @TableField("level_id")
    private Integer levelId;
    /**
     * 每日观影次数
     */
    @TableField("view_num")
    private Integer viewNum;
    /**
     * 已使用次数
     */
    @TableField("used_view_num")
    private Integer usedViewNum;
    /**
     * 每日缓存次数
     */
    @TableField("cache_num")
    private Integer cacheNum;
    /**
     * 已使用缓存次数
     */
    @TableField("used_cache_num")
    private Integer usedCacheNum;
    /**
     * 是否为VIP  0=否 1=是
     */
    @TableField("is_vip")
    private Integer isVip;
    /**
     * vipID
     */
    @TableField("vip_id")
    private Integer vipId;
    /**
     * VIP截止时间
     */
    @TableField("vip_date")
    private Date vipDate;
    /**
     * 是否强制提醒 0=否 1=是
     */
    @TableField("is_remind")
    private Integer isRemind;
    /**
     * 推广码
     */
    @TableField("extension_code")
    private String extensionCode;

    /**
     * 钻石数
     */
    @TableField("cron_num")
    private Integer cronNum;

    /**
     * 临时观影次数
     */
    @TableField("tmp_view_num")
    private Integer tmpViewNum;

    /**
     * 是否保存二维码
     */
    @TableField("is_save_qr")
    private Integer isSaveQr;


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    public Integer getUsedViewNum() {
        return usedViewNum;
    }

    public void setUsedViewNum(Integer usedViewNum) {
        this.usedViewNum = usedViewNum;
    }

    public Integer getCacheNum() {
        return cacheNum;
    }

    public void setCacheNum(Integer cacheNum) {
        this.cacheNum = cacheNum;
    }

    public Integer getUsedCacheNum() {
        return usedCacheNum;
    }

    public void setUsedCacheNum(Integer usedCacheNum) {
        this.usedCacheNum = usedCacheNum;
    }

    public Integer getIsVip() {
        return isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    public Integer getVipId() {
        return vipId;
    }

    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    public Date getVipDate() {
        return vipDate;
    }

    public void setVipDate(Date vipDate) {
        this.vipDate = vipDate;
    }

    public Integer getIsRemind() {
        return isRemind;
    }

    public void setIsRemind(Integer isRemind) {
        this.isRemind = isRemind;
    }

    public String getExtensionCode() {
        return extensionCode;
    }

    public void setExtensionCode(String extensionCode) {
        this.extensionCode = extensionCode;
    }

    public Integer getCronNum() {
        return cronNum;
    }

    public void setCronNum(Integer cronNum) {
        this.cronNum = cronNum;
    }

    public Integer getTmpViewNum() {
        return tmpViewNum;
    }

    public void setTmpViewNum(Integer tmpViewNum) {
        this.tmpViewNum = tmpViewNum;
    }

    public Integer getIsSaveQr() {
        return isSaveQr;
    }

    public void setIsSaveQr(Integer isSaveQr) {
        this.isSaveQr = isSaveQr;
    }


}