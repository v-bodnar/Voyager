package com.voyager.model.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Created by volodymyr.bodnar on 6/21/2017.
 */
public class MainCharacter extends Character {

    @DBRef
    private Sector sector;

    @DBRef
    private SpaceShip spaceShip;

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public SpaceShip getSpaceShip() {
        return spaceShip;
    }

    public void setSpaceShip(SpaceShip spaceShip) {
        this.spaceShip = spaceShip;
    }
}
