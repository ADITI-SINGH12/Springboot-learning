package com.hibernate.ManyToOne.dao;

import com.hibernate.ManyToOne.entity.Course;
import com.hibernate.ManyToOne.entity.Instructor;
import java.util.*;
public interface AppDao {
    void save(Instructor instructor);
    Instructor findInstructorByIdJoinFetch(int id);
    Course findCoursesById(int id);
    Instructor findInstructorById(int id);
    Instructor updateInstructor(Instructor instructor);
    Course updateCourse(Course course);
    void deleteInstructorById(int id);
    void deleteCourseById(int id);
}
