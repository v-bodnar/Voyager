package com.voyager.core.services;

import com.voyager.core.repository.UserRepository;
import com.voyager.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by Vova on 6/20/2017.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerNewUser(User user){
        return userRepository.save(user);
    }
}
