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

public abstract class Database {
   static String databaseUrl;
   static FirebaseDatabase database;

   public static<T extends DatabaseDatastructure> T get(String key, Class<T> Class, final DatabaseCallback<T> callback) {
      T temp;
       try {
           temp= Class.getConstructor().newInstance();
       } catch (Exception e) {
           callback.onFailure(DatabaseError.fromException(e));
           throw new RuntimeException(e);
       }
       DatabaseReference dbRef=database.getReference(temp.header()).child(key);

       dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               T value=snapshot.getValue(Class);
               callback.onSuccess(Optional.of(value));
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {
               callback.onSuccess(Optional.empty());
           }
       });

       return null; // someday in a sunny day
   }
   public static void set(DatabaseDatastructure dataStructure) {
      database.getReference(dataStructure.header()).child(dataStructure.key()).setValue(dataStructure);
   }

   public interface DatabaseCallback<T> {
       void onSuccess(Optional<T> result);
       void onFailure(DatabaseError error);
   }
}
