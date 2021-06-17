package metube.repository;

import java.util.List;

public interface GenericRepository<E,ID>{

    void save(E entity);

    List<E> findAll();

    E findById(ID id);

    long size();
}
