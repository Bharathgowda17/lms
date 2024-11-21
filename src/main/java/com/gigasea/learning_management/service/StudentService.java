package com.gigasea.learning_management.service;

import com.gigasea.learning_management.model.Student;
import java.util.List;

public interface StudentService {
    void saveStudent(Student student);
    List<Student> findStudents();
    Student getStudentId(Long id);
    void deleteStudent(Long id);
    void deleteAllStudents(); // Add this method
    void addCourseToStudent(Long studentId, Long courseId);
}
