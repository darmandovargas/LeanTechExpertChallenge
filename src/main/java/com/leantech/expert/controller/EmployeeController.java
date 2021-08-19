package com.leantech.expert.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.leantech.expert.exception.ResourceNotFoundException;
import com.leantech.expert.model.Employee;
import com.leantech.expert.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/employee")
@Api(value="TCloudG Expert REST API for LeanTech")
public class EmployeeController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5508139036023895676L;
	
	@Autowired
	private EmployeeService employeeService;
	
	@ApiOperation(value="Save or Update an Employee", response = List.class)
	@ApiResponses(value= {@ApiResponse(code=200, message="Successfully saved/update")})
	@PostMapping("")
	public ResponseEntity<Employee> create(@RequestBody Employee employee){
		return ResponseEntity.ok(employeeService.createUpdate(employee));
	}
	
	@ApiOperation(value="Delete an employee", response = List.class)
	@ApiResponses(value= {@ApiResponse(code=200, message="Successfully deleted")})
	@PostMapping("/{id}")
	public void delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		employeeService.delete(id);
	}
	
	@ApiOperation(value="List employees by name or position", response = List.class)
	@ApiResponses(value= {@ApiResponse(code=200, message="Successfully listed")})
	@GetMapping(value = "/{name}/{position}")
	public List<Employee> findByNameOrPosition(@PathVariable(required=false) String name, @PathVariable(required=false) String position) throws ResourceNotFoundException{
		return employeeService.findByCandidateNameOrPositionName(name, position);
		
	}
	
	@ApiOperation(value="List employees", response = List.class)
	@ApiResponses(value= {@ApiResponse(code=200, message="Successfully listed")})
	@GetMapping(value = "")
	public List<Employee> findAll() throws ResourceNotFoundException{
		return employeeService.findAll();		
	}		
}
