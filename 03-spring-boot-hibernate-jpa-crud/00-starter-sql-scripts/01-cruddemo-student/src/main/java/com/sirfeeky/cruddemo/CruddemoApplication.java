package com.sirfeeky.cruddemo;

import com.sirfeeky.cruddemo.dao.StudentDao;
import com.sirfeeky.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
//			createStudent(studentDao);
//			createMultipleStudents(studentDao);
//			readStudents(studentDao);
			queryForStudents(studentDao);
		};

	}

	private void queryForStudents(StudentDao studentDao) {
		// get a list of students
		List<Student> students = studentDao.findAll();

		// display the list of students
		for (Student student: students) {
			System.out.println(student.toString());
		}
	}

	private void readStudents(StudentDao studentDao) {
		// create a student object
		Student newStudent = new Student("Yusuf", "Balogun", "yusuf@gmail.com");

		// save the student
		studentDao.save(newStudent);

		// display id of the saved student
		System.out.println("Student created with id: "+newStudent.getId());

		// retrieve student: based on the id: primary key
		Student student = studentDao.findById(newStudent.getId());

		// display the student
		System.out.println(student.toString());
	}

	private void createStudent(StudentDao studentDao){
		// create a student object
		System.out.println("Creating the student object..........");
		Student newStudent = new Student("Taofeek", "Abdulazeez", "taofeekabdulazeez2020@gmail.com");

		// save the student object
		System.out.println("Saving the student object..........");
		studentDao.save(newStudent);


		// display id of the saved student
		System.out.println("Saved student, Generated id: "+ newStudent.getId());
	}

	private void createMultipleStudents(StudentDao studentDao){
		// create multiple students
		System.out.println("Creating 3 student object..........");
		Student newStudent1 = new Student("Taofeek", "Abdulazeez", "taofeekabdulazeez2020@gmail.com");
		Student newStudent2 = new Student("Muhammed", "Basheer", "muhbaheer@gmail.com");
		Student newStudent3 = new Student("Muhammed", "Imam-fulani", "imamjamiu@gmail.com");


		// save the student objects
		System.out.println("Saving the 3 student object..........");
		studentDao.save(newStudent1);
		studentDao.save(newStudent2);
		studentDao.save(newStudent3);
	}


}

