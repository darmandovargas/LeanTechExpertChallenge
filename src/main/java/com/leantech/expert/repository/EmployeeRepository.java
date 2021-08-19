package com.leantech.expert.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.leantech.expert.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	@EntityGraph(value = "EMPLOYEE.CANDIDATE", type = EntityGraphType.LOAD)
	List<Employee> findByPersonName(String name);
	
	@EntityGraph(value = "EMPLOYEE.POSITION", type = EntityGraphType.LOAD)
	List<Employee> findByPositionName(String position);
	
	List<Employee> findByPersonNameOrPositionName(String name, String position);
	
}
