//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.airtribe.learntrack.entity.Student;

public class Main {

    public static void main(String[] args) {
        Student s = new Student("Rohit","Sarkar", "rohit@gmail.com");
        Student s1 = new Student("Rahul", "Smith", "rahul@gmail.com");
        s1.setActive(false);
        System.out.println(s +"\n"+ s1);


    }
}
