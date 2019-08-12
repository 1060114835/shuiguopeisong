package com.example.fruitdelivery.util.TestBean;


import java.util.Date;

public class Results {

    private String _id;
    private Date createdAt;
    private Date desc;
    private Date publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_id() {
        return _id;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setDesc(Date desc) {
        this.desc = desc;
    }
    public Date getDesc() {
        return desc;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }
    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setSource(String source) {
        this.source = source;
    }
    public String getSource() {
        return source;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
    public boolean getUsed() {
        return used;
    }

    public void setWho(String who) {
        this.who = who;
    }
    public String getWho() {
        return who;
    }

}