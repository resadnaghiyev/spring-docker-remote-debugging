package com.rashad.springdockerremotedebug;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @GetMapping("/{dept}")
    public List<Employee> getEmployees(@PathVariable String dept) {
        return employeeRepository.getEmployees()
                .stream()
                .filter(employee -> dept.equals(employee.getDept()))
                .collect(Collectors.toList());
    }

    @GetMapping("/notify/{dept}")
    public void sendAnnouncementTOEmployees(@PathVariable String dept) {
        List<String> emailIds = employeeRepository.getEmailIds(dept);
        emailIds.forEach(email -> System.out.println("send email to " + email));
    }
}
