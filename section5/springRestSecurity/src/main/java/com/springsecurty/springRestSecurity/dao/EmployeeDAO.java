package com.springsecurty.springRestSecurity.dao;


import com.springsecurty.springRestSecurity.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public Employee findById(int id);
    public List<Employee> showAllEmployee();
    public Employee CreateNewEmployee(Employee employee);
    public Employee deleteEmployee(int id);
}
