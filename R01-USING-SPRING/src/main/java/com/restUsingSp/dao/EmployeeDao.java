package com.restUsingSp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.restUsingSp.entity.Employee;

@Repository
public class EmployeeDao 
{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createEmp(Employee emp)
	{
		this.hibernateTemplate.save(emp);
	}
	
	public List<Employee> getAllEmp()
	{
		List<Employee> allEmpList = this.hibernateTemplate.loadAll(Employee.class);
		return allEmpList;
	}
	
	public Employee getEmp(int id)
	{
		Employee emp = this.hibernateTemplate.get(Employee.class,id);
		return emp;
	}
		
	@Transactional
	public void deleteEmp(int id)
	{
		Employee emp = this.hibernateTemplate.get(Employee.class,id);
		this.hibernateTemplate.delete(emp);
	}
	
	@Transactional
	public void updateEmp(Employee e)
	{
		//Employee emp = this.hibernateTemplate.get(Employee.class,e.getId());
		//emp.setName(e.getName());
		//emp.setSalary(e.getSalary());
		this.hibernateTemplate.update(e);
		
	}
	
	

}
