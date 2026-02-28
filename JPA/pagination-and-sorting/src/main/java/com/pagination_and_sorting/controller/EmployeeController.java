package com.pagination_and_sorting.controller;

import com.pagination_and_sorting.entity.Employee;
import com.pagination_and_sorting.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Page<Employee> getAllEmployee(){
        Pageable pageable= PageRequest.of(0,3, Sort.by("name").descending());
        Page<Employee> employee=repo.findAll(pageable);
        List<Employee> employeeList=employee
                .getContent();
        System.out.println("Total Pages => "+employee.getTotalPages());
        System.out.println("Is First Page => "+employee.isFirst());
        System.out.println("Is Last Page => "+employee.isLast());
        return repo.findAll(pageable);
    }

    @GetMapping("/sort/{name}")
    public List<Employee> employeeList(@PathVariable("name") String name){
        return repo.findEmployeeByNameStartingWith(name,Sort.by("salary").descending());
    }
}
