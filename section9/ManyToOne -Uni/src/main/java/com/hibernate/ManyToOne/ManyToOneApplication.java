package com.hibernate.ManyToOne;

import com.hibernate.ManyToOne.dao.AppDao;
import com.hibernate.ManyToOne.entity.Course;
import com.hibernate.ManyToOne.entity.Instructor;
import com.hibernate.ManyToOne.entity.InstructorDetail;
import com.hibernate.ManyToOne.entity.Reviews;
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
			deleteCourseAndReviews(appDao);
		};
	}

	private void deleteCourseAndReviews(AppDao appDao) {
      appDao.deleteCourseAndReviews(10);
	}

	private void updateCourseAndReviews(AppDao appDao) {
		Course course = appDao.retrieveCourse(10);
		course.addReviews(new Reviews("Very Good Course"));
		Course c1 = appDao.updateCourseAndReviews(course);
		System.out.println(c1);
	}

	private void retrieveCourseAndReviews(AppDao appDao) {
		Course course = appDao.retrieveCourse(10);
		System.out.println("Retrieving.........");
		System.out.println(course);
	}

	private void createCourseAndReviews(AppDao appDao) {
		Course course = new Course("Paceman - How to score One Million Points");
		course.addReviews(new Reviews("Great Course loved it"));
		course.addReviews(new Reviews("Cool Course , job well done"));
		course.addReviews(new Reviews("What a dumb Course, you are an idiot"));
		appDao.saveCourse(course);
		System.out.println(course.getReviewsList());
	}


}
