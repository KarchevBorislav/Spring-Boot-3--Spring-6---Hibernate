package firstspringprojects.hibernatedemo.dao;

import firstspringprojects.hibernatedemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);

    }

    @Override
    public Student findById(Integer id) {
        Student student = entityManager.find(Student.class, id);
        return student;
    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student  order by lastName DESC ", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName = :theLastName", Student.class);
        query.setParameter("theLastName", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);

    }

    @Override
    @Transactional
    public void delete(Student student) {

        Query deleteQuery = entityManager.createQuery("""
DELETE FROM Student WHERE lastName=:theLastName""");
        deleteQuery.setParameter("theLastName", "Doe");
        deleteQuery.executeUpdate();

    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        entityManager.remove(findById(id));

    }

    @Override
    @Transactional
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }

    @Override
    @Transactional
    public int deleteAllStudents() {
        int countRowsDeleted = entityManager.createQuery("Delete FROM Student").executeUpdate();

        return countRowsDeleted;
    }
}
