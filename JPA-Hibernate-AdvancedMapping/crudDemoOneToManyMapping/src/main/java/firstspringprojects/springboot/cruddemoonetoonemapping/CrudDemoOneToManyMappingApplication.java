package firstspringprojects.springboot.cruddemoonetoonemapping;

import firstspringprojects.springboot.cruddemoonetoonemapping.dao.AppDAO;
import firstspringprojects.springboot.cruddemoonetoonemapping.entity.Course;
import firstspringprojects.springboot.cruddemoonetoonemapping.entity.Instructor;
import firstspringprojects.springboot.cruddemoonetoonemapping.entity.InstructorDetail;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoOneToManyMappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoOneToManyMappingApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {

            //OneToOne methods without biDirection
            // createInstructor(appDAO);
            // findInstructorById(appDAO);
            // deleteInstructorById(appDAO);
            // findInstructorDetailById(appDAO);


            //Bidirectional OneToOne methods:
            // deleteInstructorDetail(appDAO);


            //oneToMany
            // createInstructorWhitCourses(appDAO);


            //ManyToMany
            //  findInstructorWhitCourses(appDAO);

            // findCoursesForInstructor(appDAO);

            // findInstructorWhitCoursesJoinFetch(appDAO);

            //updateInstructor(appDAO);

            // updateCourse(appDAO);

            // findCourseById(appDAO);

            //updateCourse(appDAO);


           // deleteInstructor(appDAO);

            deleteCourse(appDAO);
        };
    }

    private void deleteCourse(AppDAO appDAO) {

        int id = 10;
        System.out.println("Deleting course whit id: " + id);
        appDAO.deleteCourseById(id);


    }

    private void deleteInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Deleting instructor whit id: " + id);
        appDAO.deleteInstructorById(id);
        System.out.println("Done!");
    }

    private void findCourseById(AppDAO appDAO) {

        int id = 10;
        System.out.println("Finding an Course whit id:" + id);

        Course course = appDAO.findCourseById(id);
        System.out.println("Course: " + course);


    }


    private void updateInstructor(AppDAO appDAO) {

        int id = 1;
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("Instructor last name:" + instructor.getLastName());

        instructor.setLastName("TESTER");

        System.out.println("Instructor new last name: " + instructor.getLastName());
        appDAO.update(instructor);
        System.out.println("Done");


    }

    private void findInstructorWhitCoursesJoinFetch(AppDAO appDAO) {
        int id = 1;

        System.out.println("Find the instructor id: " + id);

        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(id);
        System.out.println("Found the instructor: " + tempInstructor);


    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int id = 2;
        System.out.println("Finding an Instructor whit id:" + id);

        Instructor instructorById = appDAO.findInstructorById(id);
        System.out.println("instructor: " + instructorById);

        System.out.println("Finding courses for instructor id: " + id);

        List<Course> courseList = appDAO.findCoursesByInstructorId(id);

        instructorById.setCourseList(courseList);
        System.out.println(instructorById.getCourseList());

    }

    private void findInstructorWhitCourses(AppDAO appDAO) {

        int id = 1;
        System.out.println("Finding an Instructor whit id:" + id);

        Instructor instructorById = appDAO.findInstructorById(id);
        System.out.println("instructor: " + instructorById);
        System.out.println("the associated courses: " + instructorById.getCourseList());
    }

    private void createInstructorWhitCourses(AppDAO appDAO) {
        Instructor instructor = new Instructor("Eduard", "Nnaji", "nnaji@code.com");

        InstructorDetail instructorDetail = new InstructorDetail("\"https://www.youtube.com", "sleeping");
        instructor.setInstructorDetail(instructorDetail);

        Course course = new Course("Sleeper Course - The Ultimate Guide");
        Course course2 = new Course("Laziness Course - The Ultimate Guide");
        instructor.add(course);
        instructor.add(course2);

        System.out.println("Saving instructor " + instructor);
        System.out.println("The course: " + instructor.getCourseList());

        appDAO.save(instructor);

        System.out.println("Done!");

    }

    private void deleteInstructorDetail(AppDAO appDAO) {

        //id depending on the DB
        int id = 8;
        System.out.println("Delete instructor detail  id " + id);

        appDAO.deleteInstructorDetailById(id);
        System.out.println("Done!");


    }

    private void findInstructorDetailById(AppDAO appDAO) {

        int id = 2;
        System.out.println("Finding instructor by id: " + id);


        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
        System.out.println("instructorDetail: " + instructorDetail);


    }

    private void deleteInstructorById(AppDAO appDAO) {

        appDAO.deleteInstructorById(1);
        System.out.println("Done!");

    }

    private void findInstructorById(AppDAO appDao) {

        Instructor instructor = appDao.findInstructorById(1);
        System.out.println(instructor);


    }

    private void createInstructor(AppDAO appDAO) {
        Instructor instructor = new Instructor("Borislav", "Karchev", "bkarchev@code.com");

        InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com", "read");
        instructor.setInstructorDetail(instructorDetail);
        System.out.println("Saved instructor: " + instructor);
        appDAO.save(instructor);

        System.out.println("Done!");
    }

    private void updateCourse(AppDAO appDAO) {
        int id = 10;

        Course course = appDAO.findCourseById(id);
        System.out.println("Course name:" + course.getTitle());

        course.setTitle("TESTER");

        System.out.println("Course new  title: " + course.getTitle());
        appDAO.updateCourse(course);
        System.out.println("Done");


    }

}
