package com.derived_query.controller;

import com.derived_query.entity.Employee;
import com.derived_query.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeRepo repo;
    @PostMapping("/")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee saved=repo.save(employee);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/")
    public List<Employee> getAllEmployee(){
        return repo.findAll();
    }

    @GetMapping("/name")
    public List<Employee> getEmployeeByName(@RequestParam String name){
        return repo.findByName(name);
    }
    // http://localhost:8080/name?name=Rakesh Sharma

    @GetMapping("/email")
    public List<Employee> getEmployeeByEmail(@RequestParam String email){
        return repo.findByEmail(email);
    }
    // http://localhost:8080/email?email=rakesh@gmail.com

    @GetMapping("/name-exists")
    public Boolean existsEmployeeByName(String name){
        return repo.existsEmployeeByName(name);
    }
    // http://localhost:8080/name-exists?name=Rakesh Sharma

    @GetMapping("/search-name")
    public List<Employee> findByNameContaining(@RequestParam String q){
        return repo.findByNameContaining(q);
    }
    // http://localhost:8080/search-name?q=han

    @GetMapping("/salary")
    public List<Employee> findBySalaryBetween(@RequestParam Double max,@RequestParam Double min){
        return repo.findBySalaryBetween(min,max);
    }
    // http://localhost:8080/salary?min=20000&max=30000

    @GetMapping("/max-sal")
    public List<Employee> findBySalaryGreaterThan(@RequestParam Double sal){
        return repo.findBySalaryGreaterThan(sal);
    }
    // http://localhost:8080/max-sal?sal=40000

    @GetMapping("/less-sal")
    public List<Employee> findBySalaryLessThanEqual(@RequestParam Double sal){
        return repo.findBySalaryLessThanEqual(sal);
    }
    // http://localhost:8080/less-sal?sal=22000
}
