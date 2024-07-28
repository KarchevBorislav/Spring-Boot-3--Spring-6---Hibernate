package firstspringprojects.springboot.cruddemoonetoonemapping.dao;


import firstspringprojects.springboot.cruddemoonetoonemapping.entity.Course;

import java.util.List;

public interface AppDAO {

    void save(Course course);

    Course findCourseAndReviewsById(int id);

    void  deleteCourseAndReviewsById(int id);

}
