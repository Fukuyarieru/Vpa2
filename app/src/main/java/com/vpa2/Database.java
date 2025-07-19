package com.vpa2;


import androidx.annotation.NonNull;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vpa2.datastructures.User;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

import javax.security.auth.callback.Callback;

public abstract class Database {
   static String databaseUrl;
   static FirebaseDatabase database;

   public static<T extends DatabaseDatastructure> T get(String key, Class<T> Class, final Consumer<Optional<T>> callback) throws RuntimeException {
      T temp;
       try {
           temp= Class.getConstructor().newInstance();
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
       DatabaseReference dbRef=database.getReference(temp.header()).child(key);

       dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
           // ADD FUTURE HERE OR SOMETHING
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               T value=snapshot.getValue(Class);
               if(value!=null)
                   callback.accept(Optional.of(value));
               else
                   callback.accept(Optional.empty());
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {
               callback.accept(Optional.empty());
           }
       });

       return null; // someday in a sunny day
   }
   public static void set(DatabaseDatastructure dataStructure) {
      database.getReference(dataStructure.header()).child(dataStructure.key()).setValue(dataStructure);
   }
}
