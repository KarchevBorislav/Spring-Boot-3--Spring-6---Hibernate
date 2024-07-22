package firstspringprojects.springboot.cruddemoonetoonemapping.dao;

import firstspringprojects.springboot.cruddemoonetoonemapping.entity.Instructor;
import firstspringprojects.springboot.cruddemoonetoonemapping.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AppDAOImpl implements AppDAO {
    private EntityManager entityManager;



@Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;

    }


    //Bidirectional OneToOne method
    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);

        //remove the associated object reference
        //break bidirectional link
        instructorDetail.getInstructor().setInstructorDetail(null);


        entityManager.remove(instructorDetail);

    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);

    }

    @Override
    public Instructor findInstructorById(int id) {

        return entityManager.find(Instructor.class, id);

    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {

    Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);
    }


    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }
}
