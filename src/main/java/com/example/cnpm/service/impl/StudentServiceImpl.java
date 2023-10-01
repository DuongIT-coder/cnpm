package com.example.cnpm.service.impl;

import com.example.cnpm.dto.StudentDTO;
import com.example.cnpm.entity.Role;
import com.example.cnpm.entity.Student;
import com.example.cnpm.mapper.StudentMapper;
import com.example.cnpm.repository.RoleRepository;
import com.example.cnpm.repository.StudentRepository;
import com.example.cnpm.repository.TeacherRepository;
import com.example.cnpm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StudentServiceImpl implements StudentService {
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncode;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper mapper;
    public StudentServiceImpl(StudentRepository studentRepository,RoleRepository roleRepository
            , PasswordEncoder passwordEncode
    ){
        this.passwordEncode=passwordEncode;
        this.studentRepository=studentRepository;
        this.roleRepository=roleRepository;
    }


//    private Role checkRoleExist1(){
//        Role role= new Role();
//        role.setName("ROLE_TEACHER");
//        return roleRepository.save(role);
//    }
    private Role checkRoleExist(){
        Role role= new Role();
        role.setName("ROLE_STUDENT");
        return roleRepository.save(role);
    }
//    private Role checkRoleExist2(){
//        Role role= new Role();
//        role.setName("ROLE_ADMIN");
//        return roleRepository.save(role);
//    }
    @Override
    public Page<StudentDTO> getAll(Pageable pageable) {
        return studentRepository.findAll(pageable).map(x->mapper.convertToDTO(x));
    }

    @Override
    public Page<StudentDTO> findByName(String name,Pageable pageable) {
        Page<StudentDTO> studentDTOS= studentRepository.findByTen(name,pageable).map(x->mapper.convertToDTO(x));
        return studentDTOS;
    }

    @Override
    public Page<StudentDTO> findByCode(String code,Pageable pageable) {
        Page<StudentDTO> studentDTOS= studentRepository.findByMasinhvien(code,pageable).map(x->mapper.convertToDTO(x));
        return studentDTOS;
    }

    @Override
    public StudentDTO findByCode(String code) {
        return mapper.convertToDTO(studentRepository.findByMasinhvien(code));
    }

    @Override
    public StudentDTO findById(long id) {
        return mapper.convertToDTO(studentRepository.findById(id).get());
    }

    @Override
    public void insert(StudentDTO studentDTO) {
        studentRepository.save(mapper.convertToEntity(studentDTO));
    }

    @Override
    public void delete(long id) {
        studentRepository.delete(studentRepository.findById(id).get());
    }

    @Override
    public void regist(StudentDTO studentDTO) {
        Student student= new Student();
        student.setTen(studentDTO.getTen());
        student.setLop(studentDTO.getLop());
        student.setMasinhvien(studentDTO.getMasinhvien());
        student.setPassword(passwordEncode.encode(studentDTO.getPassword()));
        Role role = roleRepository.findByName("ROLE_STUDENT");
        if(role==null){
            role=checkRoleExist();
        }
        student.setRole(Arrays.asList(role));
        studentRepository.save(student);
    }
}
