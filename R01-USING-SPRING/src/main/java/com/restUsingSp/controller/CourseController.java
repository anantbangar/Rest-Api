package com.restUsingSp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.restUsingSp.entity.Course;
import com.restUsingSp.service.CourseServiceImpl;

@org.springframework.web.bind.annotation.RestController
public class CourseController 
{	
	@Autowired
	private CourseServiceImpl courseServiceImpl;
				
	@GetMapping("/courses")
	//@RequestMapping(path = "/courses", method = RequestMethod.GET)
	public List<Course> getCourses()
	{
		return this.courseServiceImpl.getCourses();
	}
	
	@GetMapping("/course/{id}")
	//@RequestMapping(path = "/course/{id}", method = RequestMethod.GET)
	public Course getCourse(@PathVariable String id)
	{
		return this.courseServiceImpl.getCourse(Long.parseLong(id));
	}
	
	@PostMapping("/course")
	//@RequestMapping(path = "/course", method = RequestMethod.POST)
	public Course addCourse(@RequestBody Course course)
	{
		return this.courseServiceImpl.addCourse(course);
	}
	
	@PutMapping("/course")
	//@RequestMapping(path = "/course", method = RequestMethod.PUT)
	public Course updateCourse(@RequestBody Course course)
	{
		return this.courseServiceImpl.updateCourse(course);
	}
	
	@DeleteMapping("/course/{id}")
	//@RequestMapping(path = "/course/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String id)
	{
		try 
		{
			this.courseServiceImpl.deletCourse(Long.parseLong(id));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
