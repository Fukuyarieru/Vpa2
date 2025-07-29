package com.vpa2.database;


import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public abstract class Database {
   static String databaseUrl;
   static FirebaseDatabase database;

   public static<T extends DatabaseAccess> Optional<T> get(String key, Class<T> typeClass)  {
       T temp;
       try {
           temp= typeClass.getConstructor().newInstance();
       } catch (Exception e) {
           return Optional.empty();
       }

       final CompletableFuture<Optional<T>> future = new CompletableFuture<>();

       DatabaseReference dbRef=database.getReference(temp.header()).child(key);

       dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
           // ADD FUTURE HERE OR SOMETHING
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               T value=snapshot.getValue(typeClass);
               if(value!=null)
                   future.complete(Optional.of(value));
               else
                   future.complete(Optional.empty());
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {
               future.complete(Optional.empty());
           }
       });

       try {
           return future.get();
       } catch (Exception ignored) {
           return Optional.empty();
       }
   }

   public static void set(DatabaseAccess dataStructure) {
      database.getReference(dataStructure.header()).child(dataStructure.key()).setValue(dataStructure);
   }
}
