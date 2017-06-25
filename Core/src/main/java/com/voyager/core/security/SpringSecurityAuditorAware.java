package com.voyager.core.security;

import com.voyager.core.repository.UsersRepository;
import com.voyager.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by volodymyr.bodnar on 6/23/2017.
 */
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Autowired
    private UsersRepository usersRepository;

    public String getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        User user = usersRepository.findOneByEmail(((org.springframework.security.core.userdetails.User)authentication.getPrincipal()).getUsername()).orElse(null);
        if(user == null){
            return null;
        }else {
            return user.getEmail();
        }

    }
}
