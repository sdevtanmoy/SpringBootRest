/**
 * 
 */
package com.mongo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author ibm
 *
 */

/**
 * Static - Compile Time
 * Aspect - It is the concern that we are trying to implement(Logging Service)
 * Joint Point - The point to action taken. (Service/ methods)
 * Point cut - expression of executing the advice (execution(* com.ibm.service.Classname.*(..)))
 * Advice - The actual action taken by an aspect at a particular join point
 * 
 * Dynamic - Runtime
 * Joint Point - 
 * Weaving - 
 */
@Aspect
@Component
public class LoggingServiceAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggingServiceAspect.class);
	
	@Pointcut("execution(* com.mongo.*.*.*(..))")
	private void generalPointcut(){
		
	}
	
	@Before("generalPointcut()")
	public void infoLog(JoinPoint joinPoint){
		logger.info(joinPoint.getTarget().getClass().getSimpleName()+ " : "
				+joinPoint.getSignature().getName());
	}
	
	@AfterThrowing(pointcut = "generalPointcut() throws Exception", throwing="ex")
	public void exceptionLog(JoinPoint joinPoint, Exception ex) throws Exception{
		logger.error(joinPoint.getTarget().getClass().getSimpleName()+ " : "
				+joinPoint.getSignature().getName()+" : "+ex.getMessage());
	}
}


