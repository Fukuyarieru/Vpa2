package fukuya.vpa2.Database;

import java.util.ArrayList;
import java.util.Collection;

public abstract class DatabaseObject {
    private DatabaseLink<Class<DatabaseObject>> link;

    public DatabaseLink<Class<DatabaseObject>> link() {
        return this.link;
    }

    ///
    ///  DatabaseObjectDirectory/...
    ///
    public Collection<String> getPath() {
        ArrayList<String> arr=new ArrayList<>();
        arr.add(this.getClass().getSimpleName()+"Directory");
        return arr;
    }
}

