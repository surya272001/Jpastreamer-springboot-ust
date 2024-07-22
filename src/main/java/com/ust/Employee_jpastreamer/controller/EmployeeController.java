package com.ust.Employee_jpastreamer.controller;

import com.ust.Employee_jpastreamer.model.Employee;
import com.ust.Employee_jpastreamer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/save")
    public List<Employee> saveEmployee(@RequestBody List<Employee> employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/groupByCity")
    public Map<String, List<Employee>> groupbyEmployeeByCity(){
        return employeeService.groupbyEmployeeByCity();
    }
    @GetMapping("/findall")
    public List<Employee> groupbyEmployeeByPaymentTier(){
        return employeeService.groupbyEmployeeByPaymentTier();
    }

    @GetMapping("/findByAgeRange")
    public List<Employee> findByAgeRange(@RequestParam("minAge") int minAge, @RequestParam("maxAge") int maxAge) {
        return employeeService.findEmployeesByAgeRange(minAge, maxAge);
    }
    @GetMapping("/count-male-employees")
    public long countMaleEmployees() {
        return employeeService.countEmployeesByGender("Male");
    }

    @GetMapping("/count-female-employees")
    public long countFemaleEmployees() {
        return employeeService.countEmployeesByGender("Female");
    }
    @GetMapping("/find-by-joining-year")
    public List<Employee> findByJoiningYear(@RequestParam("joiningYear") int joiningYear) {
        return employeeService.findEmployeesByJoiningYear(joiningYear);
    }
}
