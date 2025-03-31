package com.student.dto;

import java.time.LocalDate;

public record UpdateStudentDto(
        String firstName,
        String lastName,
        String gender,
        String grade,
        String age,
        String email,
        String phone,
        String address,
        LocalDate updateAt,
        LocalDate deleteAt
) {
}
