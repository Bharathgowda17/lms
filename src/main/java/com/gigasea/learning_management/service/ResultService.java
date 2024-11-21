package com.gigasea.learning_management.service;

import com.gigasea.learning_management.model.Result;
import com.gigasea.learning_management.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public void saveResult(Result result) {
        resultRepository.save(result);
    }

    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }
}
