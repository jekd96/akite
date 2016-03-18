package org.clicker.repository;

import org.clicker.domain.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 07.10.2015.
 */
@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {
}
