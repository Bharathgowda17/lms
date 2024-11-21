package com.gigasea.learning_management.repository;



import com.gigasea.learning_management.model.TrainingFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingFeedbackRepository extends JpaRepository<TrainingFeedback, Long> {
}
