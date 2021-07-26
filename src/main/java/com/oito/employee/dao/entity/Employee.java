package com.oito.employee.dao.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.oito.department.dao.entity.Department;
import com.oito.employee.dao.audit.AuditListener;
import com.oito.employee.dao.audit.Auditable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "employee")
@EntityListeners(AuditListener.class)
public class Employee implements Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long id;
	@Column(name = "first_name", nullable = false)
	@NotBlank(message = "first name can't be blank")
	private String firstName;
	@Column(name = "last_name", nullable = false)
	@NotBlank(message = "last name can't be blank")
	private String lastName;
	@Column(name = "salary")
	private Integer salary;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_Id")
	private Department department;
	@Embedded
	private Audit audit;
//gradlew clean  build -x test
//	@OneToOne(cascade = CascadeType.ALL, targetEntity = Department.class)
//	@JoinColumn(name = "department_id", referencedColumnName = "id")
//	private Department department;

}
