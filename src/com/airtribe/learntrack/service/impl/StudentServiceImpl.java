package com.airtribe.learntrack.service.impl;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    //Constructor Injection
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public void addStudent(Student student) {
        this.studentRepository.addStudent(student);
    }

    @Override
    public void removeStudent(int studentId) {
        Student student = this.studentRepository.searchStudentById(studentId);
        if(student != null){
            student.setActive(false);
        }
    }

    @Override
    public void updateStudent(int studentId) {

    }

    @Override
    public void listAllStudent() {
        this.studentRepository.printAllStudent();
    }
}
