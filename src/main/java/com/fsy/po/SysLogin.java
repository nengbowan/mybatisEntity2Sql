package com.fsy.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;


@TableName("sys_login")
@SuppressWarnings("serial")
public class SysLogin extends BaseModel {

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;
    /**
     * 用户名
     */
    @TableField("sys_name")
    private String sysName;
    /**
     * 密码
     */
    @TableField("sys_pwd")
    private String sysPwd;
    /**
     * 是否可用 0=否 1=是
     */
    @TableField("is_enable")
    private Integer isEnable;

    @TableField(exist = false)
    private String roleId;


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSysPwd() {
        return sysPwd;
    }

    public void setSysPwd(String sysPwd) {
        this.sysPwd = sysPwd;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }


}