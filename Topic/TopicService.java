package io.komal.topic;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;

//the hard-coded list that we used initially, instead of the DB
//	private List<Topic> topics = new ArrayList<>(Arrays.asList(
//			new Topic("S", "Spring", "Spring Framework"),
//			new Topic("SB", "SpringBoot", "Spring and boot"),
//			new Topic("J", "Java", "Java OOP Concepts")));

	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
		
	}
	public Topic getTopic(String id){
		//return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
		
	}
	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic);
		
	}
	public void updateTopic(String id, Topic topic) {
//		for(int i = 0; i < topics.size(); i++){
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)){
//				topics.set(i, topic);
//				return;
//			}
//		}
		topicRepository.save(topic);
		//save can do both -- add and update, if the row exists - update, if it doesn't- create a new one
		
	}
	public void deleteTopic(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		topicRepository.delete(id);
		
	}
}
