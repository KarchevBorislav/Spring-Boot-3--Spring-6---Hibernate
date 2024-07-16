package com.code.springboot.thymeleafDemo.controller;

import com.code.springboot.thymeleafDemo.entity.Employee;
import com.code.springboot.thymeleafDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/employees")
public class EmployeesController {


    private EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {

        List<Employee> employees = employeeService.findAll();

        model.addAttribute("employees", employees);

        return "employees/list-employees";


    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(Model model, @RequestParam("employeeId") int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees/list";
    }
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int employeeId) {
        employeeService.deleteById(employeeId);
        return "redirect:/employees/list";
    }


}
