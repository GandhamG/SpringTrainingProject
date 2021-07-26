package com.oito.department.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.oito.department.dao.entity.Department;
import com.oito.department.vo.DepartmentVO;
import com.oito.employee.mapper.EmployeeMapper;

@Mapper(componentModel = "spring", uses = EmployeeMapper.class)
@Component
public interface DepartmentMapper {

	Department toEntity(DepartmentVO vo);

	// @Mapping(target = "employee", ignore = true)
	DepartmentVO toVO(Department department);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void toEntity(DepartmentVO vo, @MappingTarget Department department);
}
