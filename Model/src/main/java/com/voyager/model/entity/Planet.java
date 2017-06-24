package com.voyager.model.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

/**
 * Created by volodymyr.bodnar on 6/18/2017.
 */
public class Planet extends SpaceBody{
    @Transient
    public static final int MAX_SIZE = 100000;
    @Transient
    public static final long MAX_POPULATION = 100000000000L;

    private String name;
    private String description;
    private Type type;
    private boolean homeplanetPossible;
    private int population;
    private List<Location> locations;
    @DBRef
    private Sector sector;
    @DBRef
    private Race inhabitants;
    @DBRef
    private Religion religion;
    @DBRef
    private Politics politics;

    public enum Type{
        VOLCANIC, GAS_GIANT, DESERT, ICE_GIANT, OCEAN_PLANET, TERRESTIAL_PLANET;
    }

}
