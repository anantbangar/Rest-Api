package com.restUsingSpBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restUsingSpBoot.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
