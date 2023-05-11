package com.restUsingSpBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restUsingSpBoot.entity.Employee;
import com.restUsingSpBoot.dao.EmployeeDao;

@RestController
public class EmployeeController 
{
	@Autowired
	private EmployeeDao employeeDao;
			
	@PostMapping("/emp") 
	public String addEmp(@RequestBody Employee employee) 
	{
		employeeDao.save(employee);
		return "Employee Added Successfully"; 
	}
	
	@GetMapping("/emps")
	public List<Employee> getAllEmp()
	{
		return employeeDao.findAll();
		//return this.employeeService.getAllEmp();
	}
	
	@GetMapping("/emp/{id}")
	public Employee getEmp(@PathVariable String id)
	{
		return employeeDao.getReferenceById(Integer.parseInt(id));
	}
	
	@DeleteMapping("/emp/{id}")
	public String deleteEmp(@PathVariable String id)
	{
		Employee employee = employeeDao.getReferenceById(Integer.parseInt(id));
		employeeDao.delete(employee);
		return "Employee Deleted Successfully";
	}
	
	@PutMapping("/emp")
	public ResponseEntity<HttpStatus> updateEmp(@RequestBody Employee e)
	{
		try 
		{
			employeeDao.save(e);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			
		} 
		catch (Exception e2) 
		{
			e2.printStackTrace();
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	 

}
