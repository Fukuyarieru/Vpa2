package fukuya.vpa2.Database;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.CompletableFuture;

public class Database {
    private static final FirebaseDatabase database=FirebaseDatabase.getInstance();

//    public T get<T>() {}

    public<T> CompletableFuture<T> get(DatabaseLink<T> link) {
        CompletableFuture<T> future=new CompletableFuture<>();
        DatabaseReference ref=this.getRef(link);

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try {
                    T value=snapshot.getValue(link.getClazz());
                    future.complete(value);
                } catch (Exception e) {
                    future.completeExceptionally(e);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                future.completeExceptionally(error.toException());
            }
        });
        return future;
    }
    public<T> DatabaseReference getRef(DatabaseLink<T> link) {
        DatabaseReference ref= database.getReference();
        for(String str: link.getPath()) {
            ref=ref.child(str);
        }
        return ref;
    }
}