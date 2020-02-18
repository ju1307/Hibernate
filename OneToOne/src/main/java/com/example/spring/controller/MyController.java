package com.example.spring.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.entity.Address;
import com.example.spring.entity.Student;
import com.example.spring.repository.AddressRepository;
import com.example.spring.repository.StudentRepository;

@RestController
@Transactional
public class MyController {

	@Autowired
	private StudentRepository studentRepository;

	@Resource
	private AddressRepository addressRepository;

	// http://localhost:7080/addstudent
	@PostMapping(path = "/addstudent", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addStudent(@RequestBody final Student student) {
		// check if address id is present
		if (student.getAddress().getId() != null) {
			// check if given address id is already mapped
			// as it is one-to-one mapping cannot be mapped with multiple students
			if (getAllStudents().stream().anyMatch(p -> p.getAddress().getId().equals(student.getAddress().getId()))) {
				return "given address is already mapped with student in student_table";
			}
			// set address reference to student
			student.setAddress(getAddressById(student.getAddress().getId()));
		}
		this.studentRepository.save(student);
		return "student added successfully..";
	}

	// http://localhost:7080/deletestudent/11
	@DeleteMapping(path = "/deletestudent/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteStudent(@PathVariable final Long id) {
		this.studentRepository.deleteById(id);
	}

	// http://localhost:7080/
	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getAllStudents() {
		return this.studentRepository.findAll();
	}

	// http://localhost:7080/11
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudentById(@PathVariable final Long id) {
		final Optional<Student> optional = this.studentRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	// @RequestParam example
	// http://localhost:7080/deletestudent?id=8
	@DeleteMapping(path = "/deletestudent", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteStudentRequestParam(@RequestParam final Long id) {
		this.studentRepository.deleteById(id);
	}

	// http://localhost:7080/addaddress
	@PostMapping(path = "/addaddress", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Address addAddress(@RequestBody final Address address) {
		return this.addressRepository.save(address);
	}

	// http://localhost:7080/deleteaddress/11
	@DeleteMapping(path = "/deleteaddress/{id}")
	public String deleteAddress(@PathVariable final Long id) {
		// check if address id is already present in student or not
		final Student student = this.studentRepository.getdata(id);
		if (student == null) {
			// if not present then delete address
			this.addressRepository.deleteById(id);
			return "address deleted successfully";
		}
		return "address mapping present in parent entity student";
	}

	// http://localhost:7080/address
	@GetMapping(path = "/address", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Address> getAllAddress() {
		return this.addressRepository.findAll();
	}

	// http://localhost:7080/address/11
	@GetMapping(path = "/address/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Address getAddressById(@PathVariable final Long id) {
		final Optional<Address> optional = this.addressRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

}
