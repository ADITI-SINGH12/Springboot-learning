package com.crudStudent.CrudOperation.DAO;

import com.crudStudent.CrudOperation.Entity.Student;

import java.util.List;

public interface StudentDAO {
    public void save(Student thestudent);
    public Student read(int id);
    public List<Student> readAllStudents();
    public List<Student> findStudentByLastname();
    public List<Student> findStudentusingLikeOperator();
    public List<Student> findStudentusingNamedOperator(String s);
    public List<Student> findStudentusingSelectClause();
    public Student updateLastnameOfStudent();
    public String deleteStudentOfID();

}


