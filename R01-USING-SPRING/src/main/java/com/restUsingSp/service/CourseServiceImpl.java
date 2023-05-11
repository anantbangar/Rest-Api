package com.restUsingSp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.restUsingSp.entity.Course;

@Service
public class CourseServiceImpl implements CourseService 
{
	List<Course> list;
	
	public CourseServiceImpl()
	{
		list=new ArrayList<Course>();
		list.add(new Course(100,"java","java is best"));
		list.add(new Course(101,"spring","spring is best"));
		list.add(new Course(102,"hibernate","hibernate is best"));
		
	}
	
	@Override
	public List<Course> getCourses() 
	{		
		return list;
	}

	@Override
	public Course getCourse(Long courseId) 
	{
		Course course=null;
		
		for(Course c : list)
		{
			if(c.getId()==courseId)
			{
				course=c;
				break;
			}
		}
		return course;
	}

	@Override
	public Course addCourse(Course course) 
	{
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) 
	{
		list.forEach(e -> {
			if(e.getId()==course.getId())
			{
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		return course;
	}

	@Override
	public void deletCourse(Long id) 
	{
		list=this.list.stream().filter(e -> e.getId()!= id).collect(Collectors.toList());
		
	}
	
	


}
