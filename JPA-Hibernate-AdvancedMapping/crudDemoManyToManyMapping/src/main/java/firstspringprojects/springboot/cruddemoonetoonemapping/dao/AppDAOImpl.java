package firstspringprojects.springboot.cruddemoonetoonemapping.dao;

import firstspringprojects.springboot.cruddemoonetoonemapping.entity.Course;
import firstspringprojects.springboot.cruddemoonetoonemapping.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AppDAOImpl implements AppDAO {
    private final EntityManager entityManager;


    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
         Student student = entityManager.find(Student.class,id);
         entityManager.remove(student);


    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {

        Course course = entityManager.find(Course.class, id);


        entityManager.remove(course);

    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);


    }

    @Override
    public Student findStudentAndCoursesByStudentId(int id) {
        TypedQuery<Student> query = entityManager.createQuery("""
                                select s from Student s
                                JOIN FETCH s.courses
                where s.id = :data
                """, Student.class);

        query.setParameter("data", id);
        return query.getSingleResult();

    }

    @Override
    public Course findCourseAndStudentsByCourseId(int id) {

        TypedQuery<Course> query = entityManager.createQuery("""
                                select c from Course c 
                                JOIN FETCH c.students
                where c.id = :data
                     """, Course.class);

        query.setParameter("data", id);


        return query.getSingleResult();
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
