package io.komal.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String>{
	
	//spring data JPA will provide the class
	//CrudRepository will have all the common methods to access the data and we need to provide genric types to it
	
	
	
	
}
