package com.demo.dao;

import java.util.List;

import com.demo.entity.Employee;

public interface EmployeeDao {

	void addEmployee(Employee employee);

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployees();

	void updateEmployee(Employee employee);

	void deleteEmployeeById(int id);
}
