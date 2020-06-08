package com.springboot;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

@Component
public class MyMethodInterceptor implements MethodInterceptor {

	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		Object targetObject = invocation.getThis();

		Class<?> targetClass = AopProxyUtils.ultimateTargetClass(targetObject);

		if (targetClass == null) {
			targetClass = targetObject.getClass();
		}

		Method method = invocation.getMethod();

		MethodLevelAnnotation policyAnnotation = method.getAnnotation(MethodLevelAnnotation.class);

		if (policyAnnotation == null) {
			method = AopUtils.getMostSpecificMethod(method, targetClass);
			policyAnnotation = method.getAnnotation(MethodLevelAnnotation.class);
		}

		String expressionName = Optional.ofNullable(policyAnnotation.value()).orElse(null);
		

		ExpressionParser expressionParser = new SpelExpressionParser();

		StandardEvaluationContext context = new StandardEvaluationContext();

		Map<String, Object> rootMap = new ConcurrentHashMap<>();

		Map<String, Object> map = applicationContext.getBeansWithAnnotation(ClassLevelAnnotation.class);

		Collection<Object> stores = map.values();

		String name = null;
		for (Object obj : stores) {
			ClassLevelAnnotation clant = obj.getClass().getAnnotation(ClassLevelAnnotation.class);
			name = clant.value();
			rootMap.put(name, obj);
		}

		context.setVariables(rootMap);

		Expression expression = expressionParser.parseExpression(expressionName);

		if (!expression.getValue(context, boolean.class))
			throw new Exception();

		System.out.println("Inside Method Interceptor");
		return invocation.proceed();
	}
}
