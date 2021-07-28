package com.codegym.back_end_sprint_2.repository;

import com.codegym.back_end_sprint_2.model.entities.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
}
