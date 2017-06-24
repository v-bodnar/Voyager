package com.voyager.core.services;

import com.voyager.core.repository.PoliticsRepository;
import com.voyager.core.repository.RacesRepository;
import com.voyager.core.repository.ReligionsRepository;
import com.voyager.model.entity.Politics;
import com.voyager.model.entity.Race;
import com.voyager.model.entity.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Locale;

/**
 * Created by volodymyr.bodnar on 6/19/2017.
 */
@Service
public class WorldService {
    @Autowired
    private SectorsService sectorsService;

    @Autowired
    private MessageSourceAccessor messageSource;

    @Autowired
    private RacesRepository racesRepository;

    @Autowired
    private PoliticsRepository politicsRepository;

    @Autowired
    private ReligionsRepository religionsRepository;

    private List<Sector> sectors;

    @PostConstruct
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
        initialRaces();
        initialReligions();
        initialPolitics();
        sectors = sectorsService.findAllSectors();
    }

    private void initialRaces(){
        Race insectoids = new Race();
        insectoids.setName(messageSource.getMessage("race.insectoid.name"));
        insectoids.setDescription(messageSource.getMessage("race.insectoid.description"));
        racesRepository.findOneByName(messageSource.getMessage("race.insectoid.name"))
                .orElseGet(() -> racesRepository.save(insectoids));

        Race humanoid = new Race();
        humanoid.setName(messageSource.getMessage("race.humanoid.name"));
        humanoid.setDescription(messageSource.getMessage("race.humanoid.description"));
        racesRepository.findOneByName(messageSource.getMessage("race.humanoid.name"))
                .orElseGet(() -> racesRepository.save(humanoid));

        Race cybernetics = new Race();
        cybernetics.setName(messageSource.getMessage("race.cybernetics.name"));
        cybernetics.setDescription(messageSource.getMessage("race.cybernetics.description"));
        racesRepository.findOneByName(messageSource.getMessage("race.cybernetics.name"))
                .orElseGet(() -> racesRepository.save(cybernetics));

        Race reptilian = new Race();
        reptilian.setName(messageSource.getMessage("race.reptilian.name"));
        reptilian.setDescription(messageSource.getMessage("race.reptilian.description"));
        racesRepository.findOneByName(messageSource.getMessage("race.reptilian.name"))
                .orElseGet(() -> racesRepository.save(reptilian));

    }

    private void initialReligions(){

    }

    private void initialPolitics(){
        Politics democracy = new Politics();
        democracy.setName(messageSource.getMessage("politics.democracy.name"));
        democracy.setDescription(messageSource.getMessage("politics.democracy.description"));
        politicsRepository.findOneByName(messageSource.getMessage("politics.democracy.name"))
                .orElseGet(() -> politicsRepository.save(democracy));

        Politics monarchy = new Politics();
        monarchy.setName(messageSource.getMessage("politics.monarchy.name"));
        monarchy.setDescription(messageSource.getMessage("politics.monarchy.description"));
        politicsRepository.findOneByName(messageSource.getMessage("politics.monarchy.name"))
                .orElseGet(() -> politicsRepository.save(monarchy));

        Politics komunism = new Politics();
        komunism.setName(messageSource.getMessage("politics.komunism.name"));
        komunism.setDescription(messageSource.getMessage("politics.komunism.description"));
        politicsRepository.findOneByName(messageSource.getMessage("politics.komunism.name"))
                .orElseGet(() -> politicsRepository.save(komunism));
    }
}
