package com.oito.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oito.department.service.DepartmentService;
import com.oito.department.vo.DepartmentVO;

@RestController
@RequestMapping("departments")
public class DepartmentController {

	@Autowired
	DepartmentService service;

	@GetMapping("{id}")
	public DepartmentVO getById(@PathVariable final Long id) {
		return service.getById(id);
	}

	@PostMapping
	public DepartmentVO save(@RequestBody final DepartmentVO vo) {

		return service.saveDepartment(vo);

	}

	@PutMapping
	public DepartmentVO update(@RequestBody final DepartmentVO vo) {

		return service.updateDepartment(vo);
	}

	@DeleteMapping("{id}")
	public DepartmentVO delete(@PathVariable final Long id) {

		return service.deleteDepartment(id);
	}

}
