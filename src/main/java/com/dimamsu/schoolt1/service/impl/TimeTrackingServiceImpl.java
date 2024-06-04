package com.dimamsu.schoolt1.service.impl;

import com.dimamsu.schoolt1.dto.AllMethodNamesResult;
import com.dimamsu.schoolt1.dto.AllTimeTrackingResult;
import com.dimamsu.schoolt1.dto.TimeTrackingResult;
import com.dimamsu.schoolt1.mapper.MethodMapper;
import com.dimamsu.schoolt1.model.InfoTimeMethod;
import com.dimamsu.schoolt1.model.Method;
import com.dimamsu.schoolt1.repository.InfoTimeMethodRepository;
import com.dimamsu.schoolt1.repository.MethodRepository;
import com.dimamsu.schoolt1.service.TimeTrackingService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TimeTrackingServiceImpl implements TimeTrackingService {
    private final InfoTimeMethodRepository infoRepository;
    private final MethodRepository methodRepository;
    private final MethodMapper methodMapper;

    @Override
    public void saveTimeTracking(long executionTime, ProceedingJoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();

        Optional<Method> existingMethod = getMethod(className, methodName);
        Method method = existingMethod.orElseGet(() -> new Method(className, methodName));
        InfoTimeMethod infoTimeMethod = new InfoTimeMethod(executionTime, method);

        infoRepository.save(infoTimeMethod);
        method.getInfoTimeMethods().add(infoTimeMethod);
        methodRepository.save(method);
    }

    @Override
    public Optional<Method> getMethod(String className, String methodName) {
        return methodRepository.findByClassNameAndMethodName(className, methodName);
    }


    @Override
    public AllTimeTrackingResult getTimeTracking(String methodName) {
        return timeUtil(methodRepository.findMethodByMethodName(methodName));
    }


    @Override
    public AllTimeTrackingResult getInfoTimeMethods() {
        return timeUtil(methodRepository.findAllMethods());
    }


    @Override
    public AllMethodNamesResult getAllMethods() {
        return AllMethodNamesResult.builder()
                .methods(methodRepository.findAllMethodNames())
                .build();

    }

    private AllTimeTrackingResult timeUtil(List<Method> methods) {
        List<TimeTrackingResult> response = methods.stream().map(methodMapper::toDto).collect(Collectors.toList());
        return AllTimeTrackingResult.builder()
                .timeTrackingResults(response)
                .build();
    }

}