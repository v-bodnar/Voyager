package com.voyager.model.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

/**
 * Created by volodymyr.bodnar on 6/19/2017.
 */
public class Sector extends AbstractEntity {
    @DBRef
    List<Player> players;
}
