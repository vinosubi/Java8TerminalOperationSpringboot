package com.vinotech.java8terminaloperationspringboot.Service;

import com.vinotech.java8terminaloperationspringboot.Model.Employee;
import com.vinotech.java8terminaloperationspringboot.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> forEachExample() {
        List<Employee> employees = repository.findAll();
        employees.forEach(System.out::println);  // Log each employee to the console
        return employees;
    }

    public List<Employee> collectExample() {
        return repository.findAll().stream().collect(Collectors.toList());
    }

    public double reduceExample() {
        return repository.findAll().stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
    }

    public long countExample() {
        return repository.findAll().stream().count();
    }

    public boolean anyMatchExample() {
        return repository.findAll().stream().anyMatch(e -> e.getDepartment().equals("HR"));
    }

    public boolean allMatchExample() {
        return repository.findAll().stream().allMatch(e -> e.getSalary() > 3000);
    }

    public boolean noneMatchExample() {
        return repository.findAll().stream().noneMatch(e -> e.getSalary() < 3000);
    }

    public Optional<Employee> findFirstExample() {
        return repository.findAll().stream()
                .findFirst(); // Retrieves the first employee if available
    }

    public Optional<Employee> findAnyExample() {
        return repository.findAll().stream().findAny();
    }

    public Optional<Employee> minExample() {
        return repository.findAll().stream()
                .min(Comparator.comparingDouble(Employee::getSalary)); // Assuming there's a getSalary method
    }

    public Optional<Employee> maxExample() {
        return repository.findAll().stream()
                .max(Comparator.comparingDouble(Employee::getSalary)); // Assuming there's a getSalary method
    }
}
