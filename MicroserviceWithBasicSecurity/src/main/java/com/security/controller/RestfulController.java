package com.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.Employee;

@RestController
/**
 * 
 * @author skar
 *
 */
public class RestfulController {
	
	@RequestMapping("/employee")
	Employee getEmployee(){
		Employee e = new Employee(1, "Santosh");
		return e;
	}
}

