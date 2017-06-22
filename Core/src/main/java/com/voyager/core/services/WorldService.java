package com.voyager.core.services;

import com.voyager.model.entity.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by volodymyr.bodnar on 6/19/2017.
 */
@Service
public class WorldService {
    @Autowired
    private SectorService sectorService;

    private List<Sector> sectors;

    @PostConstruct
    public void init() {
        sectors = sectorService.findAllSectors();
    }
}
