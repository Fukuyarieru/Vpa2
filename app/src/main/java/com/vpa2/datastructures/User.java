package com.vpa2.datastructures;

import com.vpa2.DatabaseDatastructure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements DatabaseDatastructure {

   private String name;
   private String password;
   private String description;
   private byte[] picture;

   public static final String defaultUserName="User";
   public static final String defaultUserPassword="123";
   public static final String defaultUserDescription="";

   public User() {
      this(defaultUserName,defaultUserPassword);
   }

   public User(String name, String password) {
      this.name = name;
      this.password = password;
      this.description=defaultUserDescription;
      this.picture=new byte[]{0};
   }

   @Override
   public String header() {
      return "users";
   }

   @Override
   public String key() {
      return name;
   }
}
