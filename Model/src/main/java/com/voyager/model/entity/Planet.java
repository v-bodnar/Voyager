package com.voyager.model.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

/**
 * Created by volodymyr.bodnar on 6/18/2017.
 */
public class Planet extends SpaceBody{
    @Transient
    public static final int MIN_SIZE = 100;
    @Transient
    public static final int MAX_SIZE = 100000;
    @Transient
    public static final int MIN_POPULATION = 10;
    @Transient
    public static final int MAX_POPULATION = 100000;

    private String name;
    private String description;
    private Type type;
    private int size;
    private int population;
    private boolean homeplanetPossible;
    @DBRef
    private List<Location> locations;
    @DBRef
    private Sector sector;
    @DBRef
    private Race inhabitants;
    @DBRef
    private Religion religion;
    @DBRef
    private Politics politics;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isHomeplanetPossible() {
        return homeplanetPossible;
    }

    public void setHomeplanetPossible(boolean homeplanetPossible) {
        this.homeplanetPossible = homeplanetPossible;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Race getInhabitants() {
        return inhabitants;
    }

    public void setInhabitants(Race inhabitants) {
        this.inhabitants = inhabitants;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public Politics getPolitics() {
        return politics;
    }

    public void setPolitics(Politics politics) {
        this.politics = politics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Planet planet = (Planet) o;

        if (size != planet.size) return false;
        if (population != planet.population) return false;
        if (homeplanetPossible != planet.homeplanetPossible) return false;
        if (name != null ? !name.equals(planet.name) : planet.name != null) return false;
        if (description != null ? !description.equals(planet.description) : planet.description != null) return false;
        if (type != planet.type) return false;
        if (locations != null ? !locations.equals(planet.locations) : planet.locations != null) return false;
        if (sector != null ? !sector.equals(planet.sector) : planet.sector != null) return false;
        if (inhabitants != null ? !inhabitants.equals(planet.inhabitants) : planet.inhabitants != null) return false;
        if (religion != null ? !religion.equals(planet.religion) : planet.religion != null) return false;
        return politics != null ? politics.equals(planet.politics) : planet.politics == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + size;
        result = 31 * result + population;
        result = 31 * result + (homeplanetPossible ? 1 : 0);
        result = 31 * result + (locations != null ? locations.hashCode() : 0);
        result = 31 * result + (sector != null ? sector.hashCode() : 0);
        result = 31 * result + (inhabitants != null ? inhabitants.hashCode() : 0);
        result = 31 * result + (religion != null ? religion.hashCode() : 0);
        result = 31 * result + (politics != null ? politics.hashCode() : 0);
        return result;
    }

    public enum Type{
        VOLCANIC, GAS_GIANT, DESERT, ICE_GIANT, OCEAN_PLANET, TERRESTIAL_PLANET;
    }

}
