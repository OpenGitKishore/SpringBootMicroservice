package com.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	private String employeename;
	private String empID;
	private String deptName;

	public Employee() {

	}

	public Employee(String employeename, String empID, String deptName) {
		this.employeename = employeename;
		this.empID = empID;
		this.deptName = deptName;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
