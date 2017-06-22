package com.voyager.core.services;

import com.voyager.core.repository.SectorRepository;
import com.voyager.model.entity.Sector;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by volodymyr.bodnar on 6/19/2017.
 */
@Service
public class SectorService {
    private static final Logger log = LogManager.getLogger(SectorService.class);
    private static final int SECTOR_SIDE_SIZE = 30;
    private static final Random seed = new Random();

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private MessageSourceAccessor messageSource;

    public Sector generateSector(List<Sector> existingSectors) {
        List<String> sectorNames = new LinkedList<>(Arrays.asList(messageSource.getMessage("sector.names").split(",")));

        if(existingSectors.size() >= sectorNames.size()) throw new RuntimeException("Provide some new names for your sectors"); //todo

        int x = 1, y = 1;//initial coordinates

        if (existingSectors.isEmpty()) {
            Sector sector = new Sector();
            sector.setStartX(x);
            sector.setStartY(y);
            sector.setName("Alpha");
        }

        int maxX = 1;
        int maxY = 1;

        HashMap<String, Sector> sectors = new HashMap<>();
        for (Sector sector : existingSectors) {
            if (maxX < sector.getStartX()) maxX = sector.getStartX();
            if (maxY < sector.getStartY()) maxY = sector.getStartY();
            sectors.put(sector.getStartX() + "," + sector.getStartY(), sector);
            sectorNames.remove(sector.getName());
        }

        boolean exists = true;
        while (y < maxY){
            y = y + SECTOR_SIDE_SIZE;
            int localX = nextX(sectors, maxX, y);
            if(localX != -1){
                x = localX;
                exists = false;
            }
        }

        if(exists){
            if(seed.nextInt(2) == 0){
                x = maxX + SECTOR_SIDE_SIZE;
            }else {
                y = maxY + SECTOR_SIDE_SIZE;
            }
        }

        Sector sector = new Sector();
        sector.setStartX(x);
        sector.setStartY(y);
        sector.setName(sectorNames.get(0));

        sectorRepository.save(sector);

        log.info("New sector has been created - " + sector);
        return sector;
    }

    private int nextX(HashMap<String, Sector> existingSectors, int maxX, int y) {
        int x = 1;
        while(x < maxX){
            x = x + SECTOR_SIDE_SIZE;
            if(!existingSectors.containsKey(x + "," + y)){
                return x;
            }
        }
        return -1;
    }


    public List<Sector> findAllSectors() {
        List<Sector> sectors = sectorRepository.findAll();
        if (sectors == null || sectors.isEmpty()) {
            sectors = new LinkedList<>();
            sectors.add(generateSector(sectors));
        }

        return sectors;
    }
}
