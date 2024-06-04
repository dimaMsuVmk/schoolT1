package com.dimamsu.schoolt1.service;

import com.dimamsu.schoolt1.dto.AllMethodNamesResult;
import com.dimamsu.schoolt1.dto.AllTimeTrackingResult;
import com.dimamsu.schoolt1.dto.TimeTrackingResult;
import org.aspectj.lang.ProceedingJoinPoint;
import com.dimamsu.schoolt1.model.Method;

import java.util.Optional;

public interface TimeTrackingService {
    /**
     * Сохраняет в БД время выполнения и информацию о методе
     * @param executionTime Время выполнения метода в миллисекундах.
     * @param joinPoint     {@link ProceedingJoinPoint}, инф-я о выполненном методе
     * @throws RuntimeException В случае ошибки при сохранении данных отслеживания времени.
     */
    void saveTimeTracking(long executionTime, ProceedingJoinPoint joinPoint);


    /**
     * Возвращает данные отслеживания времени для методов с указанным именем.
     * @param methodName Имя методов, для которых необходимо получить данные отслеживания времени.
     * @return TimeTrackingResult, содержащий данные отслеживания времени для найденных методов.
     */
    AllTimeTrackingResult getTimeTracking(String methodName);

    /**
     * Ищет метод с указанными именем класса и именем метода.
     * @param className Имя класса, к которому принадлежит метод.
     * @param methodName Имя метода, который необходимо найти.
     * @return Optional<Method>, содержащий метод, если он найден, или пустой Optional, если метод не найден.
     */
    Optional<Method> getMethod(String className, String methodName);

    /**
     * Возвращает все последнее время выполение для всех методов.
     * @return AllTimeTrackingResult, содержащий список TimeTrackingResult для всех методов с их последним временем выполнения.
     */
    AllTimeTrackingResult getInfoTimeMethods();

    /**
     * Возвращает список имен всех методов, хранящихся в хранилище.
     * @return AllMethodResult, содержащий список имен всех методов.
     */
    AllMethodNamesResult getAllMethods();
}