//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.service.impl.StudentServiceImpl;

public class Main {

    public static void main(String[] args) {

        StudentRepository repository = new StudentRepository();


        StudentService service = new StudentServiceImpl(repository);

        Student s = new Student("Rohit","Sarkar", "rohit@gmail.com");
        Student s1 = new Student("Rahul", "Smith", "rahul@gmail.com");
        s1.setActive(false);
        service.addStudent(s);
        service.addStudent(s1);
        service.listAllStudent();


    }
}
