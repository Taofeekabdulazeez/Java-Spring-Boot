package com.sirfeeky.cruddemo;

import com.sirfeeky.cruddemo.dao.AppDAO;
import com.sirfeeky.cruddemo.entity.Course;
import com.sirfeeky.cruddemo.entity.Instructor;
import com.sirfeeky.cruddemo.entity.InstructorDetail;

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
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			// deleteInstructor(appDAO);
			// findInstructorDetail(appDAO);
			// deleteInstructorDetail(appDAO);
			// createInstructorWithCourses(appDAO);
			// findInstructorWithCourses(appDAO);
			findCoursesforInstructor(appDAO);
		};
	}

	private void findCoursesforInstructor(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor: " + instructor);

		// find courses for instructor 
		List<Course> courses = appDAO.findCoursesByInstructorId(id);

		// associate the objects
		instructor.setCourses(courses);

		System.out.println("Courses: "+ courses);
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("Associated courses" +instructor.getCourses());

	}

	private void createInstructorWithCourses(AppDAO appDAO) {
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

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 3;
		appDAO.deleteInstructorDetailById(id);
		
	}

	private void findInstructorDetail(AppDAO appDAO) {
		// get the instructor detail object
		int id = 2;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		// print the instructor detail
		System.out.println("Instructor detail: "+instructorDetail);

		// print the associated instructor
		System.out.println("The associated instructor: "+ instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		appDAO.deleteInstructorById(id);
	}

	private void findInstructor(AppDAO appDAO) {
		int id  = 1;
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println(instructor.toString());
	}

	private void createInstructor(AppDAO appDAO) {
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
