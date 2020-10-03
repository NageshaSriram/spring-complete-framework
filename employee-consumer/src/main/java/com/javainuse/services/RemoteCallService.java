/**
 * 
 */
package com.javainuse.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javainuse.model.Employee;

/**
 * @author nageshasriramappa
 *
 */
//@FeignClient(name="employee-producer")
@FeignClient(name="EMPLOYEE-ZUUL-SERVICE")
public interface RemoteCallService {
//	@RequestMapping(method=RequestMethod.GET, value="/employee")
	@RequestMapping(method=RequestMethod.GET, value="/producer/employee")
	public Employee getData();
}
