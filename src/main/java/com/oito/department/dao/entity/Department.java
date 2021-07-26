package com.oito.department.dao.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.oito.employee.dao.audit.AuditListener;
import com.oito.employee.dao.audit.Auditable;
import com.oito.employee.dao.entity.Audit;
import com.oito.employee.dao.entity.Employee;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@Table(name = "department")
@EntityListeners(AuditListener.class)
@ToString
public class Department implements Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private List<Employee> employeeList;
	@Embedded
	private Audit audit;

}
