package com.voyager.core.generator;

import com.voyager.model.entity.Location;
import com.voyager.model.entity.Planet;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vova on 6/24/2017.
 */
@Service
public class LocationGenerator {
    public List<Location> generateLocations(Planet.Type planetType){
        List<Location> locations = new LinkedList<>();
        return locations;
    }
}
