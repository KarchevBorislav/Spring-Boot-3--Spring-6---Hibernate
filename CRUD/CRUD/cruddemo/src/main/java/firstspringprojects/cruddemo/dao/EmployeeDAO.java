package firstspringprojects.cruddemo.dao;

import firstspringprojects.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    int deleteById(int id);
}
