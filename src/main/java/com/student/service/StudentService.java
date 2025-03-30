package com.student.service;

import com.student.dto.PostStudentDto;
import com.student.entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(PostStudentDto postStudentDto);
    List<Student> getAllStudents();
}
