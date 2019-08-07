package com.helpezee.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpezee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
