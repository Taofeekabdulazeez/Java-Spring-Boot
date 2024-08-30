package com.sirfeeky.cruddemo;

import com.sirfeeky.cruddemo.dao.AppDAO;
import com.sirfeeky.cruddemo.entity.Course;
import com.sirfeeky.cruddemo.entity.Instructor;
import com.sirfeeky.cruddemo.entity.InstructorDetail;
import com.sirfeeky.cruddemo.entity.Review;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			// createCourseAndReviews(appDAO);
			// retrieveCourseAndReviews(appDAO);
			deleteCourseAndReviews(appDAO);
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		// this will delete the associated reviews
		appDAO.deleteCourseById(id);
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		// get the course and reviews
		int id = 10;
		Course course = appDAO.findCourseAndReviewsByCourseId(id);

		// print the course
		System.out.println("Course: "+course);

		// print associated reviews
		System.out.println("Associated Reviews: "+course.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// create a course
		Course course = new Course("Compiler Construction");

		// add some reviews
		course.addReview(new Review("Great course, love it"));
		course.addReview(new Review("This is my best course ever!"));
		course.addReview(new Review("Damn! You made me love compiler construction"));

		// save the course ... (automatically saved the associated reviews)
		appDAO.save(course);
	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 12;
		appDAO.deleteCourseById(id);
	}

	public void updateCourse(AppDAO appDAO) {
		int id = 11;

		// find the course
		Course course = appDAO.findCourseById(id);

		// update course
		course.setTitle("Object Oriented Programming");

		appDAO.update(course);

	}

	public void updateInstructor(AppDAO appDAO) {
		int id = 1;

		// find the instructor
		Instructor instructor = appDAO.findInstructorById(id);

		// update the instructor
		instructor.setLastName("Ayub");

		appDAO.update(instructor);
	}

	public void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;

		// find the instructor
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("Associated courses: "+instructor.getCourses());
	}

	public void findCoursesforInstructor(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor: " + instructor);

		// find courses for instructor 
		List<Course> courses = appDAO.findCoursesByInstructorId(id);

		// associate the objects
		instructor.setCourses(courses);

		System.out.println("Courses: "+ courses);
	}

	public void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("Associated courses" +instructor.getCourses());

	}

	public void createInstructorWithCourses(AppDAO appDAO) {
		// create instructor
		Instructor instructor = new Instructor("Yusuf", "Balogun", "balogyusuf@gmail.com");

		// create instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("https://yusuf.vercel.app", "Coding");

		// associate the objects
		instructor.setInstructorDetail(instructorDetail);

		// create some courses
		Course course1 = new Course("Data Structures and Algorithms");
		Course course2 = new Course("Functional Programming");
		
		instructor.add(course1);
		instructor.add(course2);

		appDAO.save(instructor);

	}

	public void deleteInstructorDetail(AppDAO appDAO) {
		int id = 3;
		appDAO.deleteInstructorDetailById(id);
		
	}

	public void findInstructorDetail(AppDAO appDAO) {
		// get the instructor detail object
		int id = 2;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		// print the instructor detail
		System.out.println("Instructor detail: "+instructorDetail);

		// print the associated instructor
		System.out.println("The associated instructor: "+ instructorDetail.getInstructor());
	}

	public void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		appDAO.deleteInstructorById(id);
	}

	public void findInstructor(AppDAO appDAO) {
		int id  = 1;
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println(instructor.toString());
	}

	public void createInstructor(AppDAO appDAO) {
		// create instructor
		Instructor instructor = new Instructor("Abdullahi", "Haruna", "harun@gmail.com");

		// create instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("https://tao.vercel.app", "Coding");

		// associate the objects
		instructor.setInstructorDetail(instructorDetail);

		// save the instructor
		appDAO.save(instructor);
	}
}
