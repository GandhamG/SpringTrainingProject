package com.oito.employee.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.oito.department.mapper.DepartmentMapper;
import com.oito.employee.dao.entity.Employee;
import com.oito.employee.vo.EmployeeVO;

@Mapper(componentModel = "spring", uses = DepartmentMapper.class)
@Component
public interface EmployeeMapper {

	Employee toEntity(EmployeeVO vo);

	// @Mapping(target = "department", ignore = true)// it will ignore total
	// department values
	EmployeeVO toVO(Employee employee);

	List<Employee> toEntiryList(List<EmployeeVO> employeeVOList);

	List<EmployeeVO> toVOList(List<Employee> employeeList);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void toEntity(EmployeeVO employeeVO, @MappingTarget Employee employee);

}
