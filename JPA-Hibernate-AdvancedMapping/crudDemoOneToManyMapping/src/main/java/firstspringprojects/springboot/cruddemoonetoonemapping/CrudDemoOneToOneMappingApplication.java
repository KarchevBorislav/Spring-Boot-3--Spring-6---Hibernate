package firstspringprojects.springboot.cruddemoonetoonemapping;

import firstspringprojects.springboot.cruddemoonetoonemapping.dao.AppDAO;
import firstspringprojects.springboot.cruddemoonetoonemapping.entity.Course;
import firstspringprojects.springboot.cruddemoonetoonemapping.entity.Instructor;
import firstspringprojects.springboot.cruddemoonetoonemapping.entity.InstructorDetail;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoOneToOneMappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoOneToOneMappingApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {
            // createInstructor(appDAO);

            // findInstructor(appDAO);

            // deleteInstructor(appDAO);

            // findInstructorDetail(appDAO);

            // deleteInstructorDetail(appDAO);

            //createInstructorWithCourses(appDAO);

        };
    }

    private void createInstructorWithCourses(AppDAO appDAO) {

        // create the instructor
        Instructor tempInstructor =
                new Instructor("Susan", "Public", "susan.public@code.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://www.youtube.com",
                        "Video Games");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // create some courses
        Course course1 = new Course("The Pinball Masterclass");
        Course course2 = new Course("Air Guitar - The Ultimate Guide");

        // add courses to instructor
        tempInstructor.add(course2);
        tempInstructor.add(course1);


        System.out.println("Saving instructor: " + tempInstructor);
        System.out.println("The courses: " + tempInstructor.getCourses());
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

    private void deleteInstructorDetail(AppDAO appDAO) {

        int theId = 3;
        System.out.println("Deleting instructor detail id: " + theId);

        appDAO.deleteInstructorDetailById(theId);

        System.out.println("Done!");
    }

    private void findInstructorDetail(AppDAO appDAO) {

        // get the instructor detail object
        int theId = 2;
        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

        // print the instructor detail
        System.out.println("tempInstructorDetail: " + tempInstructorDetail);

        // print the associated instructor
        System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

        System.out.println("Done!");
    }

    private void deleteInstructor(AppDAO appDAO) {

        int theId = 1;
        System.out.println("Deleting instructor id: " + theId);

        appDAO.deleteInstructorById(theId);

        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {

        int theId = 2;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());

    }

    private void createInstructor(AppDAO appDAO) {



        // create the instructor
        Instructor tempInstructor =
                new Instructor("Madhu", "Patel", "madhu@code.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://www.youtube.com",
                        "Guitar");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);


        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }
}