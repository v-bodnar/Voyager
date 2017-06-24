package com.voyager.model.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;
import repository.annotations.CascadeSave;

import java.util.List;

/**
 * Created by volodymyr.bodnar on 6/18/2017.
 */
public class Location extends AbstractDescribtable{
    @DBRef
    @CascadeSave
    private Resource resource;

    private List<Planet.Type> planetType;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public List<Planet.Type> getPlanetType() {
        return planetType;
    }

    public void setPlanetType(List<Planet.Type> planetType) {
        this.planetType = planetType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Location location = (Location) o;

        if (resource != null ? !resource.equals(location.resource) : location.resource != null) return false;
        return planetType != null ? planetType.equals(location.planetType) : location.planetType == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (resource != null ? resource.hashCode() : 0);
        result = 31 * result + (planetType != null ? planetType.hashCode() : 0);
        return result;
    }
}
