package com.crudStudent.CrudOperation.DAO;

import com.crudStudent.CrudOperation.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public void save(Student thestudent) {
        entityManager.persist(thestudent);
    }
}
