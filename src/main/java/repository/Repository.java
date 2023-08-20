package repository;

public interface Repository<T, ID> {
    T findById(ID id);
}
