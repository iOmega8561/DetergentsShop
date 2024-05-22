package detergents.dao;

import java.util.List;

public interface Interface<T> {
    
    List<T> fetchAll();

    void save(T entity);

    void update(T entity);

    void delete(T entity);
}
