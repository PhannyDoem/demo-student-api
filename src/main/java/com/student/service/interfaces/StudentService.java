package com.student.service.interfaces;

import com.student.dto.PostStudentDto;
import com.student.dto.UpdateStudentDto;
import com.student.entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(PostStudentDto postStudentDto);
    List<Student> getAllStudents();
    Student getStudentById(Long studentId);
    List<Student> getStudentByFirstNameAndLastName(String firstName, String lastName);
    Student updateStudentById(Long studentId, UpdateStudentDto updateStudentDto);
    String deleteStudent(Long studentId);
    List<Student> getAllStudentsRecovery();
    String deleteStudentRecovery(Long studentId);
    Student studentRestore(Long studentId);
}
