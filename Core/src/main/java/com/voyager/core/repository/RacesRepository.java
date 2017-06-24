package com.voyager.core.repository;

import com.voyager.model.entity.Race;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Vova on 6/24/2017.
 */
@Repository
public interface RacesRepository extends MongoRepository<Race, String> {
    public Optional<Race> findOneByName(String name);
}