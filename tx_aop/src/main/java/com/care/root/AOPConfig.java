package com.care.root;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.reflect.MethodSignature;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AOPConfig {
	@Around("execution(public String buy_form(..))")
	public void commonAop(ProceedingJoinPoint joinpoint) {
		try {
			System.out.println("==== 컨트롤러 공통기능 시작 ====");
			joinpoint.proceed();
			System.out.println("==== 컨트롤러 공통기능 종료 ====");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Before("execution(* com.care.root.service.TestServiceImpl.buy(..))")
	public void commonAop02() {
		System.out.println("==== service 공통 기능(buy) 시작====");
	}

	@After("execution(* com.care.root.service.TestServiceImpl.dbResult(..))")
	public void commonAop03() {
		System.out.println("==== service 공통 기능(db_result) 종료====");
	}

	Logger LOG = Logger.getGlobal();

	@Around("execution(* com.care.root.controller.*.*(..))")
	public Object commonAop00(ProceedingJoinPoint joinpoint) {
		MethodSignature methodSignature = (MethodSignature) joinpoint.getSignature();
		Method method = methodSignature.getMethod();
		Object[] objects = joinpoint.getArgs();
		for (Object param : objects) {
			LOG.log(Level.INFO, "들어온 파라미터 값 : " + param);
		}
		LOG.log(Level.INFO, "실행된 메소드 : " + method.getName());
		Object obj = null;
		try {
			obj = joinpoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;
	}
}
