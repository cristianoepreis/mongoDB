package com.exemplo.javamongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.javamongo.model.StudentRequest;
import com.exemplo.javamongo.model.StudentResponse;
import com.exemplo.javamongo.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<StudentResponse> create(@RequestBody StudentRequest request){
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
}
