package org.clicker.service;

import org.clicker.domain.Group;
import org.clicker.domain.Student;
import org.clicker.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 29.01.2016.
 */
@Service
public class StudentService extends CommonService<StudentRepository, Student> {
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        setRepository(studentRepository);
    }

}
