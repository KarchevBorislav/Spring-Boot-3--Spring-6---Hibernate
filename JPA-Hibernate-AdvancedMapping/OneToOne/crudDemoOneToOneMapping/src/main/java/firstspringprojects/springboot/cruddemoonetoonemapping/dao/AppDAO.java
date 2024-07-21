package firstspringprojects.springboot.cruddemoonetoonemapping.dao;

import firstspringprojects.springboot.cruddemoonetoonemapping.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
