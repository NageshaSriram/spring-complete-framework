/**
 * 
 */
package com.javainuse.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author nageshasriramappa
 *
 */
@RestController
public class TestController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public Employee firstPage() {
		System.out.println("First Page");
		
		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);
		
		if(emp.getName().equalsIgnoreCase("emp1"))
			throw new RuntimeException();

		return emp;
	}

	public Employee getDataFallBack() {

		System.out.println("Fall back");
		
		Employee emp = new Employee();
		emp.setName("fallback-emp1");
		emp.setDesignation("fallback-manager");
		emp.setEmpId("fallback-1");
		emp.setSalary(3000);

		return emp;

	}

}
