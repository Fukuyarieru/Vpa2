package com.vpa2;


import com.google.firebase.database.FirebaseDatabase;
import com.vpa2.datastructures.User;

public abstract class Database {
   static String databaseUrl;
   static FirebaseDatabase database;

   public static<T extends DatabaseDatastructure> T get(String header, String key) {
      database.getReference(header).child(key);
   }
}
