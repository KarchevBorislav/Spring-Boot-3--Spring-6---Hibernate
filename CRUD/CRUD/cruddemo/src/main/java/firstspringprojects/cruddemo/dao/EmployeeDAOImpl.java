package firstspringprojects.cruddemo.dao;

import firstspringprojects.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {


        TypedQuery<Employee> queryEmployee = entityManager.createQuery("FROM Employee ", Employee.class);


        return queryEmployee.getResultList();
    }

    @Override
    public Employee findById(int id) {

        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {

        return entityManager.merge(employee);
    }

    @Override
    public int deleteById(int id) {
        entityManager.remove(entityManager.find(Employee.class, id));
        return id;
    }
}
