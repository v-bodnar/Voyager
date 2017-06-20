package com.voyager.model.entity;

/**
 * Created by volodymyr.bodnar on 6/19/2017.
 */
public class Player extends AbstractEntity{
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

        Player player = (Player) o;

        return nickName != null ? nickName.equals(player.nickName) : player.nickName == null;
    }

    @Override
    public int hashCode() {
        return nickName != null ? nickName.hashCode() : 0;
    }
}
