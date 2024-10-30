package com.vinotech.java8terminaloperationspringboot.Repository;

import com.vinotech.java8terminaloperationspringboot.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
