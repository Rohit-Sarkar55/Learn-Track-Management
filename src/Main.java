//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.service.impl.CourseServiceImpl;
import com.airtribe.learntrack.service.impl.EnrollmentServiceImpl;
import com.airtribe.learntrack.service.impl.StudentServiceImpl;
import com.airtribe.learntrack.ui.CourseManager;
import com.airtribe.learntrack.ui.DisplayMenu;
import com.airtribe.learntrack.ui.StudentManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentRepository repository = new StudentRepository();


        StudentService studentService = new StudentServiceImpl(new StudentRepository());
        CourseService courseService = new CourseServiceImpl(new CourseRepository());
        EnrollmentService enrollmentService = new EnrollmentServiceImpl(new EnrollmentRepository(),studentService, courseService);

        Student s = new Student("Rohit","Sarkar", "rohit@gmail.com");
        Student s1 = new Student("Rahul", "Smith", "rahul@gmail.com");

        Course c1 = new Course("Java Backend", "Java Course for Student", 10);
        Course c2 = new Course("NodeJS Backend", "NodeJS Course for Student", 8);



        studentService.addStudent(s);
        studentService.addStudent(s1);
        studentService.removeStudent(2);
        studentService.printAllStudent();
        courseService.addCourse(c1);
        courseService.addCourse(c2);
        courseService.printAllCourse();
        enrollmentService.addEnrollment(1,101);
        enrollmentService.addEnrollment(1,102);
        enrollmentService.addEnrollment(2,101);
        enrollmentService.printAllEnrollments();
        enrollmentService.viewEnrollmentsWithStudentId(1);
        enrollmentService.completeEnrollment(1001);
        enrollmentService.cancelEnrollment(1003);
        enrollmentService.printAllEnrollments();

        courseService.searchCourseWithCourseId(45);
        enrollmentService.addEnrollment(1, 35);

        studentService.searchStudentWithStudentId(7);

        boolean running = true;
        Scanner sc = new Scanner(System.in);
        while(running) {
            DisplayMenu.mainMenu();
            System.out.println("Enter your choice ");
            try {
                int choices = sc.nextInt();
                switch (choices) {
                    case 1:
                        StudentManager studentManager = new StudentManager(studentService,enrollmentService);
                        studentManager.studentManagerMenu();
                        break;
                    case 2:
                        CourseManager courseManager = new CourseManager(courseService);
                        courseManager.courseManagerMenu();
                        break;
                    case 3:
                        System.out.println(3);
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
        System.out.println("Thank You.............");
    }
}
