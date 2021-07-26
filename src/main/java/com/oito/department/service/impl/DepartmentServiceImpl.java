package com.oito.department.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oito.department.dao.DepartmentDao;
import com.oito.department.service.DepartmentService;
import com.oito.department.vo.DepartmentVO;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao dao;

	// @Transactional(propagation = Propagation.NEVER)
	// suspends active TNS and creates New TNS
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public DepartmentVO saveDepartment(final DepartmentVO vo) {

		return dao.save(vo);
	}

	@Override
	public DepartmentVO updateDepartment(final DepartmentVO vo) {

		return dao.update(vo);
	}

	// checks if an active TNS ,if no executes non-TNly
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
	@Override
	public DepartmentVO deleteDepartment(final Long id) {

		return dao.delete(id);
	}

	// suspends active TNS and then busi logic exe without TNS
	@Transactional(propagation = Propagation.NOT_SUPPORTED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
	@Override
	public DepartmentVO getById(final Long id) {

		return dao.getByID(id);
	}

}
