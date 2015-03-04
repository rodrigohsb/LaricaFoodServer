package com.laricafood.bean;

import java.util.Date;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
public class User {

    private long facebookId;

    private UserType type;

    private Date createDate;

    private Date updateDate;

    public User() {
        super();
    }

    public User(long facebookId, UserType type, Date createDate, Date updateDate) {
        super();
        this.facebookId = facebookId;
        this.type = type;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public long getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(long facebookId) {
        this.facebookId = facebookId;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "User [facebookId=" + facebookId + ", type=" + type + ", createDate=" + createDate + ", updateDate="
                + updateDate + "]";
    }

}

