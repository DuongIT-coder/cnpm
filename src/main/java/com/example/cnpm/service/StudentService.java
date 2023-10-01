package com.example.cnpm.service;

import com.example.cnpm.dto.StudentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    Page<StudentDTO> getAll(Pageable pageable);
    Page<StudentDTO> findByName(String name,Pageable pageable);
    Page<StudentDTO> findByCode(String code,Pageable pageable);
    StudentDTO findByCode(String code);
    StudentDTO findById(long id);
    void insert(StudentDTO studentDTO);
    void delete(long id);
    void regist(StudentDTO studentDTO);
}
