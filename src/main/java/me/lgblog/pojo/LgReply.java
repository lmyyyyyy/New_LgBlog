package me.lgblog.pojo;

import java.util.Date;

public class LgReply {
    private Integer id;

    private String replyUsername;

    private String replyEmail;

    private String replyWebsite;

    private Date replyCreatetime;

    private Integer lgBlogId;

    private String replyIp;

    private String replyContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReplyUsername() {
        return replyUsername;
    }

    public void setReplyUsername(String replyUsername) {
        this.replyUsername = replyUsername == null ? null : replyUsername.trim();
    }

    public String getReplyEmail() {
        return replyEmail;
    }

    public void setReplyEmail(String replyEmail) {
        this.replyEmail = replyEmail == null ? null : replyEmail.trim();
    }

    public String getReplyWebsite() {
        return replyWebsite;
    }

    public void setReplyWebsite(String replyWebsite) {
        this.replyWebsite = replyWebsite == null ? null : replyWebsite.trim();
    }

    public Date getReplyCreatetime() {
        return replyCreatetime;
    }

    public void setReplyCreatetime(Date replyCreatetime) {
        this.replyCreatetime = replyCreatetime;
    }

    public Integer getLgBlogId() {
        return lgBlogId;
    }

    public void setLgBlogId(Integer lgBlogId) {
        this.lgBlogId = lgBlogId;
    }

    public String getReplyIp() {
        return replyIp;
    }

    public void setReplyIp(String replyIp) {
        this.replyIp = replyIp == null ? null : replyIp.trim();
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }
}