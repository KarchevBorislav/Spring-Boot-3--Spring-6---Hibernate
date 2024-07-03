package firstspringprojects.hibernatedemo.dao;

import firstspringprojects.hibernatedemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);


    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(Student student);

    void deleteById(Integer id);

    void deleteAll();
    int deleteAllStudents();


}

