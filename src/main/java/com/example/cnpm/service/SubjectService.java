package com.example.cnpm.service;

import com.example.cnpm.dto.StudentDTO;
import com.example.cnpm.dto.SubjectDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubjectService {
    Page<SubjectDTO> getAll(Pageable pageable);
    Page<SubjectDTO> findByName(String name,Pageable pageable);
    Page<SubjectDTO> findByCode(String code,Pageable pageable);
    void insert(SubjectDTO subjectDTO);
    void delete(long id);

    SubjectDTO findById(long id);
}
