package com.hibernate.OneToOneMapping;

import com.hibernate.OneToOneMapping.dao.AppDao;
import com.hibernate.OneToOneMapping.entity.Instructor;
import com.hibernate.OneToOneMapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToOneMappingApplication {

	public static void main(String[] args) {

		SpringApplication.run(OneToOneMappingApplication.class, args);
	}
	@Bean
    public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner ->{
			deleteInstructorDetails(appDao);
		};
	}
	private void createInstructor(AppDao appDAO) {


		// create the instructor
		Instructor tempInstructor =
				new Instructor("Aditi", "Darby", "adity@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2codeadity.com/youtube",
						"Luv 2 code!!!");



		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}


	private void findQuery(AppDao appDao){

		InstructorDetail theinstructorDetail = appDao.findInstructorDetailById(2);
		System.out.println(theinstructorDetail);
	}
	private void deleteInstructorDetails(AppDao appDao){
		System.out.println("Deleting instructor");
//		InstructorDetail theinstructorDetail = appDao.findInstructorDetailById(2);
		appDao.deleteInstructorDetailOnly(1);
//		System.out.println(theinstructorDetail.getInstructor());
}
}
