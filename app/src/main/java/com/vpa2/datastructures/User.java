package com.vpa2.datastructures;

import com.vpa2.DatabaseDatastructure;

public class User implements DatabaseDatastructure {

   String name;
   String password;

   @Override
   public String header() {
      return "Users";
   }

   @Override
   public String key() {
      return name;
   }
}
