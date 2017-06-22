package com.voyager.model.entity;

import java.io.Serializable;

/**
 * Created by volodymyr.bodnar on 6/21/2017.
 */
public interface Identifiable extends Serializable{
    String getId();
    void setId(String id);
}
