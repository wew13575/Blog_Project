package com.sanguk.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import lombok.extern.log4j.Log4j;

/**
 * AOP 처리 클래스입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */

@Aspect
@Log4j
public class ExeTimeAspect {

    
    @Pointcut("within(com.sanguk..*)")
    private void publicTarget() {
    }

    /**
     * 
     * @param joinPoint
     * @return Exetime
     * @throws Throwable
     */
    @Around("publicTarget()")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        try {
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long finish = System.nanoTime();
            Signature sig = joinPoint.getSignature();
            log.info("ExeTimeAspect2 : " + joinPoint.getTarget().getClass().getSimpleName() + "." + sig.getName() + "("
                    + Arrays.toString(joinPoint.getArgs()) + ") 실행 시간 : " + (finish - start) + " ns\n");
        }
    }
}
