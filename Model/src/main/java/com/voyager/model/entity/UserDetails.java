package com.voyager.model.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Created by volodymyr.bodnar on 6/21/2017.
 */
public class UserDetails extends AbstractEntity{
    private Sex sex;
    @DBRef
    private Character character;

    enum Sex{
        MALE, FEMALE;
    }
}
