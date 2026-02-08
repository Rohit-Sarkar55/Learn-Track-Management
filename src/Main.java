//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.service.impl.CourseServiceImpl;
import com.airtribe.learntrack.service.impl.StudentServiceImpl;

public class Main {

    public static void main(String[] args) {

        StudentRepository repository = new StudentRepository();


        StudentService service = new StudentServiceImpl(repository);
        CourseService courseService = new CourseServiceImpl(new CourseRepository());

        Student s = new Student("Rohit","Sarkar", "rohit@gmail.com");
        Student s1 = new Student("Rahul", "Smith", "rahul@gmail.com");

        Course c1 = new Course("Java Backend", "Java Course for Student", 10);


        service.addStudent(s);
        service.addStudent(s1);
        service.removeStudent(2);
        service.listAllStudent();
        courseService.addCourse(c1);
        courseService.listAllCourse();

    }
}
