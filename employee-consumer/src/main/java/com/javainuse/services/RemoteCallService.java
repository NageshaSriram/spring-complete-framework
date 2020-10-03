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
@FeignClient(name="employee-producer")
public interface RemoteCallService {
	@RequestMapping(method=RequestMethod.GET, value="/employee")
	public Employee getData();
}
