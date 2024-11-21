package com.gigasea.learning_management.controller;

import com.gigasea.learning_management.model.TrainingFeedback;
import com.gigasea.learning_management.repository.TrainingFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class TrainingFeedbackController {

    @Autowired
    private TrainingFeedbackRepository trainingFeedbackRepository;

    // Show the feedback form page
    @GetMapping("/training-feedback")
    public String showFeedbackFormPage() {
        return "Feedback"; // Maps to trainingFeedback.html
    }

    // Submit feedback form
    @PostMapping("/submit-feedback")
    public String submitFeedback(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("session") String session,
            @RequestParam("feedback") String feedbackText,
            @RequestParam("report") MultipartFile reportFile) {

        // Log input data (Optional for debugging)
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Session: " + session);
        System.out.println("Feedback: " + feedbackText);
        System.out.println("File Name: " + reportFile.getOriginalFilename());

        // Create a new feedback object
        TrainingFeedback feedback = new TrainingFeedback();
        feedback.setName(name);
        feedback.setEmail(email);
        feedback.setSession(session);
        feedback.setFeedbackText(feedbackText);

        // Handle the uploaded file
        if (!reportFile.isEmpty()) {
            String fileName = reportFile.getOriginalFilename();
            feedback.setReportFileName(fileName);

            try {
                // Save the uploaded report file
                Path uploadDir = Paths.get("feedback_uploads");
                if (!Files.exists(uploadDir)) {
                    Files.createDirectories(uploadDir);
                }
                Path filePath = uploadDir.resolve(fileName);
                reportFile.transferTo(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Save feedback to the database
        trainingFeedbackRepository.save(feedback);

        // Redirect to the "Thank You" page
        return "redirect:/thank-you";
    }

    // Show the thank-you page after feedback submission
    @GetMapping("/thank-you")
    public String showThankYouPage() {
        return "thankYou"; // Maps to thankYou.html
    }

    // View all feedback submissions (Optional)
    @GetMapping("/view-feedbacks")
    public String viewFeedbacks(Model model) {
        model.addAttribute("feedbacks", trainingFeedbackRepository.findAll());
        return "viewFeedback"; // Maps to viewFeedbacks.html
    }

    // Download report file (Optional)
    @GetMapping("/download-report/{fileName}")
    public ResponseEntity<Resource> downloadReportFile(@PathVariable String fileName) {
        try {
            Path filePath = Paths.get("feedback_uploads").resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_PDF)
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    // Delete a feedback submission (Optional)
    @PostMapping("/delete-feedback")
    public String deleteFeedback(@RequestParam("id") Long id) {
        trainingFeedbackRepository.deleteById(id);
        return "redirect:/view-feedbacks";
    }
}
