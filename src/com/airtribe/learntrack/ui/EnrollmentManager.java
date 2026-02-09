package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.service.EnrollmentService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EnrollmentManager {
    private EnrollmentService enrollmentService;
    private Scanner sc;
    public EnrollmentManager(EnrollmentService enrollmentService){
        this.enrollmentService = enrollmentService;
        this.sc = new Scanner(System.in);
    }



    private void makeEnrollmentUI(){
        try {
            sc.nextLine();

            System.out.println("Enter your course Id: ");
            int courseId = sc.nextInt();

            System.out.println("Enter your student Id: ");
            int studentId = sc.nextInt();

            enrollmentService.addEnrollment(studentId,courseId);

        } catch (InputMismatchException e) {
            System.out.println(AppConstants.INPUT_MISMATCH_EXCEPTION);
            sc.next();
        }
    }

    private void viewEnrollmentsForAStudent(){
        try {
            sc.nextLine();

            System.out.println("Enter your student Id: ");
            int studentId = sc.nextInt();

            enrollmentService.viewEnrollmentsWithStudentId(studentId);

        } catch (InputMismatchException e) {
            System.out.println(AppConstants.INPUT_MISMATCH_EXCEPTION);
            sc.next();
        }
    }

    private void completeEnrollment(){
        try {
            sc.nextLine(); // clear any leftover newline

            System.out.println("Enter your enrollment Id: ");
            int enrollmentId = sc.nextInt();

            enrollmentService.completeEnrollment(enrollmentId);
        } catch (InputMismatchException e) {
            System.out.println(AppConstants.INPUT_MISMATCH_EXCEPTION);
            sc.next(); // clear invalid input
        }
    }

    private void cancelEnrollment(){
        try {
            sc.nextLine();

            System.out.println("Enter your enrollment Id: ");
            int enrollmentId = sc.nextInt();

            enrollmentService.cancelEnrollment(enrollmentId);
        } catch (InputMismatchException e) {
            System.out.println(AppConstants.INPUT_MISMATCH_EXCEPTION);
            sc.next();
        }
    }

    public void enrollmentManagerMenu(){
        boolean running = true;
        while(running) {
            DisplayMenu.enrollmentMenu();
            System.out.println("Enter your choice");
            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        makeEnrollmentUI();
                        break;
                    case 2:
                        viewEnrollmentsForAStudent();
                        break;
                    case 3:
                        completeEnrollment();
                        break;
                    case 4:
                        cancelEnrollment();
                        break;
                    case 5:
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
