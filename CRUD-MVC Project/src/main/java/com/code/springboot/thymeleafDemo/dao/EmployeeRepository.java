package com.code.springboot.thymeleafDemo.dao;

import com.code.springboot.thymeleafDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {



    List<Employee> findAllByOrderByLastName();

}
