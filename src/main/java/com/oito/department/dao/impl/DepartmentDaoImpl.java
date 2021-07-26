package com.oito.department.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oito.department.dao.DepartmentDao;
import com.oito.department.dao.repository.DepartmentRepository;
import com.oito.department.mapper.DepartmentMapper;
import com.oito.department.vo.DepartmentVO;
import com.oito.employee.dao.entity.Employee;
import com.oito.exception.ApiException;
import com.oito.exception.ErrorCode;

@Component
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired
	DepartmentMapper mapper;
	@Autowired
	DepartmentRepository repository;

	@Override
	public DepartmentVO save(final DepartmentVO vo) {
		final var entity = mapper.toEntity(vo);
		final var savedDepartment = repository.save(entity);
		return mapper.toVO(savedDepartment);
	}

	@Override
	public DepartmentVO update(final DepartmentVO vo) {
		final var department = repository.findById(vo.getId())
				.orElseThrow(() -> new ApiException(ErrorCode.ID_NOT_FOUND));
		mapper.toEntity(vo, department);
		final var updateddepat = repository.save(department);

		return mapper.toVO(updateddepat);
	}

	@Override
	public DepartmentVO getByID(final Long id) {
		final var department = repository.findById(id).orElseThrow(() -> new ApiException(ErrorCode.ID_NOT_FOUND));
		for (final Employee e : department.getEmployeeList()) {
			e.setDepartment(null);
		}
		return mapper.toVO(department);

	}

	@Override
	public DepartmentVO delete(final Long id) {
		final var entity = repository.findById(id).orElseThrow(() -> new ApiException(ErrorCode.ID_NOT_FOUND));
		repository.deleteById(id);
		return mapper.toVO(entity);
	}

}
