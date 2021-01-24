/**
 * 
 */
package com.javainuse.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nageshasriramappa
 *
 */

@RestController
public class UserController {

	@RequestMapping(value = "/userDetails.html", method = RequestMethod.GET)
	public String userDetails() {
		return ("redirect:/userDetails.html");

	}
}
