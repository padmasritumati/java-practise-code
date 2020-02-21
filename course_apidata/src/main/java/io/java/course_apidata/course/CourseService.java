package io.java.course_apidata.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courserepository;
	
		public List<Course> getallcourses(String topicId)
	{
		List<Course> courses=new ArrayList<>();
		courserepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
	}
    
	public Optional<Course> getcourse(String id) {
		return courserepository.findById(id);
	}
	
	public void addcourse(Course course) {
		courserepository.save(course);
    	
    }
	public void updatecourse(Course course) {
		courserepository.save(course);
			}
	public void delete(String id) {
		courserepository.deleteById(id);
			
	}
}
