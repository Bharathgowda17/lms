package com.gigasea.learning_management.controller;

import com.gigasea.learning_management.service.AttendanceService;
import com.gigasea.learning_management.service.StudentService;
import com.gigasea.learning_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Controller
public class AdminController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private AttendanceService attendanceService;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/adminPanel")
    public String showAdminPanel(Model model) {
        model.addAttribute("message", "");
        return "adminPanel";
    }

    @Transactional
    @PostMapping("/admin/clearData")
    public String clearData(Model model) {
        attendanceService.deleteAllAttendances();
        studentService.deleteAllStudents();
        courseService.deleteAllCourses();
        // Reset Auto-Increment IDs
        entityManager.createNativeQuery("ALTER TABLE student AUTO_INCREMENT = 1").executeUpdate();
        entityManager.createNativeQuery("ALTER TABLE course AUTO_INCREMENT = 1").executeUpdate();
        model.addAttribute("message", "All data cleared and IDs reset successfully.");
        return "adminPanel";
    }
}
