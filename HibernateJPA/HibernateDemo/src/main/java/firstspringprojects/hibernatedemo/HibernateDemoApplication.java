package firstspringprojects.hibernatedemo;

import firstspringprojects.hibernatedemo.dao.StudentDAO;
import firstspringprojects.hibernatedemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            createStudent(studentDAO);

            createMultipleStudents(studentDAO);

            //findStudentById(studentDAO);

            //queryForStudents(studentDAO);

            //queryForStudentsByLastName(studentDAO);

            //updateStudent(studentDAO);

            //deleteStudent(studentDAO);

            // deleteById(studentDAO);

            //deleteAll(studentDAO);

            //deleteAllStudentsCount(studentDAO);


        };
    }

    private void deleteAllStudentsCount(StudentDAO studentDAO) {
        int count = studentDAO.deleteAllStudents();

        System.out.println("Students removed " + count);

    }

    private void deleteAll(StudentDAO studentDAO) {
        studentDAO.deleteAll();


    }


    private void deleteById(StudentDAO studentDAO) {

        int id = 3;

        studentDAO.deleteById(id);
    }

    private void deleteStudent(StudentDAO studentDAO) {

        studentDAO.delete(studentDAO.findById(1));

    }


    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 1;
        System.out.println("Getting student whit id " + studentId);

        Student student = studentDAO.findById(studentId);
        System.out.println("Updating student");

        student.setFirstName("Tester");
        student.setLastName("Tester");
        studentDAO.update(student);

        System.out.println("Update student " + student);


    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        List<Student> studentList = studentDAO.findByLastName("Doe");

        studentList.forEach(System.out::println);


    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> studentList = studentDAO.findAll();
        studentList.forEach(System.out::println);


    }

    private void findStudentById(StudentDAO studentDAO) {
        Student tempStudent = new Student("name", "lastName", "monka@company.com");
        studentDAO.save(tempStudent);
        Student neededStudent = studentDAO.findById(tempStudent.getId());
        System.out.println(neededStudent);


    }


    private void createMultipleStudents(StudentDAO studentDAO) {

        // create multiple students
        System.out.println("Creating 3 student objects ...");
        Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
        Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

        // save the student objects
        System.out.println("Saving the students ...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

        // save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);


        // display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}