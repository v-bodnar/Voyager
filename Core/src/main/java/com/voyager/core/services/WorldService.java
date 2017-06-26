package com.voyager.core.services;

import com.voyager.core.repository.PoliticsRepository;
import com.voyager.core.repository.RacesRepository;
import com.voyager.core.repository.ReligionsRepository;
import com.voyager.core.repository.UsersRepository;
import com.voyager.core.security.SecurityUserService;
import com.voyager.model.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    private UsersRepository usersRepository;

    private List<Sector> sectors;

    @PostConstruct
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
        initialLocations();
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
        Religion scientology = new Religion();
        scientology.setName(messageSource.getMessage("religion.scientology.name"));
        scientology.setDescription(messageSource.getMessage("religion.scientology.description"));
        religionsRepository.findOneByName(messageSource.getMessage("religion.scientology.name"))
                .orElseGet(() -> religionsRepository.save(scientology));

        Religion harmonism = new Religion();
        harmonism.setName(messageSource.getMessage("religion.harmonism.name"));
        harmonism.setDescription(messageSource.getMessage("religion.harmonism.description"));
        religionsRepository.findOneByName(messageSource.getMessage("religion.harmonism.name"))
                .orElseGet(() -> religionsRepository.save(harmonism));

        Religion necrocism = new Religion();
        necrocism.setName(messageSource.getMessage("religion.necrocism.name"));
        necrocism.setDescription(messageSource.getMessage("religion.necrocism.description"));
        religionsRepository.findOneByName(messageSource.getMessage("religion.necrocism.name"))
                .orElseGet(() -> religionsRepository.save(necrocism));
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

    private void initialLocations(){
        Location location = new Location();
        location.setName();
        location.setDescription();
        location.setPlanetType();
        location.setResource();
    }

    private void initialResources(){
        Resource resource = new Resource();
        resource.setName();
        resource.setDescription();
        resource.setAmmount();
        resource.setSpreading();
        resource.setType(Resource.Type.LIQUID);
    }
}
