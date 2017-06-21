package com.voyager.model.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by volodymyr.bodnar on 6/19/2017.
 */
public abstract class AbstractEntity implements Identifiable{
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
