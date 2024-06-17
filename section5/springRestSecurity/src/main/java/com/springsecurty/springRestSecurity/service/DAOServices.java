package com.springsecurty.springRestSecurity.service;


import com.springsecurty.springRestSecurity.entity.Employee;


import java.util.List;

public interface DAOServices {
    public Employee employeeByID(int id);
    public List<Employee> findAll();
    public Employee CreateNewEmployee(Employee employee);
    Employee deleteEmployee(int id);
}
