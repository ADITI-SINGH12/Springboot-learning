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
    public void saveCourse(Course course) {
         entityManager.persist(course);
    }

    @Override
    public Course retrieveCourse(int id) {
       TypedQuery<Course> query = entityManager.createQuery("select c from  Course c JOIN FETCH c.reviewsList"+
              " where c.id= :data" , Course.class);
       query.setParameter("data",10);
       Course course = query.getSingleResult();
        return course;
    }

    @Override
    @Transactional
    public Course updateCourseAndReviews(Course course) {
       return entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteCourseAndReviews(int id) {
       Course course= retrieveCourse(id);
       entityManager.remove(course);
    }
}
