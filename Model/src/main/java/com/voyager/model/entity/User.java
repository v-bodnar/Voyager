package com.voyager.model.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by volodymyr.bodnar on 6/19/2017.
 */
public class User implements org.springframework.security.core.userdetails.UserDetails, CredentialsContainer, Identifiable {
    @Id
    private String id;
    @NotNull
    @Indexed(unique = true)
    private String email;
    @NotNull
    private String password;
    @NotNull
    private Role role;
    @Transient
    @JsonIgnore
    private Set<GrantedAuthority> authorities;
    @DBRef
    @repository.annotations.CascadeSave
    private UserDetails userDetails;
    private boolean enabled;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    @PersistenceConstructor
    public User(@JsonProperty("email") String email, @JsonProperty("password") String password, @JsonProperty("role") Role role, @JsonProperty("enabled") boolean enabled) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
        this.authorities = Collections.unmodifiableSet(new HashSet<>(AuthorityUtils.createAuthorityList(role.name())));
    }

    /**
     * Returns {@code true} if the supplied object is a {@code User} instance with the
     * same {@code username} value.
     * <p>
     * In other words, the objects are equal if they have the same username, representing
     * the same principal.
     */
    @Override
    public boolean equals(Object rhs) {
        if (rhs instanceof User) {
            return email.equals(((User) rhs).getEmail());
        }
        return false;
    }

    /**
     * Returns the hashcode of the {@code username}.
     */
    @Override
    public int hashCode() {
        return email.hashCode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void eraseCredentials() {
        password = null;
    }
}
