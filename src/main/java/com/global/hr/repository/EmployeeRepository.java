package com.global.hr.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.hr.entity.Employee;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    public List<Employee> findByName(String name);

    public List<Employee> findByNameStartingWithAndSalary(String name, double salary);

    @Query(value = "SELECT id,name,salary from employee where name like :empName AND salary=:salary")
    public List<Employee> findByNameContainingAndSalary(@Param("empName") String name, @Param("salary") double salary);
   
    @Modifying
    @Query(value="update employee set salary=:salary where id =:id")
    public int updateSalary(Double salary,Long id);
}
