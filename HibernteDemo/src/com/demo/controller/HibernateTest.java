package com.demo.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.demo.dao.EmployeeDaoImpl;
import com.demo.entity.Employee;

public class HibernateTest {
	static EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

	EntityManager entityManager;

	public static void main(final String[] args) {

		final Employee employee = new Employee();
		employee.setFirstName("aashish");
		employee.setLastName("chauhan");
		employee.setGender("male");
		employee.setDob("03 September 1992");

		HibernateTest.employeeDao.addEmployee(employee);

		employee.setFirstName("karan");
		HibernateTest.employeeDao.updateEmployee(employee);

		final Employee employee2 = HibernateTest.employeeDao.getEmployeeById(employee.getEmpId());
		System.out.println(employee2);

		final List<Employee> employees = HibernateTest.employeeDao.getAllEmployees();

		employees.forEach(System.out::println);

		HibernateTest.employeeDao.deleteEmployeeById(employee.getEmpId());

	}
}
