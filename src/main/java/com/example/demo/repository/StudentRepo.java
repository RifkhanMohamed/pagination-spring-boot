package com.example.demo.repository;

import com.example.demo.modal.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends PagingAndSortingRepository<Student,Long> {
}
