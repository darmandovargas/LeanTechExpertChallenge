package com.leantech.expert.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.leantech.expert.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	List<Employee> findByPersonName(String name);
	List<Employee> findByPositionName(String position);
	List<Employee> findByPersonNameOrPositionName(String name, String position);
	
}
