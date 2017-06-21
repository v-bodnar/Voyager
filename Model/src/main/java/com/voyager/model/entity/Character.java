package com.voyager.model.entity;

/**
 * Created by volodymyr.bodnar on 6/19/2017.
 */
public class Character extends AbstractEntity{
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Character character = (Character) o;

        return nickName != null ? nickName.equals(character.nickName) : character.nickName == null;
    }

    @Override
    public int hashCode() {
        return nickName != null ? nickName.hashCode() : 0;
    }
}
