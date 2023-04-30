package com.example.demo.ServiceImplementation;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Employee;
import com.example.demo.Repo.EmployeeRepo;
import com.example.demo.Service.EmployeeService;

//service annotation to let system create object of it when required.
@Service
public class EmployeeServiceImpl implements EmployeeService
{

	EmployeeRepo employeeRepo;

	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {

		this.employeeRepo = employeeRepo;
	}
	// repository object created to use JPA methods using constructor Injection.

//	@Autowired
//	EmployeeRepo employeeRepo;

	// or we can create repository object using @Autowired annotation as well.

	@Override
	public Employee createEmployee(Employee employee)
	{
		Employee emp = employeeRepo.save(employee);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee()
	{
		List<Employee> list = employeeRepo.findAll();
		return list;
	}

	@Override
	public Employee getEmployeeById(int id)
	{
		return employeeRepo.findById(id).orElseThrow(()-> new NoSuchElementException());
	}

	@Override
	public Employee updateEmployee(Employee employee)
	{
		Employee save = employeeRepo.save(employee);
		return save;
	}

	@Override
	public void deleteEmployee(int id)
	{
		employeeRepo.deleteById(id);
	}

}
