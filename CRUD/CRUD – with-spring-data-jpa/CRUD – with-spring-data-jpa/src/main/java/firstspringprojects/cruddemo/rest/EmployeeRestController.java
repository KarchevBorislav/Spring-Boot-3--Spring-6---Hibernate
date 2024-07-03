package firstspringprojects.cruddemo.rest;


import firstspringprojects.cruddemo.entity.Employee;

import firstspringprojects.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {

        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee id not found un the database" + employeeId);
        }
        return employee;
    }

    @PostMapping("employees")
    public Employee addEmployee(@RequestBody Employee employee ) {
        employee.setId(0);


        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        return employeeService.save(employee);
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee byId = employeeService.findById(employeeId);
        if (byId == null) {
            throw new RuntimeException("Employee id not found un the database" + employeeId);
        }
        employeeService.deleteById(employeeId);
        return  "Employee with id " + employeeId + " deleted";
    }
}
