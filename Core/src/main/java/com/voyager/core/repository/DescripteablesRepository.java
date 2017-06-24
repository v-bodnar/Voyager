package com.voyager.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vova on 6/24/2017.
 */
@Repository
public interface DescripteablesRepository extends MongoRepository<DescripteablesRepository, String> {
}