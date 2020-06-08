package com.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

	@GetMapping
	//@MethodLevelAnnotation("#checkClassLevelAnnotation.isValid(#p0.accountId)")
	//p0 -> first parameter
	//. -> element inside the parameter
	@MethodLevelAnnotation("#checkClassLevelAnnotation.isValid()")
	public String getMethod() {
		System.out.println("Inside Sample Controller");
		return "hello, there!!!";
	}
}