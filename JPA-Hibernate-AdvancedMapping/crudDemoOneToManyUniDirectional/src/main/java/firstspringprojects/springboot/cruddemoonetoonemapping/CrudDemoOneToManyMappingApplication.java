package firstspringprojects.springboot.cruddemoonetoonemapping;

import firstspringprojects.springboot.cruddemoonetoonemapping.dao.AppDAO;

import firstspringprojects.springboot.cruddemoonetoonemapping.entity.Course;
import firstspringprojects.springboot.cruddemoonetoonemapping.entity.Review;
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

            //createCourseAndReviews(appDAO);

           // retrieveCourseAndReviews(appDAO);

            deleteCourseAndReviews(appDAO);

        };
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {

        int id = 10;

        System.out.println("Deleting course id: " + id);

        appDAO.deleteCourseAndReviewsById(id);
        System.out.println("Done!");


    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {
        int id = 10;
        Course course = appDAO.findCourseAndReviewsById(id);

        System.out.println(course);

        System.out.println(course.getReviews());

        System.out.println("Done!");


    }

    private void createCourseAndReviews(AppDAO appDAO) {

        Course course = new Course("First steps in Spring");
        course.addReview(new Review("Great course... Starting to get it!"));
        course.addReview(new Review("Bit of boring  course... "));
        course.addReview(new Review("The course is okay!"));

        System.out.println("Saving the course");
        System.out.println(course);
        System.out.println(course.getReviews());
        appDAO.save(course);

    }


}
