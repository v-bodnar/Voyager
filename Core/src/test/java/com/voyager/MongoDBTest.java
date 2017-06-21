package com.voyager;

import com.voyager.core.Application;
import com.voyager.core.repository.CharacterRepository;
import com.voyager.core.repository.SectorRepository;
import com.voyager.core.repository.SpaceShipRepository;
import com.voyager.core.repository.UserRepository;
import com.voyager.model.entity.*;
import com.voyager.model.entity.Character;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by volodymyr.bodnar on 6/20/2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class MongoDBTest {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private SpaceShipRepository spaceShipRepository;

    @Test

    public void persistPlayer() {
//        User user = userRepository.findOneByEmail("bodik@list.ru").orElseThrow(() -> new RuntimeException());
//        Sector sector = new Sector();
//        sector.setStartX(1);
//        sector.setStartY(1);
//        sector.setName("Alpha");
//        sectorRepository.save(sector);
//
//        SpaceShip spaceShip = new SpaceShip();
//        spaceShip.setName("Voyager");
//        spaceShipRepository.save(spaceShip);
//        User user = userRepository.findOneByEmail("bodik@list.ru").orElseThrow(() -> new RuntimeException());
//        Sector sector = sectorRepository.findAll().stream().findFirst().orElseThrow(() -> new RuntimeException());
//        SpaceShip spaceShip = spaceShipRepository.findAll().stream().findFirst().orElseThrow(() -> new RuntimeException());
//        MainCharacter character = new MainCharacter();
//        character.setNickName("test");
//        character.setSex(UserDetails.Sex.MALE);
//        character.setOwner(user);
//        character.setSector(sector);
//        character.setSpaceShip(spaceShip);
//        character = characterRepository.save(character);
        Character foundCharacter = characterRepository.findAll().stream().findFirst().orElse(null);

        Sector foundSector = sectorRepository.findAll().stream().findFirst().orElse(null);
        assertTrue(foundSector != null);
    }

    @Test
    @Ignore
    public void persistUser(){

        User user = new User("bodik@list.ru",
                new BCryptPasswordEncoder().encode("nenimdada"),
                Role.USER, true);
        user = userRepository.save(user);
        assertNotNull(user);
    }
}
