package com.voyager.core.repository;

import com.voyager.model.entity.Politics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Vova on 6/24/2017.
 */
@Repository
public interface PoliticsRepository extends MongoRepository<Politics, String> {
    Optional<Politics> findOneByName(String name);
}