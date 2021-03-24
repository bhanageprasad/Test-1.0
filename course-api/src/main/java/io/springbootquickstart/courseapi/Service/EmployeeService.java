package io.springbootquickstart.courseapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.springbootquickstart.courseapi.Entity.Employee;
import io.springbootquickstart.courseapi.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository emprepo;
	
	public void addEmployee(Employee employee)
	{
		emprepo.save(employee);		
	}
	
	public List<Employee> getAllEmployee()
	{
		List<Employee>EmployeeList = emprepo.findAll();
		System.out.println("list - "+EmployeeList);
		return EmployeeList;
	}
	
	public List<Employee> getProductInfoByIdForEdit(Long empId)
	{
		List<Employee> employee = emprepo.getEmployeeInfoByIdForEditEmployeeRepo(empId);		
		return employee;
	}
	
	public void updateEmployeeDetails(Employee employee)
	{		
		Employee emp = emprepo.findById(employee.getEmpId()).orElse(null);
		System.out.println("id to be set on  -  "+employee.getEmpId());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setCity(employee.getCity());
		emp.setAge(employee.getAge());
		emp.setSalary(employee.getSalary());
		emp.setDepartment(employee.getDepartment());
		emprepo.save(emp);
	}	
}
