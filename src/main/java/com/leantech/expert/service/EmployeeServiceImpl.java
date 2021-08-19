package com.leantech.expert.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.leantech.expert.exception.ResourceNotFoundException;
import com.leantech.expert.model.Employee;
import com.leantech.expert.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Override
	public Employee createUpdate(Employee employee) throws ResponseStatusException {
		employeeRepo.save(employee);
		return null;
	}

	@Override
	public void delete(Long id) throws ResourceNotFoundException {
		Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		employeeRepo.delete(employee);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	public List<Employee> findByName(String name) {
		return employeeRepo.findByPersonName(name);
	}
	
	@Override
	public List<Employee> findByPosition(String position) {
		return employeeRepo.findByPositionName(position);
	}
	
	@Override
	public List<Employee> findByCandidateNameOrPositionName(String name, String position) {
		return employeeRepo.findByPersonNameOrPositionName(name, position);
	}
}
