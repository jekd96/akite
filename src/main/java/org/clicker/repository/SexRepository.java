package org.clicker.repository;

import org.clicker.domain.Sex;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 18.03.2016.
 */
@Repository
public interface SexRepository  extends CrudRepository<Sex, Long> {
}
