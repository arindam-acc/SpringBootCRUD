/**
 * 
 */
package com.employee.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeResponse;
import com.employee.dto.EmployeeDto;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

/**
 * 
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeResponse employeeResponse;
	
	@Autowired
	EmployeeDto employeeDto;
	
	@Autowired
	Employee emp;

	@Override
	public EmployeeResponse createEmployee(EmployeeDto employee) {
		
		emp.setEmpAge(employee.empAge);
		emp.setEmpCity(employee.empCity);
		emp.setEmpName(employee.empName);
		emp.setEmpSalary(employee.empSalary);
		emp.setEmpId(employee.empId);
		Employee savedEmployee = employeeRepository.save(emp);
		if(savedEmployee != null ) {
			employeeResponse.responseCode = 200;
			employeeResponse.message = "Employee created";
			employeeResponse.status = "Success";
			employeeDto.empAge = savedEmployee.getEmpAge();
			employeeDto.empCity = savedEmployee.getEmpCity();
			employeeDto.empName = savedEmployee.getEmpName();
			employeeDto.empId = savedEmployee.getEmpId();
			employeeDto.empSalary = savedEmployee.getEmpSalary();
			employeeResponse.empDto = new ArrayList<EmployeeDto>();
			employeeResponse.empDto.add(employeeDto);
		}
		
		return employeeResponse;
	}

	@Override
	public EmployeeResponse fetchEmployeeById(int id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		
		if(!emp.isEmpty() ) {
			employeeResponse.responseCode = 200;
			employeeResponse.message = "Employee Fetched";
			employeeResponse.status = "Success";
			employeeDto.empAge = emp.get().getEmpAge();
			employeeDto.empCity = emp.get().getEmpCity();
			employeeDto.empName = emp.get().getEmpName();
			employeeDto.empId = emp.get().getEmpId();
			employeeDto.empSalary = emp.get().getEmpSalary();
			employeeResponse.empDto = new ArrayList<EmployeeDto>();
			employeeResponse.empDto.add(employeeDto);
		}else {
			employeeResponse.responseCode = 403;
		}
		
		return employeeResponse;
		
	}

	@Override
	public EmployeeResponse fetchEmployees() {

		List<Employee> listEmp = employeeRepository.findAll();

		if (listEmp != null) {
			employeeResponse.responseCode = 200;
			employeeResponse.message = "Employee Fetched";
			employeeResponse.status = "Success";
			employeeResponse.empDto = new ArrayList<EmployeeDto>();
			List<EmployeeDto> listDto = new ArrayList<EmployeeDto>();
			for (Employee emp : listEmp) {
				employeeDto.empAge = emp.getEmpAge();
				employeeDto.empCity = emp.getEmpCity();
				employeeDto.empName = emp.getEmpName();
				employeeDto.empId = emp.getEmpId();
				employeeDto.empSalary = emp.getEmpSalary();
				listDto.add(employeeDto);
				employeeDto = new EmployeeDto();
			}
			employeeResponse.empDto.addAll(listDto);
		}
		return employeeResponse;
	}
		
	@Override
	public EmployeeResponse deleteEmployeeById(int id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if(!emp.isEmpty()) {
			employeeRepository.deleteById(id);
			employeeResponse.responseCode = 200;
		}else {
			employeeResponse.responseCode = 403;
		}
		return employeeResponse;
	}

	@Override
	public EmployeeResponse updateEmployee(EmployeeDto empDto,int id) {
		Employee emp = employeeRepository.findById(id).get();
		
		if (StringUtils.isNotEmpty(empDto.empName)) {
			emp.setEmpName(empDto.empName);
	        }
		if ((empDto.empId) != 0) {
			emp.setEmpId(empDto.empId);
		}
		if ((empDto.empAge) != 0) {
			emp.setEmpAge(empDto.empAge);
		}
		if ((empDto.empSalary) != 0) {
			emp.setEmpSalary(empDto.empSalary);
		}
		if (StringUtils.isNotEmpty(empDto.empCity)) {
			emp.setEmpCity(empDto.empCity);
		}
		Employee empRes = employeeRepository.save(emp);
		if(empRes != null ) {
			employeeResponse.responseCode = 200;
			employeeResponse.message = "Employee Updated ";
			employeeResponse.status = "Success";
			employeeDto.empAge = empRes.getEmpAge();
			employeeDto.empCity = empRes.getEmpCity();
			employeeDto.empName = empRes.getEmpName();
			employeeDto.empId = empRes.getEmpId();
			employeeDto.empSalary = empRes.getEmpSalary();
			employeeResponse.empDto = new ArrayList<EmployeeDto>();
			employeeResponse.empDto.add(employeeDto);
		}
		return employeeResponse;
		
	}

	@Override
	public EmployeeResponse updateEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
