package com.hibernate.ManyToMany.dao;

import com.hibernate.ManyToMany.entity.Course;
import com.hibernate.ManyToMany.entity.Student;
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
    public void createCourseandStudent(Course course) {
        entityManager.persist(course);
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    public Student findCoursefromStudent(int id) {
       TypedQuery<Student> query =  entityManager.createQuery("select s from Student s JOIN FETCH s.courses"
               +" where s.id= :data",Student.class);
       query.setParameter("data",id);
        Student student = query.getSingleResult();
        return student;
    }

    @Override
    public List<Course> findStudentFromCourse(int id) {
        TypedQuery<Course> query =  entityManager.createQuery("select s from Course s JOIN FETCH s.students"
                +" where s.id= :data",Course.class);
        query.setParameter("data",id);
       List<Course> course = query.getResultList();
        return course;
    }

    @Override
    @Transactional
    public void deleteCourseByID(int id) {
        Course course = entityManager.find(Course.class,id);
        entityManager.remove(course);
    }
}
