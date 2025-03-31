package com.student.controller;

import com.student.dto.PostStudentDto;
import com.student.dto.UpdateStudentDto;
import com.student.entity.Student;
import com.student.service.implementation.StudentServiceImplementation;
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

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentServiceImplementation.getStudentById(studentId);
    }

    @GetMapping("/students/search")
    public ResponseEntity<List<Student>> getStudentByFirstNameAndLastName(@RequestParam String firstName,@RequestParam String lastName) {
        return new ResponseEntity<>(studentServiceImplementation.getStudentByFirstNameAndLastName(firstName, lastName), HttpStatus.OK);
    }

    @PutMapping("/students/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId, @RequestBody UpdateStudentDto updateStudentDto) {
        return new ResponseEntity<>(studentServiceImplementation.updateStudentById(studentId, updateStudentDto), HttpStatus.OK);
    }

    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId) {
        return new ResponseEntity<>(studentServiceImplementation.deleteStudent(studentId), HttpStatus.OK);
    }

    @GetMapping("/students/recovery")
    public ResponseEntity<List<Student>> getAllStudentRecovery(){
        return new ResponseEntity<>(studentServiceImplementation.getAllStudentsRecovery(), HttpStatus.OK);
    }

   @DeleteMapping("students/recovery/{studentId}")
    public ResponseEntity<String> deleteStudentRecovery(@PathVariable Long studentId) {
        return new ResponseEntity<>(studentServiceImplementation.deleteStudentRecovery(studentId), HttpStatus.OK);
    }

    @PostMapping("/students/recovery/{studentId}")
    public ResponseEntity<Student> studentRestore(@PathVariable Long studentId) {
        return new ResponseEntity<>(studentServiceImplementation.studentRestore(studentId), HttpStatus.OK);
    }
}
