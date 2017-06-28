package com.voyager.model.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Created by volodymyr.bodnar on 6/19/2017.
 */
public class Character extends AbstractEntity{
    private String nickName;
    private UserDetails.Sex sex;

    @DBRef
    private Race race;
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

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Character character = (Character) o;

        if (nickName != null ? !nickName.equals(character.nickName) : character.nickName != null) return false;
        if (sex != character.sex) return false;
        if (race != null ? !race.equals(character.race) : character.race != null) return false;
        return owner != null ? owner.equals(character.owner) : character.owner == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (race != null ? race.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        return result;
    }
}
