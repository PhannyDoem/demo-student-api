package com.student.repository;

import com.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "select student from Student student where student.deleteAt is null ")
    List<Student> findByDeleteAtIsNull();

    @Query("select student from Student student where student.deleteAt is not null")
    List<Student> findByDeleteAtNotNull();

    @Query("SELECT s FROM Student s WHERE s.firstName = :firstName AND s.lastName = :lastName")
    List<Student> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);


}
