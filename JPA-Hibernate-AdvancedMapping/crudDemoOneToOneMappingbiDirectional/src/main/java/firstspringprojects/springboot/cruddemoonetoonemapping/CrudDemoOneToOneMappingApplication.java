package firstspringprojects.springboot.cruddemoonetoonemapping;

import firstspringprojects.springboot.cruddemoonetoonemapping.dao.AppDAO;
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

            //OneToOne methods without biDirection
            // createInstructor(appDAO);
            // findInstructorById(appDAO);
            // deleteInstructorById(appDAO);
            // findInstructorDetailById(appDAO);


            //Bidirectional OneToOne methods:
         deleteInstructorDetail(appDAO);
        };
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

}
