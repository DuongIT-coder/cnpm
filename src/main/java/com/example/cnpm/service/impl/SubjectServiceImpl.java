package com.example.cnpm.service.impl;

import com.example.cnpm.dto.SubjectDTO;
import com.example.cnpm.mapper.SubjectMapper;
import com.example.cnpm.repository.SubjectRepository;
import com.example.cnpm.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    SubjectMapper mapper;
    @Override
    public Page<SubjectDTO> getAll(Pageable pageable) {
        return subjectRepository.findAll(pageable).map(x->mapper.convertToDTO(x));
    }

    @Override
    public Page<SubjectDTO> findByName(String name,Pageable pageable) {
        return subjectRepository.findByTenmonhoc(name,pageable).map(x->mapper.convertToDTO(x));
    }

    @Override
    public Page<SubjectDTO> findByCode(String code,Pageable pageable) {
        return subjectRepository.findByKihieu(code,pageable).map(x->mapper.convertToDTO(x));
    }

    @Override
    public void insert(SubjectDTO subjectDTO) {
        subjectRepository.save(mapper.convertToEntity(subjectDTO));
    }

    @Override
    public void delete(long id) {
        subjectRepository.delete(subjectRepository.findById(id).get());
    }

    @Override
    public SubjectDTO findById(long id) {
        return mapper.convertToDTO(subjectRepository.findById(id).get());
    }
}
