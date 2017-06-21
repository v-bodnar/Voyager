package com.voyager.model.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

/**
 * Created by volodymyr.bodnar on 6/18/2017.
 */
public class Planet extends SpaceBody{
    private String name;
    private Type type;
    private boolean homeplanetPossible;
    private Race inhabitants;
    private int population;
    private List<Location> locations;
    @DBRef
    private Sector sector;

    public enum Type{
        VOLCANIC, GAS_GIANT, DESERT, ICE_GIANT, OCEAN_PLANET, TERRESTIAL_PLANET;
    }

}
