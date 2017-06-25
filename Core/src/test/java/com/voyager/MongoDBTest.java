package com.voyager;

import com.voyager.core.Application;
import com.voyager.core.repository.SectorsRepository;
import com.voyager.core.repository.SpaceShipsRepository;
import com.voyager.core.repository.UsersRepository;
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
    private UsersRepository usersRepository;

    @Autowired
    private SectorsRepository sectorsRepository;

    @Autowired
    private SpaceShipsRepository spaceShipsRepository;

    @Test
    @Ignore
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
//        Character foundCharacter = charactersRepository.findAll().stream().findFirst().orElse(null);
//
//        Sector foundSector = sectorsRepository.findAll().stream().findFirst().orElse(null);
//        assertTrue(foundSector != null);
    }

    @Test
    @Ignore
    public void persistUser(){

        User user = new User("bodik@list.ru",
                new BCryptPasswordEncoder().encode("nenimdada"),
                Role.USER, true);
        user = usersRepository.save(user);
        assertNotNull(user);
    }
}
