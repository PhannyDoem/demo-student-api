package com.student.service;

import com.student.dto.PostStudentDto;
import com.student.entity.Student;
import com.student.mapper.StudentMapper;
import com.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImplementation(
            StudentRepository studentRepository,
            StudentMapper studentMapper
    ) {
       this.studentMapper = studentMapper;
       this.studentRepository = studentRepository;
    }
    @Override
    public Student createStudent(PostStudentDto postStudentDto) {
        Student student = studentMapper.postToStudentDto(postStudentDto);
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
