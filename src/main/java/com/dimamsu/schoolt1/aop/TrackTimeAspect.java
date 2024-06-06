package com.dimamsu.schoolt1.aop;

import com.dimamsu.schoolt1.exception.InternalServerException;
import com.dimamsu.schoolt1.service.TimeTrackingService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class TrackTimeAspect {
    private final TimeTrackingService timeTrackingService;

    @Around("@annotation(com.dimamsu.schoolt1.aop.TrackTime)")
    public Object trackExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        boolean exp = false;
        long start = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();
        log.info("Method {} start executed with arguments {}",methodName,methodArgs);
        try {
            Object proceed = joinPoint.proceed();
            return proceed;
        } catch (Throwable e) {
            exp = true;
            throw new InternalServerException(e.getMessage());
        } finally {
            if (!exp) {
                long executionTime = System.currentTimeMillis() - start;
                timeTrackingService.saveTimeTracking(executionTime, joinPoint);
                log.info("Method {} success finish executed for {} ms", methodName, executionTime);
            }
        }
    }
}
