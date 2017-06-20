package com.voyager;

import com.voyager.core.Application;
import com.voyager.core.repository.PlayerRepository;
import com.voyager.core.repository.UserRepository;
import com.voyager.model.entity.Player;
import com.voyager.model.entity.Role;
import com.voyager.model.entity.User;
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
    private PlayerRepository playerRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Ignore
    public void persistPlayer() {
        Player player = new Player();
        player = playerRepository.save(player);
        Player foundPlayer = playerRepository.findAll().stream().findFirst().orElse(null);
        assertTrue(foundPlayer.equals(player));
    }

    @Test

    public void persistUser(){
        User user = new User();
        user.setRole(Role.USER);
        user.setEmail("bodik@list.ru");
        user.setPassword(new BCryptPasswordEncoder().encode("nenimdada"));
        user = userRepository.save(user);
        assertNotNull(user);
    }
}
