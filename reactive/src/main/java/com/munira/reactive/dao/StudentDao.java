package com.munira.reactive.dao;

import com.munira.reactive.model.Student;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Getter
@Repository
public class StudentDao {
    private Flux<Student> studentFlux = Flux.empty();


    public Mono<Student> addStudentMono(String name, String email) {
        UUID id = UUID.randomUUID();
        Student student = new Student(id, name, email);
        studentFlux = studentFlux.concatWithValues(student);
        return Mono.just(student);
    }

    public Flux<Student> updateStudent(UUID id, Student updatedStudent) {
        return studentFlux
                .index()
                .filter(tuple -> tuple.getT2().getId().equals(id))
                .flatMap(tuple -> {
                    Student existingStudent = tuple.getT2();
                    existingStudent.setName(updatedStudent.getName());
                    existingStudent.setEmail(updatedStudent.getEmail());
                    return Mono.just(existingStudent);
                })
                .switchIfEmpty(Mono.empty());
    }


    public Mono<Void> deleteStudent(UUID id) {
        return studentFlux
                .filter(student -> !student.getId().equals(id))
                .collectList()
                .flatMap(students -> {
                    if (students.size() < studentFlux.collectList().block().size()) {
                        studentFlux = Flux.fromIterable(students);
                        return Mono.empty();
                    } else {
                        return Mono.error(new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Student not found with ID: " + id));
                    }
                });
    }
}
