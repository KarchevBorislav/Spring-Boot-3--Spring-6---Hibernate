package firstspringprojects.springboot.cruddemoonetoonemapping.dao;

import firstspringprojects.springboot.cruddemoonetoonemapping.entity.Course;
import firstspringprojects.springboot.cruddemoonetoonemapping.entity.Instructor;
import firstspringprojects.springboot.cruddemoonetoonemapping.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


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
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course  where instructor.id = :data", Course.class
        );

        query.setParameter("data", id);
        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {

        TypedQuery<Instructor> query = entityManager.createQuery("""
                select i from Instructor i JOIN fetch  i.courseList 
                where i.id = :data
                """, Instructor.class);
        query.setParameter("data", id);

        return query.getSingleResult();
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


    //method is updated to delete the instructor but to leave his Courses
    @Override
    @Transactional
    public void deleteInstructorById(int id) {

        Instructor instructor = entityManager.find(Instructor.class, id);

        List<Course> courses = instructor.getCourseList();

        courses.forEach(course -> course.setInstructor(null));

        entityManager.remove(instructor);
    }


    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {

        entityManager.merge(instructor);

    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {

        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);

    }
}
