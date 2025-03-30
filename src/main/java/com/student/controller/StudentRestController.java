package com.student.controller;

import com.student.dto.PostStudentDto;
import com.student.entity.Student;
import com.student.service.StudentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/value/v1")
public class StudentRestController {
    private final StudentServiceImplementation studentServiceImplementation;

    @Autowired
    public StudentRestController(StudentServiceImplementation studentServiceImplementation) {
        this.studentServiceImplementation = studentServiceImplementation;
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody PostStudentDto postStudentDto) {
        return new ResponseEntity<>(studentServiceImplementation.createStudent(postStudentDto), HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentServiceImplementation.getAllStudents(), HttpStatus.OK);
    }


}
