package com.oito.employee.service;

import java.util.List;

import com.oito.employee.vo.EmployeeVO;

public interface EmployeeService {

	EmployeeVO saveEmployee(EmployeeVO employeeVO);

	EmployeeVO updateEmployee(EmployeeVO employeeVO);

	EmployeeVO deleteEmployee(Long id);

	EmployeeVO getById(Long id);

	List<EmployeeVO> getEmployeeByLastName(String name);

	List<EmployeeVO> findAll();

	String getAddress(int id);

}
