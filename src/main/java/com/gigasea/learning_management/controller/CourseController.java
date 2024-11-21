package com.gigasea.learning_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.gigasea.learning_management.model.Course;
import com.gigasea.learning_management.service.CourseService;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String courses(Model model) {
        model.addAttribute("courses", courseService.findCourses());
        return "courses";
    }

    @GetMapping("/registerCourse")
    public String registerCourse(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "registerCourse";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/updateCourse/{id}")
    public String updateCourse(Model model, @PathVariable Long id) {
        Course course = courseService.getCourseId(id);
        model.addAttribute("course", course);
        return "updateFormCourse";
    }

    @GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }
}
