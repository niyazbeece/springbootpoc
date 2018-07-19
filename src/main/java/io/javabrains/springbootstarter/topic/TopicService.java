package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getTopicsList(){
		//return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
		
	}

	public Topic getTopic(String id) {
		Topic topic = new Topic();
		topic = topicRepository.findById(id).get();
		return topic;
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}

	public void updateTopic(Topic topic) {
		topicRepository.save(topic);	
	}
	
}
