package com.sinishaw.mvcthymeleafmysql.model;

public class UserRequest {

    private User user;
    private String abebe;

    public UserRequest(User user, String abebe) {
        this.user = user;
        this.abebe = abebe;
    }

    public UserRequest() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAbebe() {
        return abebe;
    }

    public void setAbebe(String abebe) {
        this.abebe = abebe;
    }
}
