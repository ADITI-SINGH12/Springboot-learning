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
			createConstructor(appDao);
		};
	}

	private void createConstructor(AppDao appDao) {
		Instructor tempInstructor = new Instructor("Adit","Patel","Aditi.Patel@luv2code.com");
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("https://www.luv2codeaditui.com/youtube","Dance");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		//this will save the details object because Cascade Type. All
		System.out.println("Saving Instructor : "+tempInstructor);
		appDao.save(tempInstructor);
		System.out.println("DONE!!");
	}
	private void findQuery(AppDao appDao){
		Instructor theinstructor = appDao.findInstructorById(2);
		System.out.println(theinstructor);
	}
	private void DeleteInstructorById(AppDao appDao){
		System.out.println("Deleting the instructor detail: "+appDao.findInstructorById(4));
		appDao.DeleteInstructorByiD(4);
		System.out.println("Deleted");
	}
}
