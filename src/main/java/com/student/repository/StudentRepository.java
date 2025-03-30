package com.student.repository;

import com.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "select Student from Student where deleteAt is not null ")
    List<Student> findByDeleteAtIsNotNull();
}
