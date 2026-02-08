package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;

public interface CourseService {
    void addCourse(Course course);
    void removeCourse(int courseId);
    void updateCourse();
    void listAllCourse();
}
