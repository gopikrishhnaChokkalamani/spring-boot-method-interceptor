package com.springboot;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyAnnotationAdvisor extends AbstractPointcutAdvisor {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MyMethodInterceptor myMethodInterceptor;

	private transient Pointcut pointCut;

	@Override
	public Pointcut getPointcut() {
		if (pointCut == null) {
			pointCut = AnnotationMatchingPointcut.forMethodAnnotation(MethodLevelAnnotation.class);
		}
		return pointCut;
	}

	@Override
	public Advice getAdvice() {
		// TODO Auto-generated method stub
		return this.myMethodInterceptor;
	}
}
