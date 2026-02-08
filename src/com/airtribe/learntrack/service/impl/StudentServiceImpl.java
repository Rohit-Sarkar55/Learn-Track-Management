package com.airtribe.learntrack.service.impl;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.StudentService;

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
        Student student = searchStudentWithStudentId(studentId);
        if(student != null){
            student.setActive(false);
        }
    }

    @Override
    public void updateStudent(int studentId) {

    }

    @Override
    public void printAllStudent() {
        this.studentRepository.getAllStudents().forEach(System.out::println);
    }

    @Override
    public Student searchStudentWithStudentId(int studentId) {
        try {
            return studentRepository.searchStudentById(studentId);
        }catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
