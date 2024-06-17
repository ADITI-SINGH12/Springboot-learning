package com.employees.EmployeeRestAPI.dao;

import com.employees.EmployeeRestAPI.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee,Integer> {
  /*  public Employee findById(int id);
    public List<Employee> showAllEmployee();
    public Employee CreateNewEmployee(Employee employee);
    public Employee deleteEmployee(int id);*/
}
