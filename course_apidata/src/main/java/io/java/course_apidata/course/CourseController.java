package io.java.course_apidata.course;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.java.course_apidata.Topic;

import org.springframework.web.bind.annotation.RequestMethod;
@RestController
public class CourseController {
	@Autowired
	private CourseService courseservice;
	
	@RequestMapping("/topics/{topicId}/course")
	public List<Course> getall(@PathVariable String topicId) {
		return courseservice.getallcourses(topicId);
	}
	@RequestMapping("/topics/{topicId}/course/{id}")
	public Optional<Course> getcourse(@PathVariable String id) {
		return courseservice.getcourse(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/topics/{topicId}/course")
	public void addtopic(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseservice.addcourse(course);
	}
    
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/course/{id}") 
	public void updatetopic(@PathVariable String id,@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseservice.updatecourse(course);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}/course")
	public void delete(@PathVariable String id) {
		courseservice.delete(id);
	}
}
