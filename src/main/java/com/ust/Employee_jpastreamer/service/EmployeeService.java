package com.ust.Employee_jpastreamer.service;



import com.speedment.jpastreamer.application.JPAStreamer;
import com.ust.Employee_jpastreamer.model.Employee;
import com.ust.Employee_jpastreamer.repository.Employeerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private Employeerepo employeeRepository;

    private final JPAStreamer jpaStreamer;

    @Autowired
    public EmployeeService(final JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }


    public Map<String, List<Employee>> groupbyEmployeeByCity() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getCity));
    }

    public List<Employee> groupbyEmployeeByPaymentTier() {
        return employeeRepository.findAll() ;
    }

    public List<Employee> saveEmployee(List<Employee> employee) {
        return employeeRepository.saveAll(employee);
    }

    public List<Employee> findEmployeesByAgeRange(int minAge, int maxAge) {
        return jpaStreamer.stream(Employee.class)
                .filter(e -> e.getAge() >= minAge && e.getAge() <= maxAge)
                .collect(Collectors.toList());
    }
    public long countEmployeesByGender(String gender) {
        return jpaStreamer.stream(Employee.class)
                .filter(e -> gender.equalsIgnoreCase(e.getGender()))
                .count();
    }
    public List<Employee> findEmployeesByJoiningYear(int joiningYear) {
        return jpaStreamer.stream(Employee.class)
                .filter(e -> e.getJoiningYear() == joiningYear)
                .collect(Collectors.toList());
    }
}
