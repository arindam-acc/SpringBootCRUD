/**
 * 
 */
package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDto;
import com.employee.dto.EmployeeResponse;
import com.employee.service.EmployeeService;
import com.employee.validation.Validation;

/**
 * 
 */
@RestController
public class EmployeeController {

	@Autowired
	Validation validation;

	@Autowired
	EmployeeResponse employeeResponse;
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/test")
	public String testing() {
		return "Hello World !!!";
	}

	
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse createEmployee(@RequestBody EmployeeDto employeeDto) {

		boolean validated = validation.validateEmployeeDto(employeeDto);
		
		if (validated) {
			employeeResponse = employeeService.createEmployee(employeeDto);
		}
		return employeeResponse;
	}
	  
	@GetMapping(value = "/{id}")
	public EmployeeResponse getEmployeeByID(@PathVariable("id") int id) {
		
		EmployeeResponse employeeResponse = employeeService.fetchEmployeeById(id);
		if(employeeResponse.responseCode != 200) {
			employeeResponse = new EmployeeResponse();
			employeeResponse.status="Success !";
			employeeResponse.message="No Employee found !!!";
			employeeResponse.responseCode=204;
			return employeeResponse;
		}
			return employeeResponse;
	}
	
	@GetMapping("/all")
	public EmployeeResponse getAllEmployees() {
		
		return employeeResponse = employeeService.fetchEmployees();
		
	}
	
	@PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse updateEmployee(@RequestBody EmployeeDto empDto, @PathVariable("id") int id) {
		
			employeeResponse = employeeService.updateEmployee(empDto, id);
		return employeeResponse;
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public EmployeeResponse deleteEmployeeById(@PathVariable("id") int id) {
		EmployeeResponse empDel = null;
		if(id != 0) {
			empDel = employeeService.deleteEmployeeById(id);
			if(empDel.responseCode == 200) {
				empDel.message = "Record Deleted";
				empDel.status = "Success";
				empDel.responseCode = 200;
			}else {
				empDel.message = "No record to delete";
				empDel.status = "Success";
				empDel.responseCode = 403;
			}
		}
		return empDel;
	}
	 
}
