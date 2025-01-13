package com.hibernate.ManyToOne;

import com.hibernate.ManyToOne.dao.AppDao;
import com.hibernate.ManyToOne.entity.Course;
import com.hibernate.ManyToOne.entity.Instructor;
import com.hibernate.ManyToOne.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ManyToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManyToOneApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner -> {

			deleteCourseById(appDao);
		};
	}

	private void deleteCourseById(AppDao appDao) {
		appDao.deleteCourseById(10);
	}

	private void deleteInstructorById(AppDao appDao) {
		appDao.deleteInstructorById(1);
		System.out.println("Done!!");
	}

	private void updateCourseById(AppDao appDao) {
		Course course = appDao.findCoursesById(10);
		course.setTitle("Enjoy the Simple things");
		appDao.updateCourse(course);
		System.out.println("Done!!");
	}

	private void updateInstructorById(AppDao appDao) {
		Instructor instructor = appDao.findInstructorById(1);
		instructor.setLastName("Manual Tester");
		appDao.updateInstructor(instructor);
		System.out.println("Done!!");
	}

	private void createInstructorWithCourses(AppDao appDao) {
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Susan", "Public", "susan.public@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.youtube.com",
						"Video Games");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		//
		// NOTE: this will ALSO save the courses
		// because of CascadeType.PERSIST
		//
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDao.save(tempInstructor);

		System.out.println("Done!");
	}
private void findInstructorByJoinFetch(AppDao appDao){
	System.out.println("Finding insructor");
	Instructor tempInstructor = appDao.findInstructorByIdJoinFetch(1);
	List<Course> courses = tempInstructor.getCourses();
	System.out.println("tempInstructor: "+tempInstructor);
	System.out.println("the associated courses: ");
	for(Course c: courses){
		System.out.print(c.getTitle());
	}
	System.out.println("DONE!!");
}
	private void findCourseById(AppDao appDao){
		System.out.println("Finding insructor");
		//Instructor instructor =
		Course courses = appDao.findCoursesById(10);
		//System.out.println("tempInstructor: ");
		System.out.println("the associated courses: ");
//		for(Course c: courses){
//			System.out.println(c.getTitle());
//			//could not intialised due to lazy intialisation.
//			System.out.println("tempInstructor: "+c.getInstructor());
//		}
		System.out.println("DONE!!");
	}
}
