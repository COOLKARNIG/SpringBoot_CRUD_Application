package com.example.demo.Service;

import java.util.List;
import com.example.demo.Model.Employee;

public interface EmployeeService
{
 public Employee createEmployee(Employee employee);
 
 public List<Employee> getAllEmployee();
 
 public Employee getEmployeeById(int id);
 
 public Employee updateEmployee(Employee employee);
 
 public void deleteEmployee(int id);
 
}
