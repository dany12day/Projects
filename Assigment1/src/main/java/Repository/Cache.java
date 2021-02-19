package Repository;

import java.util.List;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class Cache<T> {
    private List<T> storage;
    public void save(List<T> entities) {
        this.storage = entities;
    }
    public void add(T entities) {
        this.storage.add(entities);
    }
    public boolean hasResult() {
        return storage != null;
    }
    public List<T> load() {
        System.out.println("Loaded from cache");
        return storage;
    }
    public void invalidateCache() {
        storage = null;
    }

}
