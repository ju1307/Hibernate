package com.example.spring.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.entity.Employee;
import com.example.spring.repository.EmployeeRepository;

@RestController
@Transactional
public class MyController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping(path = "/addemployee", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Employee addEmployee(@RequestBody final Employee employee) {
		employee.getAddress().forEach(e -> e.setEmployee(employee));
		return employeeRepository.save(employee);
	}

	@GetMapping(path = "employees")
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@DeleteMapping(path = "/deleteemployee/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteEmployee(@PathVariable final Long id) {
		employeeRepository.deleteById(id);
	}

}
