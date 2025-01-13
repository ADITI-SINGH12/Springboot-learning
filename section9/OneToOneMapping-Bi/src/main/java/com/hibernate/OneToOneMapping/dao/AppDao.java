package com.hibernate.OneToOneMapping.dao;

import com.hibernate.OneToOneMapping.entity.Instructor;
import com.hibernate.OneToOneMapping.entity.InstructorDetail;

public interface AppDao {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
   // void DeleteInstructorByiD(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailOnly(int id);
}
