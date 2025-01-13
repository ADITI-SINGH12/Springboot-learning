package com.hibernate.ManyToOne.dao;

import com.hibernate.ManyToOne.entity.Course;
import com.hibernate.ManyToOne.entity.Instructor;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDao{
    private EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i "+
                "JOIN FETCH i.courses"+  " JOIN FETCH i.instructorDetail "+ "where i.id= :thedata", Instructor.class);
        query.setParameter("thedata",1);
        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    public Course findCoursesById(int id) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where id= :data", Course.class);
        query.setParameter("data",id);
        Course courses = query.getSingleResult();
        return courses;
    }

    @Override
    public Instructor findInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class,id);
        return instructor;
    }

    @Override
    @Transactional
    public Instructor updateInstructor(Instructor instructor) {
        return  entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public Course updateCourse(Course course) {
        return entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = findInstructorById(id);
        //break association of course from Instructor
        List<Course> courses = instructor.getCourses();
        for (Course course: courses) {
            course.setInstructor(null);
        }
        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class,id);
        entityManager.remove(course);
    }

}
