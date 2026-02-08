package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    void removeStudent(int studentId);
    void updateStudent(int studentId);
    void listAllStudent();
}
