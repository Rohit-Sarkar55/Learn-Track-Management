package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private List<Course> courseRecord= new ArrayList<>();

    public void addCourse(Course course){
        this.courseRecord.add(course);
    }
    public Course searchCourseById(int courseId){
        return courseRecord.stream()
                .filter(course -> course.getId() == courseId)
                .findFirst()
                .orElse(null);
    }

    public List<Course> getAllCourses(){
        return this.courseRecord;
    }
}
