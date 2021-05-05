package com.example.demo.controller;

import com.example.demo.modal.Student;
import com.example.demo.modal.StudentPage;
import com.example.demo.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/get")
    public ResponseEntity<Page<Student>> get(StudentPage studentPage){
        return new ResponseEntity<>(studentService.getStudents(studentPage), HttpStatus.OK);
    }
    @PostMapping(value = "/add")
    public ResponseEntity<Student> add(@RequestBody Student student){
        return new ResponseEntity<>(studentService.addStudent(student),HttpStatus.OK);
    }
}
