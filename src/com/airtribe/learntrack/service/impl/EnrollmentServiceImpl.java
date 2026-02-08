package com.airtribe.learntrack.service.impl;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnrollmentServiceImpl implements EnrollmentService {

    private EnrollmentRepository enrollmentRepository;
    private CourseService courseService;
    private StudentService studentService;


    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository, StudentService studentService, CourseService courseService){
        this.enrollmentRepository = enrollmentRepository;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @Override
    public void addEnrollment(int studentId, int courseId) {
        Enrollment enrollment = new Enrollment(courseId, studentId, LocalDate.now(), EnrollmentStatus.ACTIVE);
        this.enrollmentRepository.makeEnrollment(enrollment);
    }

    @Override
    public void printAllEnrollments() {
        this.enrollmentRepository.getEnrollments().forEach(System.out::println);
    }

    @Override
    public void viewEnrollmentsWithStudentId(int studentId) {
        List<Enrollment> enrollments = this.enrollmentRepository.getEnrollmentsWithStudentId(studentId);
        Student student = studentService.searchStudentWithStudentId(studentId);
        if(student != null) {
            Map<Enrollment, Course> courseEnrollmentMap = new HashMap<>();
            enrollments.stream().forEach(enrollment -> {
                Course c = courseService.searchCourseWithCourseId(enrollment.getCourseId());
                courseEnrollmentMap.put(enrollment,c);
            });
            System.out.println("\nCourse Enrollments for " + student.getName());
            System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.printf(
                    "| %-15s | %-30s | %-10s | %-8s | %-15s | %-10s |%n",
                    "Course Name",
                    "Description",
                    "Duration",
                    "Active",
                    "Enrollment Date",
                    "Status"
            );
            System.out.println("-------------------------------------------------------------------------------------------------------");

            courseEnrollmentMap.forEach((enrollment, course) -> {
                System.out.printf(
                        "| %-15s | %-30s | %-10s | %-8s | %-15s | %-10s |%n",
                        course.getCourseName(),
                        course.getDescription(),
                        course.getDurationInWeeks(),
                        course.isActive() ? "Yes" : "No",
                        enrollment.getEnrollmentDate(),
                        enrollment.getStatus()
                );
            });

            System.out.println("-------------------------------------------------------------------------------------------------------");

        }
    }

    @Override
    public void completeEnrollment(int enrollmentId) {
        enrollmentRepository.changeEnrollmentStatus(enrollmentId,EnrollmentStatus.COMPLETED);
    }

    @Override
    public void cancelEnrollment(int enrollmentId) {
        enrollmentRepository.changeEnrollmentStatus(enrollmentId, EnrollmentStatus.CANCELLED);
    }
}
