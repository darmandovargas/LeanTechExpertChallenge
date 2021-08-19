package com.leantech.expert.service;

import java.util.List;

import org.springframework.web.server.ResponseStatusException;

import com.leantech.expert.exception.ResourceNotFoundException;
import com.leantech.expert.model.Employee;


public interface EmployeeService {
	Employee createUpdate(Employee employee) throws ResponseStatusException;
	void delete(Long id) throws ResourceNotFoundException;
	List<Employee> findAll();
	List<Employee> findByName(String name);
	List<Employee> findByPosition(String position);
	List<Employee> findByCandidateNameOrPositionName(String name, String position);
}
