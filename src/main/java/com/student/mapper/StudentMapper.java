package com.student.mapper;

import com.student.dto.PostStudentDto;
import com.student.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public Student postToStudentDto(PostStudentDto postStudentDto) {
        Student student = new Student(
                postStudentDto.firstName(),
                postStudentDto.lastName(),
                postStudentDto.gender(),
                postStudentDto.grade(),
                postStudentDto.age(),
                postStudentDto.email(),
                postStudentDto.phone(),
                postStudentDto.address(),
                postStudentDto.updateAt(),
                postStudentDto.deleteAt()
        );
        student.setStudentId(0L);
        return student;
    }
}
