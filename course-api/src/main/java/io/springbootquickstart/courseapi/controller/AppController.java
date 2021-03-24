package io.springbootquickstart.courseapi.controller;

import io.springbootquickstart.courseapi.Service.EmployeeService;
import io.springbootquickstart.courseapi.Entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.aspectj.weaver.ast.Var;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class AppController implements ErrorController
{


	
	@Autowired
	EmployeeService repoemp;
	
	@GetMapping("/")
	public ModelAndView findAllProduct(Model model)
	{		
		System.out.println("in model view");

		List EmployeeList = repoemp.getAllEmployee();
		Map<String, Object> params = new HashMap<>();
		
//		params.put("productLists", productList);
		params.put("EmployeeLists", EmployeeList);

		
		return new ModelAndView("index", params);
	}
	
	@PostMapping("/saveemployee")
	public void addEmp(@RequestBody Employee employee) {
		System.out.println("in cont");
		System.out.println("sal - "+employee.getSalary());
		repoemp.addEmployee(employee);

	}

	@ResponseBody
	@RequestMapping(value="/getEmployeeDetails", method=RequestMethod.POST, headers = "Accept=*/*", produces = "application/json")
	public List<Employee> getEmployeeDetails(@RequestParam("employeeIdFromSelect") String empId)
	{	
		System.out.println("in getting update cont - "+empId);
		Map<Object, Object> model = new HashMap<Object, Object>();
		List<Employee> employee = repoemp.getProductInfoByIdForEdit(Long.parseLong(empId));
		System.out.println("result -  "+employee);
		model.put("employee", employee);
		return employee;
	}
	
	@RequestMapping(value = "/updateEmployeeDetails", method = RequestMethod.PUT, headers = "Accept=*/*", produces = "application/json")
	public void updateProductDetails(@RequestBody Employee employee)
	{	
		repoemp.updateEmployeeDetails(employee);
	}
	
	
	@GetMapping("/EmployeeListForReport")
	public List<Employee> getEmployeeListForReport()
	{	
		System.out.println("in list contrl");
		List EmployeeList = repoemp.getAllEmployee();
		System.out.println(EmployeeList);
		return EmployeeList;
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
