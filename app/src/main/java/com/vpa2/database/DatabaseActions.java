package com.vpa2.database;

import com.vpa2.datastructures.User;

public class DatabaseActions {
    public void newUser(String username,String password) {
        if(Database.get(username, User.class).isEmpty()) {
            User newUser=new User(username,password);
            Database.set(newUser);
        } else {
            // TODO some error implementation
        }
    }
}
