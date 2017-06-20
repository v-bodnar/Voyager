package com.voyager;

import com.voyager.core.Application;
import com.voyager.core.repository.PlayerRepository;
import com.voyager.model.entity.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by volodymyr.bodnar on 6/20/2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class MongoDBTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void persistPlayer() {
        Player player = new Player();
        player = playerRepository.save(player);
        Player foundPlayer = playerRepository.findAll().stream().findFirst().orElse(null);
        assertTrue(foundPlayer.equals(player));
    }
}
