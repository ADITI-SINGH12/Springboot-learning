package com.hibernate.ManyToMany.dao;


import com.hibernate.ManyToMany.entity.Course;
import com.hibernate.ManyToMany.entity.Student;
import java.util.*;
public interface AppDao {
void createCourseandStudent(Course course);
    void update(Student student);
Student findCoursefromStudent(int id);
List<Course> findStudentFromCourse(int id);
void deleteCourseByID(int id);
}
