package me.lgblog.pojo;

public class LgType {
    private Integer id;

    private String lgType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLgType() {
        return lgType;
    }

    public void setLgType(String lgType) {
        this.lgType = lgType == null ? null : lgType.trim();
    }
}