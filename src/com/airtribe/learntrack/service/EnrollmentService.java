package com.airtribe.learntrack.service;

public interface EnrollmentService {

    void addEnrollment(int studentId, int courseId);
    void printAllEnrollments();
    void viewEnrollmentsWithStudentId(int studentId);
}
