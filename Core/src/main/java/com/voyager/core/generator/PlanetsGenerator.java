package com.voyager.core.generator;

import com.voyager.core.utils.ActionInSquare;
import com.voyager.core.utils.XYIterator;
import com.voyager.model.entity.Planet;
import com.voyager.model.entity.Sector;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by volodymyr.bodnar on 6/23/2017.
 */
@Component
public class PlanetsGenerator {
    private Random random = new Random();

    public void generatePlanetsForSector(Sector sector){

        XYIterator.iterateXY(sector.getStartX(), sector.getStartY(),
                new ActionInSquare() {
                    @Override
                    public void execute(int x, int y) {
                        if(random.nextInt(3) == 0){
                            generatePlanet(x,y);
                        }
                    }
                });
    }

    public Planet generatePlanet(int x, int y){
        return null;
    }


}
