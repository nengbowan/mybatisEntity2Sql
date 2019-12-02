package com.fsy.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;



/**
 * <p>
 * 
 * </p>
 *
 * @author haha
 * @since 2019-03-24
 */
@TableName("sys_sms")
@SuppressWarnings("serial")
public class SysSms extends BaseModel {

 	@TableField("account_sid")
	private String accountSid;
 	@TableField("auth_token")
	private String authToken;
 	@TableField("sms_flag")
	private String smsFlag;
 	@TableField("sms_key")
 	private String smsKey;

	public String getAccountSid() {
		return accountSid;
	}

	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getSmsFlag() {
		return smsFlag;
	}

	public void setSmsFlag(String smsFlag) {
		this.smsFlag = smsFlag;
	}

	public String getSmsKey() {
		return smsKey;
	}

	public void setSmsKey(String smsKey) {
		this.smsKey = smsKey;
	}
	
	
}