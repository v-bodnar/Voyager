package com.voyager.core.repository;

import com.voyager.model.entity.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by volodymyr.bodnar on 6/19/2017.
 */
@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
}
