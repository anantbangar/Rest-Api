package com.restUsingSp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restUsingSp.dao.EmployeeDao;
import com.restUsingSp.entity.Employee;

@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeDao employeeDao;
	
	public void createEmp(Employee emp)
	{
		this.employeeDao.createEmp(emp);
		
	}
	
	public List<Employee> getAllEmp()
	{
		List<Employee> allEmpList = this.employeeDao.getAllEmp();
		return allEmpList;
	}
	
	public Employee getEmp(int id)
	{
		Employee emp = this.employeeDao.getEmp(id);
		return emp;
	}
	
	public void deleteEmp(int id)
	{
		this.employeeDao.deleteEmp(id);
	}
	
	public void updateEmp(Employee e)
	{
		this.employeeDao.updateEmp(e);
	}

}
