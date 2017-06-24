package com.voyager.core.services;

import com.voyager.core.repository.UsersRepository;
import com.voyager.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by Vova on 6/20/2017.
 */
@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public User registerNewUser(User user){
        return usersRepository.save(user);
    }
}
