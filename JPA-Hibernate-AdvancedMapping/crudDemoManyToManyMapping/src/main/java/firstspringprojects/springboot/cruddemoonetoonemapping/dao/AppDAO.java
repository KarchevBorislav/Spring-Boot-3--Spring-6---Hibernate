package firstspringprojects.springboot.cruddemoonetoonemapping.dao;


import firstspringprojects.springboot.cruddemoonetoonemapping.entity.Course;
import firstspringprojects.springboot.cruddemoonetoonemapping.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Course course);

    Course findCourseAndReviewsById(int id);

    void deleteCourseAndReviewsById(int id);

    Course findCourseAndStudentsByCourseId(int id);

    Student findStudentAndCoursesByStudentId(int id);

    void update(Student student);

    void deleteCourseById(int id);

    void deleteStudentById(int id);


}
