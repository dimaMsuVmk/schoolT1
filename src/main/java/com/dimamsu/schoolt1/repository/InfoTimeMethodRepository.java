package com.dimamsu.schoolt1.repository;

import com.dimamsu.schoolt1.model.InfoTimeMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoTimeMethodRepository extends JpaRepository<InfoTimeMethod, Long> {
}
