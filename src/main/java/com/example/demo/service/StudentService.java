package com.example.demo.service;

import com.example.demo.modal.Student;
import com.example.demo.modal.StudentPage;
import com.example.demo.repository.StudentRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Page<Student> getStudents(StudentPage studentPage){
        Sort sort=Sort.by(studentPage.getSortDirection(),studentPage.getSortBy());
        Pageable pageable= PageRequest.of(studentPage.getPageNumber(),studentPage.getPageSize(),sort);
        return studentRepo.findAll(pageable);
    }

    public Student addStudent(Student student){
        return studentRepo.save(student);
    }
}
