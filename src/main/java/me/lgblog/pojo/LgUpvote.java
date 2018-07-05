package me.lgblog.pojo;

import java.util.Date;

public class LgUpvote {
    private Integer id;

    private Integer blogid;

    private String upvoteIp;

    private Date upvoteTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBlogid() {
        return blogid;
    }

    public void setBlogid(Integer blogid) {
        this.blogid = blogid;
    }

    public String getUpvoteIp() {
        return upvoteIp;
    }

    public void setUpvoteIp(String upvoteIp) {
        this.upvoteIp = upvoteIp == null ? null : upvoteIp.trim();
    }

    public Date getUpvoteTime() {
        return upvoteTime;
    }

    public void setUpvoteTime(Date upvoteTime) {
        this.upvoteTime = upvoteTime;
    }
}