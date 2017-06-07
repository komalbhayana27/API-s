package io.komal.course;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;

//the hard-coded list that we used initially, instead of the DB
//	private List<Topic> topics = new ArrayList<>(Arrays.asList(
//			new Topic("S", "Spring", "Spring Framework"),
//			new Topic("SB", "SpringBoot", "Spring and boot"),
//			new Topic("J", "Java", "Java OOP Concepts")));

	public List<Course> getAllCourses(String topicId){
		//return topics;
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
		
	}
	public Course getCourse(String id){
		//return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
		return courseRepository.findOne(id);
		
	}
	public void addCourse(Course course) {
		//topics.add(topic);
		courseRepository.save(course);
		
	}
	public void updateCourse(Course topic) {
//		for(int i = 0; i < topics.size(); i++){
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)){
//				topics.set(i, topic);
//				return;
//			}
//		}
		courseRepository.save(topic);
		//save can do both -- add and update, if the row exists - update, if it doesn't- create a new one
		
	}
	public void deleteCourse(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		courseRepository.delete(id);
		
	}
}
