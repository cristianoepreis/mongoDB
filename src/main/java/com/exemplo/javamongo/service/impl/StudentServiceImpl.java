package com.exemplo.javamongo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.javamongo.model.StudentRequest;
import com.exemplo.javamongo.model.StudentResponse;
import com.exemplo.javamongo.persistence.entity.Student;
import com.exemplo.javamongo.persistence.repository.StudentRepository;
import com.exemplo.javamongo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public StudentResponse create(StudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setDocument(request.getDocument());
        student.setBirthDate(request.getBirthDate());
        
        repository.save(student);

        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setDocument(student.getDocument());
        response.setBirthDate(student.getBirthDate());

        return createResponse(student);
    }

    @Override
    public List<StudentResponse> getAll() {
        List<StudentResponse> responses = new ArrayList<>();

        List<Student> students = repository.findAll();

        if(!students.isEmpty()){
            students.forEach(student -> responses.add(createResponse(student)));
        }

        return responses;
    }
        

    private StudentResponse createResponse(Student student) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setDocument(student.getDocument());
        response.setBirthDate(student.getBirthDate());

        return response;
    }
}
