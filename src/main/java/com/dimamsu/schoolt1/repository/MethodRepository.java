package com.dimamsu.schoolt1.repository;

import com.dimamsu.schoolt1.model.Method;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MethodRepository extends JpaRepository<Method, Long> {

    @Query("SELECT m FROM Method m")
    List<Method> findAllMethods();

    Optional<Method> findByClassNameAndMethodName(String className, String methodName);

    List<Method> findMethodByMethodName(String methodName);

    @Query("SELECT m.methodName FROM Method m")
    List<String> findAllMethodNames();

}