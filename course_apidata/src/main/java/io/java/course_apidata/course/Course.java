package io.java.course_apidata.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.java.course_apidata.Topic;

@Entity
public class Course {
@Id
private String id;
private String name;
private String des;
@ManyToOne
private Topic topic;

public Course() {
	
}
public Course(String id, String name, String des,String topicId) {
	super();
	this.id = id;
	this.name = name;
	this.des = des;
	this.topic=new Topic(topicId,"","");
}

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDes() {
	return des;
}
public void setDes(String des) {
	this.des = des;
}
public Topic getTopic() {
	return topic;
}
public void setTopic(Topic topic) {
	this.topic = topic;
}

}
