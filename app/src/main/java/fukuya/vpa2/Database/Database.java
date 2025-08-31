package fukuya.vpa2.Database;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Database {
    private static FirebaseDatabase database=FirebaseDatabase.getInstance();

//    public T get<T>() {}

    public<T> T get(DatabaseLink<T> link) {
        DatabaseReference ref=this.getRef(link);
        T var=null;
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                var=snapshot.getValue()
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public<T> DatabaseReference getRef(DatabaseLink<T> link) {
        DatabaseReference ref= database.getReference();
        for(String str: link.path) {
            ref=ref.child(str);
        }
        return ref;
    }
}