package com.student.mapper;

import com.student.dto.PostStudentDto;
import com.student.dto.UpdateStudentDto;
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

    public Student updateStudentDto(UpdateStudentDto updateStudentDto) {
        Student student = new Student(
                updateStudentDto.firstName(),
                updateStudentDto.lastName(),
                updateStudentDto.gender(),
                updateStudentDto.grade(),
                updateStudentDto.age(),
                updateStudentDto.email(),
                updateStudentDto.phone(),
                updateStudentDto.address(),
                updateStudentDto.updateAt(),
                updateStudentDto.deleteAt()
        );
        student.setStudentId(0L);
        return student;
    };
}
