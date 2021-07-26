package com.oito.employee.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oito.employee.dao.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// @Query("select u from Employee u where u.firstName= ?1")
	List<Employee> findByLastName(String lastName);

}
