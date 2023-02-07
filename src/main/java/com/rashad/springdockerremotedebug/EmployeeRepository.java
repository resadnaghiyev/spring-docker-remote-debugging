package com.rashad.springdockerremotedebug;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class EmployeeRepository {

    public List<Employee> getEmployees() {
        return Stream.of(
                        new Employee(101, "Hasan", "Devops", "hasan@company.com"),
                        new Employee(102, "Rashad", "Developer", "rashad@company.com"),
                        new Employee(103, "Parvin", "Devops", "parvin@company.com"),
                        new Employee(104, "Murad", "Developer", "murad@company.com"),
                        new Employee(105, "Rauf", "Developer", "rauf@company.com"),
                        new Employee(106, "Elvin", "Manager", "elvin@company.com"),
                        new Employee(107, "Orxan", "HR", "orxan@company.com")
                ).collect(Collectors.toList());
    }

    public List<String> getEmailIds(String dept) {
        return getEmployees().stream()
                .filter(employee -> dept.equals(employee.getDept()))
                .map(Employee::getEmail)
                .collect(Collectors.toList());
    }
}
