package org.clicker.repository;

import org.clicker.domain.Speciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 18.03.2016.
 */
@Repository
public interface SpecialityRepository  extends CrudRepository<Speciality, Long> {
}
