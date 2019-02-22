package com.bage.study.micro.services.zuul.dynamix.routes.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 参考
 * @author luruihua
 *
 */
@Aspect
@Component
public class UserAspect {

	@Pointcut("execution(* com.bage.study.micro.services.organization.user.controller..*.*(..))")
	public void pointcutControllerMethods(){
		
	}
	
	@Before("pointcutControllerMethods()")
	public void before(){
		System.out.println("before() is work");
	}
	
	@After("pointcutControllerMethods()")
	public void after(){
		System.out.println("after() is work");
	}
	
	@Around("pointcutControllerMethods()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around() is work -- 1");
		Object retVal = pjp.proceed();
        // stop stopwatch
		// Logger.log("com.bage.advice.Example.doBasicProfilingAround(ProceedingJoinPoint pjp) stop stopwatch is work");
		System.out.println("around() is work -- 2");

        return retVal;
	}
	
	@AfterThrowing("pointcutControllerMethods()")
	public void afterThrowing(){
		System.out.println("afterThrowing() is work");
	}
	
	@AfterReturning("pointcutControllerMethods()")
	public void afterReturning(){
		System.out.println("afterReturning() is work");
	}
	
}
