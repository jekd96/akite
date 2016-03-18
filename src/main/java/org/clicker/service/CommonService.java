package org.clicker.service;

import org.clicker.domain.GenericEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 18.03.2016.
 */
@Service
public class CommonService<R extends CrudRepository<E, Long>, E extends GenericEntity> {

    private R repository;

    public void add(E entity) {
        repository.save(entity);
    }

    public List<E> getAll() {
        List<E> entityList = new ArrayList<>();
        Iterable<E> iterable = repository.findAll();
        for(E item : iterable)
            entityList.add(item);
        return entityList;
    }

    public void delete(E entity) {
        repository.delete(entity);
    }

    public void update(E entity) {
        repository.save(entity);
    }

    public void setRepository(R repository) {
        this.repository = repository;
    }

}
