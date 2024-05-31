package com.restAPIStudent.StudentRestAPI.rest;

import com.restAPIStudent.StudentRestAPI.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api")
public class StudentController {
    List<Student> thestudent;
    @PostConstruct
    public void listStudent(){
   thestudent = new ArrayList<>();
        thestudent.add(new Student("Poornima", "Patel"));
        thestudent.add(new Student("Mario", "Rossi"));
        thestudent.add(new Student("Mary", "Smith"));
    }
    @GetMapping("/student")
    public List<Student> listOFALL(){
        return thestudent;
    }
    @GetMapping("/student/{studentID}")
    public Student studentByID(@PathVariable int studentID){
        return thestudent.get(studentID);
    }
}
