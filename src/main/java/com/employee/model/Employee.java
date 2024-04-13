/**
 * 
 */
package com.employee.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "Employee")
@Component
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "emp_salary")
	private float empSalary;
	
	@Column(name = "emp_age")
	private int empAge;
	
	@Column(name = "emp_city")
	private String empCity;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public float getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public String getEmpCity() {
		return empCity;
	}

	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}

	public Employee(int empId, String empName, float empSalary, int empAge, String empCity) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empAge = empAge;
		this.empCity = empCity;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empAge=" + empAge
				+ ", empCity=" + empCity + "]";
	}
	
	public Employee() {
		
	}
	
}
