package com.voyager.core.repository;

import com.voyager.model.entity.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vova on 6/22/2017.
 */
@Repository
public interface UserDetailsRepository extends MongoRepository<UserDetails, String> {
}