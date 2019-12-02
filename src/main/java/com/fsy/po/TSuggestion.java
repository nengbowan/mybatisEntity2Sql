package com.fsy.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;



/**
 * <p>
 * 意见反馈
 * </p>
 *
 * @author haha
 * @since 2018-10-05
 */
@TableName("t_suggestion")
@SuppressWarnings("serial")
public class TSuggestion extends BaseModel {

    /**
     * 会员ID
     */
    @TableField("member_id")
    private Integer memberId;
    /**
     * 意见内容
     */
    @TableField("suggestion_content")
    private String suggestionContent;


    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getSuggestionContent() {
        return suggestionContent;
    }

    public void setSuggestionContent(String suggestionContent) {
        this.suggestionContent = suggestionContent;
    }

}