package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.service.CourseService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CourseManager {
    private CourseService courseService;

    private Scanner sc;

    public CourseManager(CourseService courseService){
        this.courseService = courseService;
        sc = new Scanner(System.in);
    }

    private void addCourseUI(){
        try {
            sc.nextLine(); // clear any leftover newline

            System.out.println("Enter your course name: ");
            String courseName = sc.nextLine();

            System.out.println("Enter course description: ");
            String description = sc.nextLine();

            System.out.println("Enter course duration in weeks: ");
            int durationInWeeks = sc.nextInt();

            Course course = new Course(courseName, description, durationInWeeks);
            courseService.addCourse(course);

        } catch (InputMismatchException e) {
            System.out.println(AppConstants.INPUT_MISMATCH_EXCEPTION);
            sc.next(); // clear invalid input
        }
    }

    private void deactivateCourseUI(){
        try{
            System.out.println("Enter the course id: ");
            int courseId = sc.nextInt();
            courseService.removeCourse(courseId);
        }catch (InputMismatchException e){
            System.out.println(AppConstants.INPUT_MISMATCH_EXCEPTION);
        }
    }

    public void courseManagerMenu(){
        boolean running = true;
        while(running) {
            DisplayMenu.courseMenu();
            System.out.println("Enter your choice");
            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        addCourseUI();
                        break;
                    case 2:
                        deactivateCourseUI();
                        break;
                    case 3:
                        courseService.printAllCourse();
                        break;
                    case 4:
                        running = false;
                        break;
                    default:
                        System.out.println(AppConstants.INPUT_MISMATCH_EXCEPTION);
                        break;

                }

            }catch (InputMismatchException e){
                System.out.println(AppConstants.INPUT_MISMATCH_EXCEPTION);
                sc.next();
            }


        }
    }
}
