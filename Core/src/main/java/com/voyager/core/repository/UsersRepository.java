package com.voyager.core.repository;

import com.voyager.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Vova on 6/20/2017.
 */
@Repository
public interface UsersRepository extends MongoRepository<User, String> {
    Optional<User> findOneByEmail(String email);
}
