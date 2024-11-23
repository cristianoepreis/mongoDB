package com.exemplo.javamongo.service;

import java.util.List;

import com.exemplo.javamongo.model.StudentRequest;
import com.exemplo.javamongo.model.StudentResponse;

public interface StudentService {

    StudentResponse create(StudentRequest request);

    List<StudentResponse> getAll();

}
