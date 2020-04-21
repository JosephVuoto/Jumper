package com.xieyangzhe.jumper.model;

import java.util.Date;

/**
 * table name:  url_mapper
 * author name: joseph
 * create time: 2020/04/20 22:15:10
 */
public class UrlModel {

    private int uid;
    private String url;
    private String encoded;
    private Date createTime;
    private Date lastViewTime;
    private int viewCount;
    private boolean hasPassword;
    private String password;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEncoded() {
        return encoded;
    }

    public void setEncoded(String encoded) {
        this.encoded = encoded;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastViewTime() {
        return lastViewTime;
    }

    public void setLastViewTime(Date lastViewTime) {
        this.lastViewTime = lastViewTime;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public boolean getHasPassword() {
        return hasPassword;
    }

    public void setHasPassword(boolean hasPassword) {
        this.hasPassword = hasPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UrlModel{" +
                "uid=" + uid +
                ", url='" + url + '\'' +
                ", encoded='" + encoded + '\'' +
                ", createTime=" + createTime +
                ", lastViewTime=" + lastViewTime +
                ", viewCount=" + viewCount +
                ", hasPassword=" + hasPassword +
                ", password='" + password + '\'' +
                '}';
    }
}

