package com.munira.reactive.controller;

import com.munira.reactive.model.Student;
import com.munira.reactive.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
public class StudentController {
    StudentService studentService;

    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/students", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Student> studentFlux() {
        return studentService.studentFlux();
    }

    @PostMapping("/add-student")
    Mono<Student> addStudentMono(@RequestBody Student student) {
        return studentService.addStudentMono(student.getName(), student.getEmail());
    }

    @PutMapping("/update/student/{id}")
    Flux<Student> updateStudent(@PathVariable UUID id, @RequestBody Student updatedStudent) {
        return studentService.updateStudent(id, updatedStudent);
    }

    @DeleteMapping("/delete/student/{id}")
    Mono<Void> deleteStudent(@PathVariable UUID id) {
        return studentService.deleteStudent(id);
    }
}
