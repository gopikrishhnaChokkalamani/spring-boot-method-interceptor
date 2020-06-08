package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringBootMethodInterceptorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMethodInterceptorApplication.class, args);
	}
}