package com.sanguk.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
public class ExeTimeAspect {
// ┌ execution : 접근자 반환형 패키지/클래스*메소드(인자)
@Pointcut("within(com.sanguk..*)")
    private void publicTarget(){        
    }
    
    @Around("publicTarget()")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.nanoTime();
        try{
            Object result = joinPoint.proceed();
            return result;
        }finally{
            long finish=System.nanoTime();
            Signature sig = joinPoint.getSignature();
            log.info("ExeTimeAspect2 : "+joinPoint.getTarget().getClass().getSimpleName()+"."+sig.getName()+"("+Arrays.toString(joinPoint.getArgs())+") 실행 시간 : "+(finish-start)+" ns\n");   
        } //end try-finally
    } //end measure()
}

