package com.voyager.core.repository;

import com.voyager.model.entity.Religion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Vova on 6/24/2017.
 */
@Repository
public interface ReligionsRepository extends MongoRepository<Religion, String> {
    Optional<Religion> findOneByName(String name);
}