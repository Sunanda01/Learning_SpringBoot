package com.lazy_demo.controller;

import com.lazy_demo.entity.Books;
import com.lazy_demo.entity.Student;
import com.lazy_demo.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepo repo;
    @PostMapping
    public String saveStudent(){
        Student student=new Student();
        student.setName("Rekha Singh");
        Books b1=new Books();
        b1.setBname("Data Structure Using C");
        b1.setStudent(student);
        Books b2=new Books();
        b2.setBname("Data Structure Using C++");
        b2.setStudent(student);
        student.setBooks(Arrays.asList(b1,b2));
        repo.save(student);
        return "Student Saved";
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") Long id){
        Student student= repo.findById(id).orElseThrow(()->new RuntimeException("Student with ID => "+id+" Not Found"));
        System.out.println("Calling student.getBooks()\nBooks will be loaded only when called");
        System.out.println(student.getBooks());
        return student;
    }
}

//  Step 1 : Hibernate fetches student only
//  Step 2 : Jackson tries to serialize books → calls getBooks()
//  Step 3 : Hibernate runs books query