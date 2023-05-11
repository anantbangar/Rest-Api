package com.restUsingSp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restUsingSp.entity.Employee;
import com.restUsingSp.service.EmployeeService;

@RestController
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/emp") 
	public String addEmp(@RequestBody Employee emp) 
	{
	  this.employeeService.createEmp(emp); 
	  return "Employee Added Successfully"; 
	}
	
	@GetMapping("/emps")
	public List<Employee> getAllEmp()
	{
		return this.employeeService.getAllEmp();
	}
	
	@GetMapping("/emp/{id}")
	public Employee getEmp(@PathVariable String id)
	{
		return this.employeeService.getEmp(Integer.parseInt(id));
	}
	
	@DeleteMapping("/emp/{id}")
	public String deleteEmp(@PathVariable String id)
	{
		this.employeeService.deleteEmp(Integer.parseInt(id));
		return "Employee Deleted Successfully";
	}
	
	@PutMapping("/emp")
	public ResponseEntity<HttpStatus> updateEmp(@RequestBody Employee e)
	{
		try 
		{
			this.employeeService.updateEmp(e);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} 
		catch (Exception e2) 
		{
			e2.printStackTrace();
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	 

}
