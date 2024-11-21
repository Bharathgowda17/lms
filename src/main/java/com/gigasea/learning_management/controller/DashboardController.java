package com.gigasea.learning_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard"; // Maps to dashboard.html
    }
/*
    @GetMapping("/students")
    public String showStudents() {
        return "students"; // Maps to students.html
    }

    @GetMapping("/courses")
    public String showCourses() {
        return "courses"; // Maps to courses.html
    }

    @GetMapping("/attendance")
    public String showAttendance() {
        return "markAttendance"; // Maps to markAttendance.html
    }

    @GetMapping("/results")
    public String showResults() {
        return "viewResults"; // Maps to viewResults.html
    }

    @GetMapping("/mcq-test")
    public String showMCQTest() {
        return "takeMCQTest"; // Maps to TakeMCQTest.html
    }*/
}

