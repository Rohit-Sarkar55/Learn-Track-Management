package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EnrollmentRepository {

    private List<Enrollment> enrollments = new ArrayList<>();

    public void makeEnrollment(Enrollment enrollment){
        enrollments.add(enrollment);
    }

    public List<Enrollment> getEnrollments(){
        return enrollments;
    }

    public List<Enrollment> getEnrollmentsWithStudentId(int studentId){
        return enrollments.stream()
                .filter(enrollment -> enrollment.getStudentId() == studentId)
                .collect(Collectors.toList());
    }

    public void changeEnrollmentStatus(int enrollmentId, EnrollmentStatus status){
        Enrollment enrollment = enrollments.stream().filter(enr -> enr.getId() == enrollmentId)
                .findAny().orElse(null);
        if(enrollment != null){
            enrollment.setStatus(status);
        }
    }
}
