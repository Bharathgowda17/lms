package com.gigasea.learning_management.controller;

import com.gigasea.learning_management.model.Student;
import com.gigasea.learning_management.model.Course;
import com.gigasea.learning_management.service.StudentService;
import com.gigasea.learning_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", studentService.findStudents());
        return "students";
    }

    @GetMapping("/registerStudent")
    public String registerStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "registerStudent";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/updateStudent/{id}")
    public String updateStudent(Model model, @PathVariable Long id) {
        Student student = studentService.getStudentId(id);
        model.addAttribute("student", student);
        return "updateFormStudent";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/assignCourse")
    public String showAssignCourseForm(Model model) {
        List<Course> courses = courseService.findCourses();
        model.addAttribute("courses", courses);
        return "assignCourse";
    }

    @PostMapping("/addCourseToStudent")
    public String addCourseToStudent(@RequestParam Long studentId, @RequestParam Long courseId) {
        studentService.addCourseToStudent(studentId, courseId);
        return "redirect:/students";
    }

    @GetMapping("/studentsWithCourses")
    public String studentsWithCourses(Model model) {
        List<Student> students = studentService.findStudents();
        model.addAttribute("students", students);
        return "studentsWithCourses";
    }


}
