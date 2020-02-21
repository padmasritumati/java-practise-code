package io.java.course_apidata;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicrepository;
	
		public List<Topic> getalltopics()
	{
		List<Topic> topics=new ArrayList<>();
		topicrepository.findAll()
		.forEach(topics::add);
		return topics;
	}
    
	public Optional<Topic> gettopic(String id) {
		return topicrepository.findById(id);
	}
	
	public void addtopic(Topic topic) {
		topicrepository.save(topic);
    	
    }
	public void updatetopic(String id,Topic topic) {
		topicrepository.save(topic);
			}
	public void delete(String id) {
		topicrepository.deleteById(id);
			
	}
}
