package com.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LogAspect {

    @Before("execution(* com.bean.*.*(..))")
    public void log(JoinPoint joinPoint) {
        System.out.println("Logging for: "
        + joinPoint.getSignature().getName()
        + " on instance "
        + joinPoint.getTarget().getClass().getName());
    }

//    @Around("@annotation(com.aspects.Monitor)")
   @Around("@within(org.springframework.stereotype.Service) || @within(org.springframework.stereotype.Repository) || @within(org.springframework.stereotype.Component)")
    public Object calculateExecTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        StopWatch watch = new StopWatch();
        watch.start();

        try{
            System.out.println("Arguments: " + proceedingJoinPoint.getArgs());
            Object result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
            watch.stop();
            System.out.println("Exec time for: "+ proceedingJoinPoint.getSignature().getName());
            System.out.println(watch.prettyPrint());
            return result;
        }
        catch(Throwable t){
            throw t;
        }
    }
}
