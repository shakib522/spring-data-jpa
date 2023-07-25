package com.shakib.dataJpa.repository;

import com.shakib.dataJpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
