package com.voyager.core.generator;

import com.voyager.core.repository.PlanetsRepository;
import com.voyager.core.repository.PoliticsRepository;
import com.voyager.core.repository.RacesRepository;
import com.voyager.core.repository.ReligionsRepository;
import com.voyager.core.utils.ActionInSquare;
import com.voyager.core.utils.FileUtils;
import com.voyager.core.utils.XYIterator;
import com.voyager.model.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by volodymyr.bodnar on 6/23/2017.
 */
@Component
public class PlanetsGenerator {
    private ThreadLocalRandom random = ThreadLocalRandom.current();

    private static List<String> planetNames;

    @Autowired
    private PlanetsRepository planetsRepository;

    @Autowired
    private LocationGenerator locationGenerator;

    @Autowired
    private RacesRepository racesRepository;

    @Autowired
    private PoliticsRepository politicsRepository;

    @Autowired
    private ReligionsRepository religionsRepository;

    @Autowired
    private ResourceLoader resourceLoader;

    @PostConstruct
    public void init() {
        planetNames = FileUtils.readLinesFromFile(resourceLoader.getResource("classpath:planet_names.txt"));
    }

    public void generatePlanetsForSector(Sector sector) {

        XYIterator.iterateXY(sector.getStartX(), sector.getStartY(),
                new ActionInSquare() {
                    @Override
                    public void execute(int x, int y) {
                        if (random.nextInt(5) == 0) { //20 percents
                            Planet planet = generatePlanet(x, y);
                            planet.setSector(sector);
                            sector.addPlanet(planet);
                        }
                    }
                });
    }

    public Planet generatePlanet(int x, int y) {
        List<Race> allRaces = racesRepository.findAll();
        List<Politics> allPolitics = politicsRepository.findAll();
        List<Religion> allReligions = religionsRepository.findAll();

        Planet planet = new Planet();
        planet.setX(x);
        planet.setY(y);
        planet.setName(planetNames.get(random.nextInt(planetNames.size())));
        planet.setHomeplanetPossible(random.nextInt(5) == 0); //20%
        planet.setLocations(locationGenerator.generateLocations(planet.getType()));
        planet.setInhabitants(allRaces.get(random.nextInt(allRaces.size())));
        planet.setReligion(allReligions.get(random.nextInt(allReligions.size())));
        planet.setPolitics(allPolitics.get(random.nextInt(allPolitics.size())));
        planet.setPopulation(random.nextInt(Planet.MIN_POPULATION, Planet.MAX_POPULATION));
        planet.setSize(random.nextInt(Planet.MIN_SIZE, Planet.MAX_SIZE));
        planetsRepository.save(planet);
        return planet;
    }


}
