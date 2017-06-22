package com.voyager.model.entity;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Locale;

/**
 * Created by volodymyr.bodnar on 6/21/2017.
 */
public class UserDetails extends AbstractEntity{
    @DBRef(lazy = true)
    private User user;

    private Sex sex;
    private DateTime lastActivityTime;
    private Locale locale;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public DateTime getLastActivityTime() {
        return lastActivityTime;
    }

    public void setLastActivityTime(DateTime lastActivityTime) {
        this.lastActivityTime = lastActivityTime;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public enum Sex{
        MALE, FEMALE, TRANSGENDER;
    }
}
