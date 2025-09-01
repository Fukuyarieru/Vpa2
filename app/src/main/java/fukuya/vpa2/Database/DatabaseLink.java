package fukuya.vpa2.Database;

import java.util.Collection;

public class DatabaseLink<T> {
    private final Collection<String> path;
    private final Class<T> clazz;

    public DatabaseLink(Collection<String> path, Class<T> clazz) {
        this.path=path;
        this.clazz=clazz;
    }

    public Collection<String> getPath() {
        return this.path;
    }
    public Class<T> getClazz() {
        return clazz;
    }
}
