package com.voyager.model.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by volodymyr.bodnar on 6/19/2017.
 */
public class Sector extends AbstractEntity {
    @Indexed(unique = true)
    private String name;
    private int startX;
    private int startY;

    @Transient
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    @DBRef
    private List<MainCharacter> mainCharacters = new LinkedList<>();

    @DBRef
    private List<Planet> planets = new LinkedList<>();

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

    public int getMainCharactersCount() {
        readWriteLock.readLock().lock();
        try {
            return mainCharacters.size();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void addCharacterIfNotExist(MainCharacter character) {
        readWriteLock.writeLock().lock();
        try {
            if(!mainCharacters.contains(character)) {
                mainCharacters.add(character);
            }
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void removeCharacterIfExists(MainCharacter character) {
        readWriteLock.writeLock().lock();
        try {
            if(mainCharacters.contains(character)) {
                mainCharacters.remove(character);
            }
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Sector: " + name + " (" + startX + ", " + startY + ")";
    }
}
