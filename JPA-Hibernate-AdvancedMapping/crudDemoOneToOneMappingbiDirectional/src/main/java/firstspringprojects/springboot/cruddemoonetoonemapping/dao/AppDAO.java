package firstspringprojects.springboot.cruddemoonetoonemapping.dao;

import firstspringprojects.springboot.cruddemoonetoonemapping.entity.Instructor;
import firstspringprojects.springboot.cruddemoonetoonemapping.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);



    //Bidirectional OneToOne

    void deleteInstructorDetailById(int id);
}
