package me.lgblog.pojo;

import java.util.Date;

public class LgBlog {
    private Integer id;

    private String blogTitle;

    private String blogAuthor;

    private String blogPicture;

    private String blogType;

    private String blogDesc;

    private Date blogCreatetime;

    private Integer blogReplyCount;

    private Integer blogUpvoteCount;

    private Integer blogClickCount;

    private String blogContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    public String getBlogAuthor() {
        return blogAuthor;
    }

    public void setBlogAuthor(String blogAuthor) {
        this.blogAuthor = blogAuthor == null ? null : blogAuthor.trim();
    }

    public String getBlogPicture() {
        return blogPicture;
    }

    public void setBlogPicture(String blogPicture) {
        this.blogPicture = blogPicture == null ? null : blogPicture.trim();
    }

    public String getBlogType() {
        return blogType;
    }

    public void setBlogType(String blogType) {
        this.blogType = blogType == null ? null : blogType.trim();
    }

    public String getBlogDesc() {
        return blogDesc;
    }

    public void setBlogDesc(String blogDesc) {
        this.blogDesc = blogDesc == null ? null : blogDesc.trim();
    }

    public Date getBlogCreatetime() {
        return blogCreatetime;
    }

    public void setBlogCreatetime(Date blogCreatetime) {
        this.blogCreatetime = blogCreatetime;
    }

    public Integer getBlogReplyCount() {
        return blogReplyCount;
    }

    public void setBlogReplyCount(Integer blogReplyCount) {
        this.blogReplyCount = blogReplyCount;
    }

    public Integer getBlogUpvoteCount() {
        return blogUpvoteCount;
    }

    public void setBlogUpvoteCount(Integer blogUpvoteCount) {
        this.blogUpvoteCount = blogUpvoteCount;
    }

    public Integer getBlogClickCount() {
        return blogClickCount;
    }

    public void setBlogClickCount(Integer blogClickCount) {
        this.blogClickCount = blogClickCount;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent == null ? null : blogContent.trim();
    }
}