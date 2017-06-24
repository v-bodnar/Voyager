package com.voyager.core.repository;

import com.voyager.model.entity.Planet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vova on 6/24/2017.
 */
@Repository
public interface PlanetsRepository extends MongoRepository<Planet, String> {
}