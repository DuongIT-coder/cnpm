package com.example.cnpm.service.impl;

import com.example.cnpm.dto.TeacherDTO;
import com.example.cnpm.mapper.TeacherMapper;
import com.example.cnpm.repository.TeacherRepository;
import com.example.cnpm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    TeacherMapper mapper;
    @Override
    public Page<TeacherDTO> getAll(Pageable pageable) {
        return teacherRepository.findAll(pageable).map(x->mapper.convertToDTO(x));
    }

    @Override
    public Page<TeacherDTO> findByName(String name,Pageable pageable ) {
        return teacherRepository.findByTen(name,pageable).map(x->mapper.convertToDTO(x));
    }

    @Override
    public Page<TeacherDTO> findByCode(String code,Pageable pageable) {
        return teacherRepository.findByMagiaovien(code,pageable).map(x->mapper.convertToDTO(x));
    }

    @Override
    public TeacherDTO findByCode(String code) {
        return mapper.convertToDTO(teacherRepository.findByMagiaovien(code));
    }

    @Override
    public void insert(TeacherDTO teacherDTO) {
        teacherRepository.save(mapper.convertToEntity(teacherDTO));
    }

    @Override
    public void delete(long id) {
        teacherRepository.delete(teacherRepository.findById(id).get());
    }
}
