package com.crudStudent.CrudOperation.DAO;

import com.crudStudent.CrudOperation.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
//Transactional annotations are used at the time when you are trying to modify , or update data
    @PersistenceContext
    private EntityManager entityManager;
    //Create Operation
    @Override
    @Transactional
    public void save(Student thestudent) {
        entityManager.persist(thestudent);
    }
    //Read operation
    @Override
    public Student read(int id) {
      Student student =  entityManager.find(Student.class,id);
      return student;
    }
    //Read operation
    @Override
    public List<Student> readAllStudents() {
        TypedQuery<Student> studentTypedQuery = entityManager.
                createQuery("FROM Student",Student.class);
        List<Student> studentList = studentTypedQuery.getResultList();
        return studentList;
    }
    //Read operation
    @Override
    public List<Student> findStudentByLastname() {
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery
                ("FROM Student where last_name='Singh'", Student.class);
        List<Student> studentList = studentTypedQuery.getResultList();
        return studentList;
    }
    //Read operation
    @Override
    public List<Student> findStudentusingLikeOperator() {
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery
                ("From Student where email LIKE '%luv2code.com'", Student.class);
        List<Student> studentList = studentTypedQuery.getResultList();
        return studentList;
    }
    //Read operation
    @Override
    public List<Student> findStudentusingNamedOperator(String firstname) {
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery
                ("From Student where first_name=:fistname", Student.class);
        studentTypedQuery.setParameter("fistname",firstname);
        List<Student> studentList = studentTypedQuery.getResultList();
        return studentList;
    }
    //Read operation
    //Hibernate implementation is leninent and allows Hibernate Query Language
    //For select JPQL "select" query is required so I am using it here.
    @Override
    public List<Student> findStudentusingSelectClause() {
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery
                ("Select s From Student s where s.first_name LIKE '%it%'", Student.class);
        List<Student> studentList = studentTypedQuery.getResultList();
        return studentList;
    }
///Update Operation
    @Override
    @Transactional
    public Student updateLastnameOfStudent() {
     Student student = entityManager.find(Student.class,6);
        student.setLast_name("Gadhi");
        return student;
    }
//Delete Operation
    @Override
    @Transactional
    public String deleteStudentOfID() {
        Student student = entityManager.find(Student.class,7);
        entityManager.remove(student);
        return student.toString()+"--->this got delted ";
    }
}
