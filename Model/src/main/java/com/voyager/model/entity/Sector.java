package com.voyager.model.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

/**
 * Created by volodymyr.bodnar on 6/19/2017.
 */
public class Sector extends AbstractEntity {
    @Indexed(unique = true)
    private String name;
    private int startX;
    private int startY;

    @DBRef
    private List<MainCharacter> mainCharacters;

    @DBRef
    private List<Planet> planets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }
}
