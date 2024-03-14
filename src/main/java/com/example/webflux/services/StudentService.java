package com.example.webflux.services;

import com.example.webflux.models.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface StudentService {

    Flux<Student> findStudentsByName(String name);

    Mono<Student> findStudentById(long id);

    Mono<Student> addNewStudent(Student student);

    Mono<Student> updateStudent(long id, Student student);

    Mono<Void> deleteStudent(Student student);
}
