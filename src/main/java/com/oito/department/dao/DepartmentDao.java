package com.oito.department.dao;

import com.oito.department.vo.DepartmentVO;

public interface DepartmentDao {
	DepartmentVO save(DepartmentVO vo);

	DepartmentVO update(DepartmentVO vo);

	DepartmentVO getByID(Long id);

	DepartmentVO delete(Long id);

}
