package firstspringprojects.demorestcontroler.rest;

import firstspringprojects.demorestcontroler.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private List<Student> students;

    @PostConstruct
    public void loadData() {


        students = new ArrayList<>();

        students.add(new Student("Monika", "Karcheva"));
        students.add(new Student("Liliya", "Karcheva"));
        students.add(new Student("Iliyan", "Karchev"));
    }


    @GetMapping("/students")
    public List<Student> getStudent() {

        return this.students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) throws StudentNotFoundException {


        if (studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student not found - " + studentId);

        }

        return this.students.get(studentId);
    }

}
