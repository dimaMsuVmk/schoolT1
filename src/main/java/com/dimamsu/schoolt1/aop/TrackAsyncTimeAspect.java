package com.dimamsu.schoolt1.aop;

import com.dimamsu.schoolt1.exception.InternalServerException;
import com.dimamsu.schoolt1.service.TimeTrackingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
@EnableAsync
public class TrackAsyncTimeAspect {
    private final TimeTrackingService timeTrackingService;

    @Around("@annotation(com.dimamsu.schoolt1.aop.TrackAsyncTime)")
    public Object trackExecutionAsyncTime(ProceedingJoinPoint joinPoint) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        return CompletableFuture.supplyAsync(() -> {
                    try {
                        log.info("Асинхронный запуск TrackAsyncTimeAspect");
                        return joinPoint.proceed();
                    } catch (Throwable e) {
                        throw new InternalServerException(e.getMessage());
                    }
                })
                .thenApply(result -> {
                    long endTime = System.currentTimeMillis();
                    long executionTime = endTime - startTime;
                    timeTrackingService.saveTimeTracking(executionTime, joinPoint);
                    log.info("Method {} executed async in {} ms", joinPoint.getSignature(), executionTime);
                    return result;
                })
                .exceptionally(e -> {
                    log.error("Ошибка trackExecutionAsyncTime", e);
                    throw new InternalServerException(e.getMessage());
                }).get();
    }
}
