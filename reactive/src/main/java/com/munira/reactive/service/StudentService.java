package com.munira.reactive.service;

import com.munira.reactive.dao.StudentDao;
import com.munira.reactive.model.Student;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class StudentService {
    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Flux<Student> studentFlux() {
        return studentDao.getStudentFlux();
    }

    public Mono<Student> addStudentMono(String name, String email) {
        return studentDao.addStudentMono(name, email);
    }

    public Flux<Student> updateStudent(UUID id, Student updatedStudent) {
        return studentDao.updateStudent(id, updatedStudent);
    }

    public Mono<Void> deleteStudent(UUID id) {
        return studentDao.deleteStudent(id);
    }
}
