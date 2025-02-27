package com.onlinebookshop.shop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
 
@Aspect //this is spring aspect
@Component //register this aspect as a spring bean
public class LoggingAspect {
	//service package -> services
	//before the methods get called
	//print (Logging -> 
	// (* -> tells any return type
	//service.* -> any class inside the service package
	//.*(..)) -> any method inside the class, (..) -> any parameters
//	@Before("execution(* com.onlinebookshop.shop.service.*   .*(..))")
//	public void beforeServiceMethod() {
//		System.out.println("-----Logging from aspect: Method called in service layer---");	
//	}
	//service classes -> before any actual method, this advice will execute
 
 
	
	@Around("execution(* com.onlinebookshop.shop.service.*.*(..))")
	public Object aroundServiceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		System.out.println("----Logging : Method execution time " + joinPoint.getSignature().getName() + " executed in : " + (endTime - startTime));
		return result;
	}

	
	// @AfterReturning 
    @AfterReturning(pointcut = "execution(* com.onlinebookshop.shop.service.*.*(..))", returning = "result")
    public void afterReturningServiceMethod(Object result) {
        System.out.println("------- Logging from AfterReturning aspects : Method returned with value: " + result + " ---------");
    }
 
    // @AfterThrowing
    @AfterThrowing(pointcut = "execution(* com.onlinebookshop.shop.service.*.*(..))", throwing = "exception")
    public void afterThrowingServiceMethod(Throwable exception) {
        System.out.println("------- Logging from AfterThrowing aspects : Method threw exception: " + exception.getMessage() + " ---------");
    }
	
}