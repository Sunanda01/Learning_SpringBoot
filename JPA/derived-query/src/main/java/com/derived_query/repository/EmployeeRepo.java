package com.derived_query.repository;

import com.derived_query.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    List<Employee> findByName(String name);
    List<Employee> findByEmail(String email);
    Boolean existsEmployeeByName(String name);
    List<Employee> findByNameContaining(String keyword);
    List<Employee> findBySalaryBetween(Double min,Double max);
    List<Employee> findBySalaryGreaterThan(Double sal);
    List<Employee> findBySalaryLessThanEqual(Double sal);
}
