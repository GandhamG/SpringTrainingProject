package com.oito.employee.vo;

import com.oito.department.vo.DepartmentVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeVO {
	private Long id;
	private String firstName;
	private String lastName;
	private Integer salary;
	private DepartmentVO department;

}
