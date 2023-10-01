package com.example.cnpm.repository;

import com.example.cnpm.dto.StudentDTO;
import com.example.cnpm.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Page<Student> findByTen(String name,Pageable pageable);

    Page<Student> findByMasinhvien(String code, Pageable pageable);
    Student findByMasinhvien(String code);

}
