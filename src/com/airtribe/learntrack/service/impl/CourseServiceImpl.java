package com.airtribe.learntrack.service.impl;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.service.CourseService;

public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public void addCourse(Course course) {
        this.courseRepository.addCourse(course);
    }

    @Override
    public void removeCourse(int courseId) {
        Course course = this.courseRepository.searchCourseById(courseId);
        if(course != null){
            course.setActive(false);
        }
    }

    @Override
    public void updateCourse() {

    }

    @Override
    public void listAllCourse() {
        this.courseRepository.printAllCourse();
    }
}
