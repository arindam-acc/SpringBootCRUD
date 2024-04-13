package com.employee.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class EmployeeDto {
	
	@Getter
	@Setter
	public int empId;
	
	@Getter
	@Setter
	public String empName;
	
	@Getter
	@Setter
	public float empSalary;
	
	@Getter
	@Setter
	public int empAge;
	
	@Getter
	@Setter
	public String empCity;

}
