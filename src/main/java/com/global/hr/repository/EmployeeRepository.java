package com.global.hr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.global.hr.entity.Employee;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    public List<Employee> findByName(String name);
    public List <Employee>findByNameAndSalary(String name,double salary);
    
}
