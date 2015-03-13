package com.laricafood.bean;

import java.util.Date;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
public class User {

    private long id;

    private UserType userType;

    private Date createDate;

    private Date updateDate;

    public User() {
        super();
    }

    public User(long id, UserType userType, Date createDate, Date updateDate) {
        super();
        this.id = id;
        this.userType = userType;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType type) {
        this.userType = type;
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
        return "User [id=" + id + ", userType=" + userType + ", createDate=" + createDate + ", updateDate="
                + updateDate + "]";
    }

}

