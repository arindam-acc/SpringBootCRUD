package com.employee.dto;

import java.util.List;

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
public class EmployeeResponse {
	@Getter
	@Setter
	public int responseCode;
	
	@Getter
	@Setter
	public String status;
	
	@Getter
	@Setter
	public String message;
	
	@Getter
	@Setter
	public List<EmployeeDto> empDto;
	

}
