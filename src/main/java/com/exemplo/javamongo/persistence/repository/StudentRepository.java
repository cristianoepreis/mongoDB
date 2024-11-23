package com.exemplo.javamongo.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.exemplo.javamongo.persistence.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>{
    
}
