package me.lgblog.pojo;

public class LgLinks {
    private Integer id;

    private String userLink;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserLink() {
        return userLink;
    }

    public void setUserLink(String userLink) {
        this.userLink = userLink == null ? null : userLink.trim();
    }
}