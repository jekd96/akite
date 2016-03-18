package org.clicker.repository;

import org.clicker.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 29.01.2016.
ц */
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
