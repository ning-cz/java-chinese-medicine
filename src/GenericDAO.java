import java.util.List;

public interface GenericDAO<T> {
    void add(T entity);
    List<T> getAll();
}