package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Employee;
import com.example.demo.Service.EmployeeService;

@RestController
public class EmployeeController
{
	EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {

		this.employeeService = employeeService;
	}
	// object created using Constructor Injection.

//	@Autowired
//	EmployeeService employeeService;

	/*
	 * EmployeeService is Interface so object cannot be created. So it will refer
	 * the implementing class's objects (i.e. EmployeeServiceImpl)
	 */

//	@GetMapping("/getAllEmployee")
//	public List<Employee> getAllEmployee()
//	{
//		return employeeService.getAllEmployee();
//	}
	
	@GetMapping(value = "getAllEmployee",produces = "application/xml")
	public List<Employee> getAllEmployee()
	{
		return employeeService.getAllEmployee();
	}
	
	/*
	 * response from postman as xml format
	 * <List>
    <item>
        <id>1</id>
        <firstName>Prasad</firstName>
        <lastName>Waghmare</lastName>
        <email>Prasad@gmail.com</email>
    </item>
    <item>
        <id>2</id>
        <firstName>Gaurav</firstName>
        <lastName>Kulkarni</lastName>
        <email>gaurav@gmail.com</email>
    </item>
    <item>
        <id>5</id>
        <firstName>Jaggu</firstName>
        <lastName>Paul</lastName>
        <email>jaggu@gmail.com</email>
    </item>
    <item>
        <id>6</id>
        <firstName>shahbaj</firstName>
        <lastName>sayyad</lastName>
        <email>jadoo@gmail.com</email>
    </item>
</List>
	 * 
	 * */
	 

	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable int id)
	{
		return employeeService.getEmployeeById(id);
	}

//	@PostMapping("/createEmployee")
//	public Employee createEmployee(@RequestBody Employee employee)
//	{
//		return employeeService.createEmployee(employee);
//	}

	@PostMapping(path = "createEmployee", consumes = "application/json")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		return employeeService.createEmployee(employee);
	}

	/*http://localhost:8080/createEmployee {post} postman format
	 * <Employee> 
		 * <firstName>Jaggu</firstName>
		 *  <lastName>Paul</lastName>
		 * <email>jaggu@gmail.com</email> 
	 * </Employee>/*
	 */

	@PutMapping("/updateEmployee/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee)
	{
		Employee existingEmployee = employeeService.getEmployeeById(id);

		if (existingEmployee != null)
		{
			existingEmployee.setFirstName(employee.getFirstName());
			existingEmployee.setLastName(employee.getLastName());
			existingEmployee.setEmail(employee.getEmail());

			return employeeService.updateEmployee(existingEmployee);
		} else
		{
			return null;
		}
	}

	@DeleteMapping("deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id)
	{
		employeeService.deleteEmployee(id);
		return "Deleted !";
	}
}
