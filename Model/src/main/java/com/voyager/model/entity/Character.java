package com.voyager.model.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Created by volodymyr.bodnar on 6/19/2017.
 */
public class Character extends AbstractEntity{
    private String nickName;
    private UserDetails.Sex sex;

    @DBRef
    private User owner;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public UserDetails.Sex getSex() {
        return sex;
    }

    public void setSex(UserDetails.Sex sex) {
        this.sex = sex;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
