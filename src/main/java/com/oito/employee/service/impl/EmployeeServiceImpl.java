package com.oito.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oito.department.service.DepartmentService;
import com.oito.department.vo.DepartmentVO;
import com.oito.employee.dao.EmployeeDao;
import com.oito.employee.service.EmployeeService;
import com.oito.employee.vo.EmployeeVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;
	@Autowired
	private DepartmentService service;
//	@Autowired
//	private AddressProxy proxy;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public EmployeeVO saveEmployee(final EmployeeVO employeeVO) {

		final EmployeeVO vo = dao.save(employeeVO);
		final var deptVo = new DepartmentVO();
		deptVo.setName("QA");
		service.saveDepartment(deptVo);
		return vo;
	}

	@Override
	public EmployeeVO updateEmployee(final EmployeeVO employeeVO) {
		return dao.update(employeeVO);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public EmployeeVO deleteEmployee(final Long id) {
		final EmployeeVO vo = dao.delete(id);
		service.deleteDepartment((long) 2);

		return vo;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED, rollbackFor = Exception.class)
	@Override
	public EmployeeVO getById(final Long id) {
		final EmployeeVO employeeVO = dao.getById(id);
		log.info("Transaction1.  Salary: " + employeeVO.getSalary());

		employeeVO.setSalary(employeeVO.getSalary() + 20);
		final EmployeeVO updatedEmployee = dao.update(employeeVO);
		log.info("Transaction2.Salary: " + updatedEmployee.getSalary());

		final EmployeeVO oldEmployee = dao.getById(id);
		log.info("Transaction1.Salary: " + oldEmployee.getSalary());
		oldEmployee.setSalary(oldEmployee.getSalary() + 30);
		final EmployeeVO updatedEmployee2 = dao.update(oldEmployee);
		// log.info("" + 10 / 0);
		log.info("Transaction2.1.Salary: " + updatedEmployee2.getSalary());
		final EmployeeVO oldEmployee2 = dao.getById(id);
		log.info("Transaction1.1.Salary: " + oldEmployee2.getSalary());

		return employeeVO;// dao.getById(id);
	}

	@Override
	public List<EmployeeVO> getEmployeeByLastName(final String name) {

		return dao.getByLastName(name);
	}

	// throws exception when an active transaction exists
	@Transactional(propagation = Propagation.NEVER, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	@Override
	public List<EmployeeVO> findAll() {

		return dao.findAll();
	}

	@Override
	public String getAddress(final int id) {

		return null;// proxy.getAddressByEmpId(id);
	}

}
