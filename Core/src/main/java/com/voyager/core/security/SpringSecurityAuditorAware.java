package com.voyager.core.security;

import com.voyager.core.repository.UserRepository;
import com.voyager.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by volodymyr.bodnar on 6/23/2017.
 */
public class SpringSecurityAuditorAware implements AuditorAware<User> {

    @Autowired
    private UserRepository userRepository;

    public User getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        return userRepository.findOneByEmail(((org.springframework.security.core.userdetails.User)authentication.getPrincipal()).getUsername()).orElse(null);
    }
}
