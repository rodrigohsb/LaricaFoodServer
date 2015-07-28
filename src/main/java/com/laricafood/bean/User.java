package com.laricafood.bean;

import java.util.Date;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
public class User {

    private long id;

    private int type;

    private String facebookId;

    private String firstName;

    private String middleName;

    private String lastName;

    private String pictureUrl;

    private Date creationDate;

    public User() {
    }

    public User(long id, int type, String facebookId, String firstName, String middleName, String lastName, String pictureUrl, Date creationDate) {
        this.id = id;
        this.type = type;
        this.facebookId = facebookId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.pictureUrl = pictureUrl;
        this.creationDate = creationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", facebookId='" + facebookId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

}

