package com.global.hr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.entity.Employee;
import com.global.hr.repository.EmployeeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("count")
    public Long contEmployeesNum() {
        return employeeRepository.count();
    }

    @PostMapping("/insert")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(new Employee(null,employee.getName(),employee.getSalary()));
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/findall")
    public Iterable<Employee> findAllEmployee() {
        return  employeeRepository.findAll();
    }
    @DeleteMapping("/delete")
    public boolean deleteEmployee(@RequestBody Employee employee) {
        employeeRepository.delete(employee);
        return true;
    }
    @GetMapping("/findbynameandsalary/{name}/{salary}")
    public List <Employee> findByNameAndSalary(@PathVariable String name,@PathVariable double salary) {
        return employeeRepository.findByNameAndSalary(name, salary);
    }
    @GetMapping("/findbyname/{name}")
    public List <Employee> findByName(@PathVariable String name) {
        return employeeRepository.findByName(name);
    }

}
