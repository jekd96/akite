package org.clicker.service;

import org.clicker.domain.Employee;
import org.clicker.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Admin on 18.03.2016.
 */
@Service
public class EmployeeService extends CommonService<EmployeeRepository, Employee> {
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        setRepository(employeeRepository);
    }
}
