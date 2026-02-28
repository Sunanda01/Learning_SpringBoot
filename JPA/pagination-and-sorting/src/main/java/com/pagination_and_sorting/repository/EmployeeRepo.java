package com.pagination_and_sorting.repository;

import com.pagination_and_sorting.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    Page<Employee> findAll(Pageable pageable);
    List<Employee> findEmployeeByNameStartingWith(String name, Sort sort);
}
