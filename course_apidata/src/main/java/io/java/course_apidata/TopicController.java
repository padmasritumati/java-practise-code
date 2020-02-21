package io.java.course_apidata;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
@RestController
public class TopicController {
	@Autowired
	private TopicService topicservice;
	
	@RequestMapping("/topics")
	public List<Topic> getall() {
		return topicservice.getalltopics();
	}
	@RequestMapping("/topics/{id}")
	public Optional<Topic> gettopic(@PathVariable String id) {
		return topicservice.gettopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/topics")
	public void addtopic(@RequestBody Topic topic) {
		topicservice.addtopic(topic);
	}
    
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}") 
	public void updatetopic(@PathVariable String id,@RequestBody Topic topic) {
		topicservice.updatetopic(id, topic);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void delete(@PathVariable String id) {
		topicservice.delete(id);
	}
}
