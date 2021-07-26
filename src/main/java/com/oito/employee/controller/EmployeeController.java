package com.oito.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oito.employee.service.EmployeeService;
import com.oito.employee.vo.EmployeeVO;

@RestController
@RequestMapping("employees")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping("id/{id}")
	public String getAddress(final int id) {
		return service.getAddress(id);
	}

	@GetMapping("/{id}")
	public EmployeeVO getById(@PathVariable final Long id) {

		return service.getById(id);
	}

	@PostMapping
	public EmployeeVO save(@Valid @RequestBody final EmployeeVO vo) {

		return service.saveEmployee(vo);

	}

	@GetMapping("/all")
	public List<EmployeeVO> findAll() {

		return service.findAll();
	}

	@PutMapping
	public EmployeeVO update(@RequestBody final EmployeeVO vo) {

		return service.updateEmployee(vo);
	}

	@DeleteMapping("/{id}")
	public EmployeeVO delete(@PathVariable final Long id) {

		return service.deleteEmployee(id);
	}

	@GetMapping("name/{name}")
	public List<EmployeeVO> findByLastName(@PathVariable final String name) {
		return service.getEmployeeByLastName(name);
	}

}
