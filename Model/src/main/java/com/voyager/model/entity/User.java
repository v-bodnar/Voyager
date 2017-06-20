package com.voyager.model.entity;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotNull;
/**
 * Created by volodymyr.bodnar on 6/19/2017.
 */
public class User extends AbstractEntity{
    @NotNull
    @Indexed(unique = true)
    private String email;
    @NotNull
    private String password;
    @NotNull
    @DBRef
    private Role role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
