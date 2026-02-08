package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private List<Student> studentRecord= new ArrayList<>();

    public void addStudent(Student student){
        this.studentRecord.add(student);
    }
    public Student searchStudentById(int studentId){
        return studentRecord.stream()
                .filter(student -> student.getId() == studentId)
                .findFirst()
                .orElse(null);
    }

    public List<Student> getAllStudents()
    {
        return this.studentRecord;
    }
}
