/**
 * 
 */
package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeResponse;
import com.employee.dto.EmployeeDto;
import com.employee.model.Employee;

/**
 * 
 */
public interface EmployeeService {
	
	public EmployeeResponse createEmployee(EmployeeDto emp);
	
	public EmployeeResponse fetchEmployeeById(int id);
	
	public EmployeeResponse fetchEmployees();
	
	public EmployeeResponse deleteEmployeeById(int id);
	
	public EmployeeResponse updateEmployee(int id);

	EmployeeResponse updateEmployee(EmployeeDto dto, int id);
	
	

}
