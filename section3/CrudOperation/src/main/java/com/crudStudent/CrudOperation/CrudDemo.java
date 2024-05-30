package com.crudStudent.CrudOperation;

import com.crudStudent.CrudOperation.DAO.StudentDAO;
import com.crudStudent.CrudOperation.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemo {
    public static void main(String[] args) {
        SpringApplication.run(CrudDemo.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            //createStudent(studentDAO)
           // createMultipleStudents(studentDAO);
           // readStudentById(studentDAO,3);
            //showAllStudents(studentDAO);
           // showStudentByLastname(studentDAO);
          //  showStudentUsingLikeOperator(studentDAO);
           // showStudentusinggNamedOperator(studentDAO);
            //showAllStudentUsingSelectClause(studentDAO);
            //updateStudentLastName(studentDAO);
            showdeletedStudent(studentDAO);
        };
    }

    private void showdeletedStudent(StudentDAO studentDAO) {
        System.out.println("Details of deleted students..........");
        String sb = studentDAO.deleteStudentOfID();
        System.out.println(sb);
    }

    private void updateStudentLastName(StudentDAO studentDAO) {
        System.out.println("Details of Student, after updating id = 6.............................");
       Student studentList= studentDAO.updateLastnameOfStudent();
            System.out.println(studentList);

    }

    private void showAllStudentUsingSelectClause(StudentDAO studentDAO) {
        System.out.println("Details of Student whose pattern is (%it%) using SELECT Clause ............");
        List<Student> studentList= studentDAO.findStudentusingSelectClause();
        for(Student student: studentList){
            System.out.println("-> "+student);
        }
    }

    private void showStudentusinggNamedOperator(StudentDAO studentDAO) {
        System.out.println("Suhani detail is avaialable using named operator in Query..........");
       List<Student> studentList= studentDAO.findStudentusingNamedOperator("Suhani");
        for(Student student: studentList){
            System.out.println("-> "+student);
        }
    }

    private void showStudentUsingLikeOperator(StudentDAO studentDAO) {
        System.out.println("Details of those students which follow these patterns(%luv2code.com).......");
        List<Student> studentList= studentDAO.findStudentusingLikeOperator();
        for(Student student: studentList){
            System.out.println("-> "+student);
        }
    }

    private void showStudentByLastname(StudentDAO studentDAO) {
        System.out.println("Details of All Students whose name ends with 'Singh'...................");
        List<Student> studentList = studentDAO.findStudentByLastname();
        for(Student student: studentList){
            System.out.println("-> "+student);
        }
    }

    private void readStudentById(StudentDAO studentDAO,int id){
    System.out.println(studentDAO.read(1).toString());
   //createMultipleStudents(studentDAO)
      //createStudent(studentDAO)
  }

    private void showAllStudents(StudentDAO studentDAO) {
        System.out.println("Details of All Students...................");
       List<Student> studentList=studentDAO.readAllStudents();
       for(Student student: studentList){
           System.out.println("-> "+student);
       }
    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        // create multiple students
        System.out.println("Creating 3 student objects ...");
        Student tempStudent1 = new Student("Aditi", "Singh", "aditi@luv2code.com");
        Student tempStudent2 = new Student("Suhani", "Singh", "suhani@luv2code.com");
        Student tempStudent3 = new Student("Sanatan", "Singh", "snatan@luv2code.com");

        // save the student objects
        System.out.println("Saving the students ...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

        // save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
