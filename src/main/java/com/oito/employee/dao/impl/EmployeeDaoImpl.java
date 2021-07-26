package com.oito.employee.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oito.aop.annotation.TrackExecutionTime;
import com.oito.employee.dao.EmployeeDao;
import com.oito.employee.dao.entity.Employee;
import com.oito.employee.dao.repository.EmployeeRepository;
import com.oito.employee.mapper.EmployeeMapper;
import com.oito.employee.vo.EmployeeVO;
import com.oito.exception.ApiException;
import com.oito.exception.ErrorCode;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRepository repository;
	@Autowired
	private EmployeeMapper mapper;

	@Override
	public EmployeeVO save(final EmployeeVO employeeVO) {

		final var employee = mapper.toEntity(employeeVO);
		final var savedEmployee = repository.save(employee);
		return mapper.toVO(savedEmployee);

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public EmployeeVO update(final EmployeeVO employeeVO) {
		final var employee = repository.findById(employeeVO.getId())
				.orElseThrow(() -> new ApiException(ErrorCode.ID_NOT_FOUND));
		mapper.toEntity(employeeVO, employee);
		final var updatedEmployee = repository.save(employee);
		return mapper.toVO(updatedEmployee);
	}

	@Override
	public EmployeeVO delete(final Long id) {
		final var employee = repository.findById(id).orElseThrow(() -> new ApiException(ErrorCode.ID_NOT_FOUND));
		repository.deleteById(id);
		return mapper.toVO(employee);

	}

	@Override
	public EmployeeVO getById(final Long id) {
		final var employee = repository.findById(id).orElseThrow(() -> new ApiException(ErrorCode.ID_NOT_FOUND));
		employee.getDepartment().setEmployeeList(null);
		return mapper.toVO(employee);
	}

	@Override
	public List<EmployeeVO> getByLastName(final String name) {
		final List<Employee> employee = repository.findByLastName(name);

		if (employee.isEmpty()) {
			throw new ApiException(ErrorCode.NAME_NOT_FOUND);
		}
		return mapper.toVOList(employee);

	}

	@TrackExecutionTime
	@Override
	public List<EmployeeVO> findAll() {
		final List<Employee> entityList = repository.findAll();
		if (entityList.isEmpty()) {
			throw new ApiException(ErrorCode.NO_DATA_FOUND);
		}
		for (final Employee e : entityList) {
			e.getDepartment().setEmployeeList(null);
		}
		return mapper.toVOList(entityList);

	}

}
