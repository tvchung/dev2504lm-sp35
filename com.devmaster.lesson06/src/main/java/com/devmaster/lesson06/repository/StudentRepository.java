package com.devmaster.lesson06.repository;

import com.devmaster.lesson06.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
