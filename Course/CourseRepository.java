package io.komal.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{
	
	//spring data JPA will provide the class
	//CrudRepository will have all the common methods to access the data and we need to provide generic types to it
	// since its an interface, we need method declaration only -- Spring JPA framework will figure out the implementation
	public List<Course> findByTopicId(String topicId);
	
	
}
