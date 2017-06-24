package com.voyager.core.repository;

import com.voyager.model.entity.Resource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vova on 6/24/2017.
 */
@Repository
public interface ResourcesRepository extends MongoRepository<Resource, String> {
}
