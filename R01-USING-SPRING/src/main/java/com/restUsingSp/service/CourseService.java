package com.restUsingSp.service;

import java.util.List;

import com.restUsingSp.entity.Course;

public interface CourseService
{
	public List<Course> getCourses();
	public Course getCourse(Long courseId);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void deletCourse(Long id);

}
