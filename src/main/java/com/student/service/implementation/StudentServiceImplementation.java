package com.student.service.implementation;

import com.student.dto.PostStudentDto;
import com.student.dto.UpdateStudentDto;
import com.student.entity.Student;
import com.student.mapper.StudentMapper;
import com.student.repository.StudentRepository;
import com.student.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
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
        return studentRepository.findByDeleteAtIsNull();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(()-> new RuntimeException("Student not found"));
    }

    @Override
    public List<Student> getStudentByFirstNameAndLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Student updateStudentById(Long studentId, UpdateStudentDto updateStudentDto) {
        Student student = studentMapper.updateStudentDto(updateStudentDto);
        return studentRepository.findById(studentId).map(
                student1 -> {
                student1.setFirstName(student1.getFirstName());
                student1.setLastName(student1.getLastName());
                    student1.setGender(student1.getGender());
                    student1.setGrade(student1.getGrade());
                    student1.setAge(student1.getAge());
                    student1.setEmail(student1.getEmail());
                    student1.setPhone(student1.getPhone());
                    student1.setAddress(student1.getAddress());
                    student1.setUpdateAt(student1.getUpdateAt());
                    student1.setDeleteAt(student1.getDeleteAt());
                    Student updatedStudent = studentRepository.save(student1);
                    return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
                }
        ).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND)).getBody();
    }

    @Override
    public String deleteStudent(Long studentId) {
        studentRepository.findById(studentId)
                .map(
                        studentExists->{
                            studentExists.setDeleteAt(LocalDate.now());
                            return studentRepository.save(studentExists);
                        }
                );
        return "Student deleted in time :" + LocalDate.now();
    }

    @Override
    public List<Student> getAllStudentsRecovery() {
        return studentRepository.findByDeleteAtNotNull();
    }

    @Override
    public String deleteStudentRecovery(Long studentId) {
        studentRepository.deleteById(studentId);
        return "Deleted Student Successfully";
    }

    @Override
    public Student studentRestore(Long studentId) {
       return studentRepository.findById(studentId)
                .map(
                        studentRestore -> {
                            studentRestore.setDeleteAt(null);
                            return studentRepository.save(studentRestore);
                        }
                ).orElseThrow(() -> new RuntimeException("Student not found"));
    }


}
