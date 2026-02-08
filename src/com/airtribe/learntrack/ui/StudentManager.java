package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.MenuOption;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManager {
    private StudentService studentService;
    private EnrollmentService enrollmentService;
    private Scanner sc;

    public StudentManager(StudentService studentService, EnrollmentService enrollmentService){
        this.studentService = studentService;
        this.enrollmentService = enrollmentService;
        this.sc = new Scanner(System.in);
    }
    private void addStudentUI(){
        try {
            Student student = new Student();
            System.out.println("Enter Student's First Name: ");
            String fName = sc.next();
            student.setFirstName(fName);
            System.out.println("Enter Student's Last Name: ");
            String lName = sc.next();
            student.setLastName(lName);
            System.out.println("Enter Student's Email");
            String email = sc.next();
            student.setEmail(email);
            studentService.addStudent(student);
        }catch (InputMismatchException e){
            System.out.println(AppConstants.INPUT_MISMATCH_EXCEPTION);
        }
    }

    private void removeStudentUI(){
        try{
            System.out.println("Enter Student's Id: ");
            int studentId = sc.nextInt();
            studentService.removeStudent(studentId);
        }catch (InputMismatchException e){
            System.out.println(AppConstants.INPUT_MISMATCH_EXCEPTION);
        }
    }

    private void searchStudentByIdUI(){

        try{
            System.out.println("Enter Student's Id: ");
            int studentId = sc.nextInt();
            enrollmentService.viewEnrollmentsWithStudentId(studentId);
        }catch (InputMismatchException e){
            System.out.println(AppConstants.INPUT_MISMATCH_EXCEPTION);
        }
    }

    public void studentManagerMenu(){
        boolean running = true;
        while(running) {
            DisplayMenu.studentMenu();
            System.out.println("Enter your choice");
            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        addStudentUI();
                        break;
                    case 2:
                        removeStudentUI();
                        break;
                    case 3:
                        searchStudentByIdUI();
                        break;
                    case 4:
                        studentService.printAllStudent();
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
