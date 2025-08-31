package fukuya.vpa2.Database;

import java.util.Collection;

public class DatabaseLink<T> {
    Collection<String> path;

    public DatabaseLink(Collection<String> path) {
        this.path=path;
    }
}
