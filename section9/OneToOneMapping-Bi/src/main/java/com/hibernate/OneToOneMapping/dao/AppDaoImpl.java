package com.hibernate.OneToOneMapping.dao;

import com.hibernate.OneToOneMapping.entity.Instructor;
import com.hibernate.OneToOneMapping.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        entityManager.merge(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class,id);
        return instructor;
    }

//    @Override
//    @Transactional
//    public void DeleteInstructorByiD(int id) {
//        Instructor instructor = entityManager.find(Instructor.class,id);
//        entityManager.remove(instructor);
//
//    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class,id);
        return instructorDetail;
    }

    @Override
    @Transactional
    public void deleteInstructorDetailOnly(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class,id);
        // remove the associated object reference
        // break bi-directional link
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);

    }

}
