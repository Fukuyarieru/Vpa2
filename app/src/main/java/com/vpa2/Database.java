package com.vpa2;


import androidx.annotation.NonNull;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vpa2.datastructures.User;

public abstract class Database {
   static String databaseUrl;
   static FirebaseDatabase database;

   public static<T extends DatabaseDatastructure> T get(String header, String key) {
      database.getReference(header).child(key);
      return null; // someday on a sunny day
   }
   public static<T extends Class> T getObjectFromRefrence(DatabaseReference dbRef) {
      dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
         @Override
         public void onDataChange(@NonNull DataSnapshot snapshot) {
            snapshot.getValue(T.class);
         }

         @Override
         public void onCancelled(@NonNull DatabaseError error) {

         }
      });
   }
}
