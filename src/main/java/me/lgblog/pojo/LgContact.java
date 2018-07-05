package me.lgblog.pojo;

import java.util.Date;

public class LgContact {
    private Integer id;

    private String contactName;

    private String contactEmail;

    private Date contactCreatetime;

    private String contactMessage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    public Date getContactCreatetime() {
        return contactCreatetime;
    }

    public void setContactCreatetime(Date contactCreatetime) {
        this.contactCreatetime = contactCreatetime;
    }

    public String getContactMessage() {
        return contactMessage;
    }

    public void setContactMessage(String contactMessage) {
        this.contactMessage = contactMessage == null ? null : contactMessage.trim();
    }
}