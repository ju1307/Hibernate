package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public Employee findByEmpNameAndEmpId(String name, Long id);

}
