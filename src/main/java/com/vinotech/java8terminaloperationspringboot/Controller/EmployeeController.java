package com.vinotech.java8terminaloperationspringboot.Controller;


import com.vinotech.java8terminaloperationspringboot.Model.Employee;
import com.vinotech.java8terminaloperationspringboot.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Endpoint to demonstrate forEach terminal operation
    @GetMapping("/forEach")
    public ResponseEntity<List<Employee>> forEachExample() {
        List<Employee> employees = employeeService.forEachExample();
        return ResponseEntity.ok(employees);
    }

    // Endpoint to demonstrate collect terminal operation
    @GetMapping("/collect")
    public ResponseEntity<List<Employee>> collectExample() {
        List<Employee> employees = employeeService.collectExample();
        return ResponseEntity.ok(employees);
    }

    // Endpoint to demonstrate reduce terminal operation
    @GetMapping("/reduce")
    public ResponseEntity<Double> reduceExample() {
        double totalSalary = employeeService.reduceExample();
        return ResponseEntity.ok(totalSalary);
    }

    // Endpoint to demonstrate count terminal operation
    @GetMapping("/count")
    public ResponseEntity<Long> countExample() {
        long count = employeeService.countExample();
        return ResponseEntity.ok(count);
    }

    // Endpoint to demonstrate anyMatch terminal operation
    @GetMapping("/anyMatch")
    public ResponseEntity<Boolean> anyMatchExample() {
        boolean anyMatch = employeeService.anyMatchExample();
        return ResponseEntity.ok(anyMatch);
    }

    // Endpoint to demonstrate allMatch terminal operation
    @GetMapping("/allMatch")
    public ResponseEntity<Boolean> allMatchExample() {
        boolean allMatch = employeeService.allMatchExample();
        return ResponseEntity.ok(allMatch);
    }

    // Endpoint to demonstrate noneMatch terminal operation
    @GetMapping("/noneMatch")
    public ResponseEntity<Boolean> noneMatchExample() {
        boolean noneMatch = employeeService.noneMatchExample();
        return ResponseEntity.ok(noneMatch);
    }

    // Endpoint to demonstrate findFirst terminal operation
    @GetMapping("/findFirst")
    public ResponseEntity<Employee> findFirstExample() {
        Optional<Employee> employee = employeeService.findFirstExample();
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to demonstrate findAny terminal operation
    @GetMapping("/findAny")
    public ResponseEntity<Employee> findAnyExample() {
        Optional<Employee> employee = employeeService.findAnyExample();
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to demonstrate min terminal operation
    @GetMapping("/min")
    public ResponseEntity<Employee> minExample() {
        Optional<Employee> minSalaryEmployee = employeeService.minExample();
        return minSalaryEmployee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to demonstrate max terminal operation
    @GetMapping("/max")
    public ResponseEntity<Employee> maxExample() {
        Optional<Employee> maxSalaryEmployee = employeeService.maxExample();
        return maxSalaryEmployee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}