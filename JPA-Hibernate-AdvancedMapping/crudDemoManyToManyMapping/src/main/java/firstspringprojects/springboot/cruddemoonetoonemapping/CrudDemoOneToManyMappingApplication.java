package firstspringprojects.springboot.cruddemoonetoonemapping;

import firstspringprojects.springboot.cruddemoonetoonemapping.dao.AppDAO;

import firstspringprojects.springboot.cruddemoonetoonemapping.entity.Course;
import firstspringprojects.springboot.cruddemoonetoonemapping.entity.Review;
import firstspringprojects.springboot.cruddemoonetoonemapping.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoOneToManyMappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoOneToManyMappingApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {

            //createCourseAndStudent(appDAO);

            // findCourseAndStudents(appDAO);

            //findStudentAndCourses(appDAO);

            //   addCoursesToStudent(appDAO);

            //deleteCourse(appDAO);

            deleteStudent(appDAO);

        };

    }

    private void deleteStudent(AppDAO appDAO) {

        int id = 1;

        appDAO.deleteStudentById(id);
        System.out.println("Done!");
    }

    private void deleteCourse(AppDAO appDAO) {
        int id = 14;
        appDAO.deleteCourseById(id);

        System.out.println("Done!");
    }

    private void addCoursesToStudent(AppDAO appDAO) {
        int id = 2;
        Student student = appDAO.findStudentAndCoursesByStudentId(id);
        Course course = new Course("The Course");
        Course course2 = new Course("Language Course");
        student.addCourse(course);
        student.addCourse(course2);
        appDAO.update(student);


    }

    private void findStudentAndCourses(AppDAO appDAO) {
        int id = 2;
        Student student = appDAO.findStudentAndCoursesByStudentId(id);

        System.out.println("Student: " + student);
        System.out.println("Courses: " + student.getCourses());
        System.out.println("Done!");

    }

    private void findCourseAndStudents(AppDAO appDAO) {

        int id = 10;

        Course course = appDAO.findCourseAndStudentsByCourseId(id);

        System.out.println("Loaded Course: " + course);
        System.out.println("Students: " + course.getStudents());

    }

    private void createCourseAndStudent(AppDAO appDAO) {

        Course course = new Course("Test Course");

        Student student = new Student("First", "Last", "trest@mail.com");
        Student student2 = new Student("Second", "Last", "trest@mail.com");

        course.addStudent(student);
        course.addStudent(student2);

        System.out.println("Creating Course" + course);
        System.out.println("Students: " + course.getStudents());
        appDAO.save(course);

        System.out.println("Done!");


    }


}
