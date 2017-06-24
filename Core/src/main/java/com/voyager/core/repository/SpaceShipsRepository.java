package com.voyager.core.repository;

/**
 * Created by volodymyr.bodnar on 6/21/2017.
 */

import com.voyager.model.entity.SpaceShip;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SpaceShipsRepository extends MongoRepository<SpaceShip, String> {
}