package firstspringprojects.springboot.cruddemoonetoonemapping.dao;

import firstspringprojects.springboot.cruddemoonetoonemapping.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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


    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsById(int id) {
        TypedQuery<Course> query = entityManager.createQuery("""
                                select c from Course c 
                                JOIN FETCH c.reviews
                where c.id = :data
                     """, Course.class);

        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void deleteCourseAndReviewsById(int id) {
        Course course = findCourseAndReviewsById(id);

        entityManager.remove(course);

    }
}
