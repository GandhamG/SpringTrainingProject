package com.oito.employee.dao;

import java.util.List;

import com.oito.employee.vo.EmployeeVO;

public interface EmployeeDao {

	EmployeeVO save(EmployeeVO employeeVO);

	EmployeeVO update(EmployeeVO employeeVO);

	EmployeeVO delete(Long id);

	EmployeeVO getById(Long id);

	List<EmployeeVO> getByLastName(String name);

	List<EmployeeVO> findAll();

}
