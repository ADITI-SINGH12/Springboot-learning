package com.hibernate.OneToOneMapping.dao;

import com.hibernate.OneToOneMapping.entity.Instructor;

public interface AppDao {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void DeleteInstructorByiD(int id);
}
