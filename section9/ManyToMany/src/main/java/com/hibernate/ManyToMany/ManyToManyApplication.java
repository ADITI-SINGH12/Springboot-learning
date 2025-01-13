package com.hibernate.ManyToMany;

import com.hibernate.ManyToMany.dao.AppDao;
import com.hibernate.ManyToMany.entity.Course;
import com.hibernate.ManyToMany.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import  java.util.*;

@SpringBootApplication
public class ManyToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner -> {
			deleteCourseById(appDao);
		};
	}

	private void deleteCourseById(AppDao appDao) {
		appDao.deleteCourseByID(15);
	}

	private void addMoreCoursesForStudent(AppDao appDAO) {

		int theId = 2;
		Student tempStudent = appDAO.findCoursefromStudent(theId);

		// create more courses
		Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
		Course tempCourse2 = new Course("Atari 2600 - Game Development");

		// add courses to student
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("Updating student: " + tempStudent);
		System.out.println("associated courses: " + tempStudent.getCourses());

		appDAO.update(tempStudent);

		System.out.println("Done!");
	}
	private void retrieveStudentFromCourse(AppDao appDao) {
		List<Course> course = appDao.findStudentFromCourse(15);
		System.out.println("Asssociated course");

		for(Course c: course){
			System.out.println(c.getStudents());
		}
	}

	private void retrieveCourseFromStudent(AppDao appDao) {
		Student student= appDao.findCoursefromStudent(1);
		System.out.println("hhhhh"+student);
		List<Course> courses = student.getCourses();
		for(Course c: courses){
			System.out.println(c);
		}
	}

	private void createCourseAndStudent(AppDao appDao) {
		// create a course
		Course tempCourse = new Course("Pacman - How To Score One Million Points");

		// create the students
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");

		// add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		// save the course and associated students
		System.out.println("Saving the course: " + tempCourse);
		System.out.println("associated students: " + tempCourse.getStudents());

		//appDao.createCourseandStudent(tempCourse);

		System.out.println("Done!");
	}

}
