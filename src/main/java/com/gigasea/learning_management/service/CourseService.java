package com.gigasea.learning_management.service;

import com.gigasea.learning_management.model.Course;
import java.util.List;

public interface CourseService {
    void saveCourse(Course course);
    List<Course> findCourses();
    Course getCourseId(Long id);
    void deleteCourse(Long id);
    void deleteAllCourses(); // New method
}
