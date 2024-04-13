package com.employee.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.employee.dto.EmployeeDto;

@Component
public class Validation {

	public boolean validateEmployeeDto(EmployeeDto employeeDto) {
		
		boolean isValidEmployeeDto = false;
		if(employeeDto != null) {
			
			if(StringUtils.isNotEmpty(employeeDto.empName) && StringUtils.isNotEmpty(employeeDto.empCity) 
					&& employeeDto.empAge != 0 && employeeDto.empSalary != 0.0) {	
				isValidEmployeeDto = true;
			}
		}
		return isValidEmployeeDto;
	}
	
}
