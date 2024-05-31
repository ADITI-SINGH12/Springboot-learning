package com.restAPIStudent.StudentRestAPI.rest;

import com.restAPIStudent.StudentRestAPI.entity.Student;
import com.restAPIStudent.StudentRestAPI.exception.StudentException;
import com.restAPIStudent.StudentRestAPI.exception.StudentFileNotFound;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api")
public class StudentController {
    List<Student> thestudent;

    // define @PostConstruct to load the student data ... only once!

    @PostConstruct
    public void listStudent(){
   thestudent = new ArrayList<>();
        thestudent.add(new Student("Poornima", "Patel"));
        thestudent.add(new Student("Mario", "Rossi"));
        thestudent.add(new Student("Mary", "Smith"));
    }
    // define @PostConstruct to load the student data ... only once!
    @GetMapping("/student")
    public List<Student> listOFALL(){
        return thestudent;
    }
    @GetMapping("/student/{studentID}")
    public Student studentByID(@PathVariable int studentID){
        if(studentID > thestudent.size() || studentID < 0){
            throw new StudentFileNotFound("Student not found with this id");
        }
        return thestudent.get(studentID);
    }
    @ExceptionHandler
    public ResponseEntity<StudentException> handleException(StudentFileNotFound exc){
        StudentException studentException = new StudentException();
        studentException.setStatus(HttpStatus.NOT_FOUND.value());
        studentException.setMessage(exc.getMessage());
        studentException.setTimestamps(System.currentTimeMillis());
        return new ResponseEntity<>(studentException,HttpStatus.BAD_REQUEST);
    }

}
