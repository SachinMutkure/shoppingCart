package com.sam.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name="employees") 
public class EmployeeListDo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Employee> employees  =new ArrayList<Employee>();
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
