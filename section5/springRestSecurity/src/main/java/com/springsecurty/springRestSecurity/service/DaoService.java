package com.springsecurty.springRestSecurity.service;


import com.springsecurty.springRestSecurity.dao.EmployeeDAO;
import com.springsecurty.springRestSecurity.entity.Employee;
import com.springsecurty.springRestSecurity.exception.EmployeeNotFoundException;
import com.springsecurty.springRestSecurity.service.DaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaoService implements DAOServices {
private EmployeeDAO employeeDAO;

    @Autowired
    public DaoService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee employeeByID(int id){
        return employeeDAO.findById(id);
    }

    @Override
    public List<Employee> findAll(){
        return employeeDAO.showAllEmployee();
    }

    @Override
    public Employee CreateNewEmployee(Employee employee) {
        return employeeDAO.CreateNewEmployee(employee);
    }

    @Override
    public Employee deleteEmployee(int id) {
        return employeeDAO.deleteEmployee(id);
    }
}

