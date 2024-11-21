package com.gigasea.learning_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gigasea.learning_management.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
