package com.oito.department.service;

import com.oito.department.vo.DepartmentVO;

public interface DepartmentService {
	DepartmentVO saveDepartment(DepartmentVO employeeVO);

	DepartmentVO updateDepartment(DepartmentVO employeeVO);

	DepartmentVO deleteDepartment(Long id);

	DepartmentVO getById(Long id);

}
