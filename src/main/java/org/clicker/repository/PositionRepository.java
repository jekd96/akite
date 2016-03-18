package org.clicker.repository;

import org.clicker.domain.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 18.03.2016.
 */
@Repository
public interface PositionRepository extends CrudRepository<Position, Long> {
}
