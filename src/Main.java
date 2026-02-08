//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.service.impl.CourseServiceImpl;
import com.airtribe.learntrack.service.impl.EnrollmentServiceImpl;
import com.airtribe.learntrack.service.impl.StudentServiceImpl;

public class Main {

    public static void main(String[] args) {

        StudentRepository repository = new StudentRepository();


        StudentService service = new StudentServiceImpl(repository);
        CourseService courseService = new CourseServiceImpl(new CourseRepository());
        EnrollmentService enrollmentService = new EnrollmentServiceImpl(new EnrollmentRepository(),service, courseService);

        Student s = new Student("Rohit","Sarkar", "rohit@gmail.com");
        Student s1 = new Student("Rahul", "Smith", "rahul@gmail.com");

        Course c1 = new Course("Java Backend", "Java Course for Student", 10);
        Course c2 = new Course("NodeJS Backend", "NodeJS Course for Student", 8);



        service.addStudent(s);
        service.addStudent(s1);
        service.removeStudent(2);
        service.printAllStudent();
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
    }
}
