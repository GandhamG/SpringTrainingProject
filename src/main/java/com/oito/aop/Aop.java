package com.oito.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class Aop {

	@Before("execution(* com.oito.department.controller.DepartmentController.getById(..))")
	public void logBefore() {

		log.info("@Before is called");

	}

	// any methods under controller package(single advice to multiple points)
	@Before("execution(* com.oito.employee.controller.*.*(..))")
	public void anyMethod() {

		log.info("@Before anyMethod is called");

	}

	@Pointcut("execution(* com.oito.employee.dao.vo.EmployeeVO.get*())") // Declaring a Pointcut
	public void allGetters() {
		log.info("point cut");
	}

	@Pointcut("execution(* com.oito.employee.dao.vo.EmployeeVO.set*())")
	public void allSetters() {
		log.info("point cut");
	}

	@Order(value = 1)
	@After("execution(* com.oito.department.controller.DepartmentController.getById(..))")
	public void logAfter1() {

		log.info("@After one is called");

	}

	@After("execution(* com.oito.department.controller.DepartmentController.getById(..))")
	public void logAfter() {
		log.info("@After  is called");

	}

	@Around("@annotation(com.oito.aop.annotation.TrackExecutionTime)")
	public Object computeExecutionTime(final ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("around before is running");
		log.info(joinPoint.getKind()); // returns method-execution
		log.info(joinPoint.getTarget().getClass().toString()); // returns class name
		// Object[] arg=joinPoint.getArgs(); // returns method inputs
		final long start = System.currentTimeMillis();
		final Object proceed = joinPoint.proceed(); // will call business method

		log.info("around after is running");
		final long executionTime = System.currentTimeMillis() - start;
		final String message = joinPoint.getSignature().getName() + " executed in " + executionTime + " ms";
		log.info(message);
		return proceed;
	}

	@AfterReturning(pointcut = "execution(* com.oito.employee.controller.EmployeeController.*(..))", returning = "returnedValue")
	public void logResultsAfteReturning(final JoinPoint joinpoint, final Object returnedValue) {
		log.info("@AfterReturning is running");
		log.info("Execution completed for " + joinpoint.getSignature().getName());
		log.info("Value being returned is " + returnedValue.toString());
	}

	@AfterThrowing(pointcut = "execution(* com.oito.employee.controller.EmployeeController.getById(..))", throwing = "exception")
	public void logResultsAfterError(final JoinPoint joinpoint, final Throwable exception) {
		log.info("@AfterThrowing is running");
		log.info("Execution completed for " + joinpoint.getSignature().getName());
		log.info("Error in Join Point due to : " + exception.getMessage());
		log.info("Advice complete");

	}
}
