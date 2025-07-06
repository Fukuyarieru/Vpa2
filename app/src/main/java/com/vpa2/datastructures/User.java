package com.vpa2.datastructures;

import com.vpa2.DatabaseDatastructure;

public class User implements DatabaseDatastructure {

   String name;
   String password;

   public User(String name, String password) {
      this.name = name;
      this.password = password;
   }

   @Override
   public String header() {
      return "Users";
   }

   @Override
   public String key() {
      return name;
   }
}
