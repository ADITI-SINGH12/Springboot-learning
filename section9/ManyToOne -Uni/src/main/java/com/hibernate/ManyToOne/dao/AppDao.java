package com.hibernate.ManyToOne.dao;

import com.hibernate.ManyToOne.entity.Course;
import com.hibernate.ManyToOne.entity.Instructor;
import java.util.*;
public interface AppDao {
    void saveCourse(Course course);
    Course retrieveCourse(int id);
    Course updateCourseAndReviews(Course course);
    void deleteCourseAndReviews(int id);
}
