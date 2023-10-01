package com.example.cnpm.service;

import com.example.cnpm.dto.StudentDTO;
import com.example.cnpm.dto.TeacherDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherService {
    Page<TeacherDTO> getAll(Pageable pageable);
    Page<TeacherDTO> findByName(String name,Pageable pageable);
    Page<TeacherDTO> findByCode(String code,Pageable pageable);
    TeacherDTO findByCode(String code);
    void insert(TeacherDTO teacherDTO);
    void delete(long id);
}
