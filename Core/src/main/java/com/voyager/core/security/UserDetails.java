package com.voyager.core.security;

import com.voyager.model.entity.Role;
import com.voyager.model.entity.User;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by Vova on 6/20/2017.
 */
public class UserDetails extends org.springframework.security.core.userdetails.User {
    private User user;

    public UserDetails(User user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().name()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }
}
