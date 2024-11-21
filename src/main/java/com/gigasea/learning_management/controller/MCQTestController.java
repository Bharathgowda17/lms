//package com.gigasea.learning_management.controller;
//
//import com.gigasea.learning_management.model.Question;
//import com.gigasea.learning_management.model.Result;
//import com.gigasea.learning_management.service.QuestionService;
//import com.gigasea.learning_management.service.ResultService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@SessionAttributes("selectedOptions")
//public class MCQTestController {
//
//    @Autowired
//    private QuestionService questionService;
//
//    @Autowired
//    private ResultService resultService;
//
//    @GetMapping("/take-mcq-test")
//    public String getMcqTest(Model model, @RequestParam(defaultValue = "0") int q, @RequestParam Map<String, String> params) {
//        List<Question> questions = questionService.getAllQuestions();
//        if (questions.isEmpty()) {
//            model.addAttribute("error", "No questions available.");
//            return "error";
//        }
//        model.addAttribute("question", questions.get(q));
//        model.addAttribute("totalQuestions", questions.size());
//        model.addAttribute("currentQuestion", q);
//
//        // Preserve selected options
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        if (selectedOptions == null) {
//            selectedOptions = new HashMap<>();
//        }
//        if (params.containsKey("question" + questions.get(q).getId())) {
//            selectedOptions.put(questions.get(q).getId(), params.get("question" + questions.get(q).getId()));
//        }
//        model.addAttribute("selectedOptions", selectedOptions);
//
//        return "TakeMCQTest";
//    }
//
//    @PostMapping("/submit-mcq-test")
//    public String submitMcqTest(@RequestParam Map<String, String> params, Model model, SessionStatus status) {
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        List<Question> questions = questionService.getAllQuestions();
//        if (questions.isEmpty()) {
//            model.addAttribute("error", "No questions available for submission.");
//            return "error";
//        }
//
//        // Log selected options for debugging
//        System.out.println("Selected Options: " + selectedOptions);
//
//        int studentId = 1; // Replace with actual student ID
//        int score = 0;
//
//        for (Question question : questions) {
//            String selectedOption = selectedOptions.get(question.getId());
//            boolean isCorrect = selectedOption != null && question.getCorrectOption().equals(selectedOption);
//            if (isCorrect) {
//                score++;
//            }
//
//            Result result = new Result();
//            result.setStudentId(studentId);
//            result.setQuestionId(question.getId());
//            result.setSelectedOption(selectedOption != null ? selectedOption : "");
//            result.setCorrect(isCorrect);
//
//            resultService.saveResult(result);
//        }
//
//        status.setComplete();
//        model.addAttribute("score", score);
//        model.addAttribute("totalQuestions", questions.size());
//        return "result";
//    }
//
//    @GetMapping("/results")
//    public String viewResults(Model model) {
//        List<Result> results = resultService.getAllResults();
//        model.addAttribute("results", results);
//        return "viewResults";
//    }
//}


//package com.gigasea.learning_management.controller;
//
//import com.gigasea.learning_management.model.Question;
//import com.gigasea.learning_management.model.Result;
//import com.gigasea.learning_management.service.QuestionService;
//import com.gigasea.learning_management.service.ResultService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@SessionAttributes("selectedOptions")
//public class MCQTestController {
//
//    @Autowired
//    private QuestionService questionService;
//
//    @Autowired
//    private ResultService resultService;
//
//    @GetMapping("/take-mcq-test")
//    public String getMcqTest(Model model, @RequestParam(defaultValue = "0") int q, @RequestParam Map<String, String> params) {
//        List<Question> questions = questionService.getAllQuestions();
//        if (questions.isEmpty()) {
//            model.addAttribute("error", "No questions available.");
//            return "error";
//        }
//
//        model.addAttribute("question", questions.get(q));
//        model.addAttribute("totalQuestions", questions.size());
//        model.addAttribute("currentQuestion", q);
//
//        // Preserve selected options
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        if (selectedOptions == null) {
//            selectedOptions = new HashMap<>();
//        }
//        if (params.containsKey("question" + questions.get(q).getId())) {
//            selectedOptions.put(questions.get(q).getId(), params.get("question" + questions.get(q).getId()));
//        }
//        model.addAttribute("selectedOptions", selectedOptions);
//
//        return "TakeMCQTest";
//    }
//
//    @PostMapping("/submit-mcq-test")
//    public String submitMcqTest(@RequestParam Map<String, String> params, Model model, SessionStatus status) {
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        List<Question> questions = questionService.getAllQuestions();
//        if (questions.isEmpty()) {
//            model.addAttribute("error", "No questions available for submission.");
//            return "error";
//        }
//
//        // Log selected options for debugging
//        System.out.println("Selected Options: " + selectedOptions);
//
//        int studentId = 1; // Replace with actual student ID
//        int score = 0;
//
//        for (Question question : questions) {
//            String selectedOption = selectedOptions.get(question.getId());
//            boolean isCorrect = selectedOption != null && question.getCorrectOption().equals(selectedOption);
//            if (isCorrect) {
//                score++;
//            }
//
//            Result result = new Result();
//            result.setStudentId(studentId);
//            result.setQuestionId(question.getId());
//            result.setSelectedOption(selectedOption != null ? selectedOption : "");
//            result.setCorrect(isCorrect);
//
//            resultService.saveResult(result);
//        }
//
//        status.setComplete();
//        model.addAttribute("score", score);
//        model.addAttribute("totalQuestions", questions.size());
//        return "result";
//    }
//
//    @GetMapping("/results")
//    public String viewResults(Model model) {
//        List<Result> results = resultService.getAllResults();
//        model.addAttribute("results", results);
//        return "viewResults";
//    }
//}

//package com.gigasea.learning_management.controller;
//
//import com.gigasea.learning_management.model.Question;
//import com.gigasea.learning_management.model.Result;
//import com.gigasea.learning_management.service.QuestionService;
//import com.gigasea.learning_management.service.ResultService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@SessionAttributes("selectedOptions")
//public class MCQTestController {
//
//    @Autowired
//    private QuestionService questionService;
//
//    @Autowired
//    private ResultService resultService;
//
//    @GetMapping("/take-mcq-test")
//    public String getMcqTest(Model model, @RequestParam(defaultValue = "0") int q, @RequestParam Map<String, String> params) {
//        List<Question> questions = questionService.getAllQuestions();
//        if (questions.isEmpty()) {
//            model.addAttribute("error", "No questions available.");
//            return "error";
//        }
//
//        if (q < 0 || q >= questions.size()) {
//            q = 0; // Reset to first question if index is out of bounds
//        }
//
//        model.addAttribute("question", questions.get(q));
//        model.addAttribute("totalQuestions", questions.size());
//        model.addAttribute("currentQuestion", q);
//
//        // Preserve selected options
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        if (selectedOptions == null) {
//            selectedOptions = new HashMap<>();
//        }
//        if (params.containsKey("question" + questions.get(q).getId())) {
//            selectedOptions.put(questions.get(q).getId(), params.get("question" + questions.get(q).getId()));
//        }
//        model.addAttribute("selectedOptions", selectedOptions);
//
//        return "TakeMCQTest";
//    }
//
//    @PostMapping("/submit-mcq-test")
//    public String submitMcqTest(@RequestParam Map<String, String> params, Model model, SessionStatus status) {
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        List<Question> questions = questionService.getAllQuestions();
//        if (questions.isEmpty()) {
//            model.addAttribute("error", "No questions available for submission.");
//            return "error";
//        }
//
//        // Log selected options for debugging
//        System.out.println("Selected Options: " + selectedOptions);
//
//        int studentId = 1; // Replace with actual student ID
//        int score = 0;
//
//        for (Question question : questions) {
//            String selectedOption = selectedOptions.get(question.getId());
//            boolean isCorrect = selectedOption != null && question.getCorrectOption().equals(selectedOption);
//            if (isCorrect) {
//                score++;
//            }
//
//            Result result = new Result();
//            result.setStudentId(studentId);
//            result.setQuestionId(question.getId());
//            result.setSelectedOption(selectedOption != null ? selectedOption : "");
//            result.setCorrect(isCorrect);
//
//            resultService.saveResult(result);
//        }
//
//        status.setComplete();
//        model.addAttribute("score", score);
//        model.addAttribute("totalQuestions", questions.size());
//        return "result";
//    }
//
//    @GetMapping("/results")
//    public String viewResults(Model model) {
//        List<Result> results = resultService.getAllResults();
//        model.addAttribute("results", results);
//        return "viewResults";
//    }
//}

//package com.gigasea.learning_management.controller;
//
//import com.gigasea.learning_management.model.Question;
//import com.gigasea.learning_management.model.Result;
//import com.gigasea.learning_management.service.QuestionService;
//import com.gigasea.learning_management.service.ResultService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@SessionAttributes("selectedOptions")
//public class MCQTestController {
//
//    @Autowired
//    private QuestionService questionService;
//
//    @Autowired
//    private ResultService resultService;
//
//    @GetMapping("/take-mcq-test")
//    public String getMcqTest(Model model, @RequestParam(defaultValue = "0") int q, @RequestParam Map<String, String> params) {
//        List<Question> questions = questionService.getAllQuestions();
//        if (questions.isEmpty()) {
//            model.addAttribute("error", "No questions available.");
//            return "error";
//        }
//
//        if (q < 0 || q >= questions.size()) {
//            q = 0; // Reset to first question if index is out of bounds
//        }
//
//        model.addAttribute("question", questions.get(q));
//        model.addAttribute("totalQuestions", questions.size());
//        model.addAttribute("currentQuestion", q);
//
//        // Preserve selected options
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        if (selectedOptions == null) {
//            selectedOptions = new HashMap<>();
//        }
//        if (params.containsKey("question" + questions.get(q).getId())) {
//            selectedOptions.put(questions.get(q).getId(), params.get("question" + questions.get(q).getId()));
//        }
//        model.addAttribute("selectedOptions", selectedOptions);
//
//        return "TakeMCQTest";
//    }
//
//    @PostMapping("/submit-mcq-test")
//    public String submitMcqTest(@RequestParam Map<String, String> params, Model model, SessionStatus status) {
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        List<Question> questions = questionService.getAllQuestions();
//        if (questions.isEmpty()) {
//            model.addAttribute("error", "No questions available for submission.");
//            return "error";
//        }
//
//        int studentId = 1; // Replace with actual student ID
//        int score = 0;
//
//        for (Question question : questions) {
//            String selectedOption = selectedOptions.get(question.getId());
//
//            // Log correct and selected options for debugging
//            System.out.println("Question ID: " + question.getId());
//            System.out.println("Correct Option: " + question.getCorrectOption());
//            System.out.println("Selected Option: " + selectedOption);
//
//            boolean isCorrect = selectedOption != null && selectedOption.equals(question.getCorrectOption());
//            if (isCorrect) {
//                score++;
//            }
//
//            Result result = new Result();
//            result.setStudentId(studentId);
//            result.setQuestionId(question.getId());
//            result.setSelectedOption(selectedOption != null ? selectedOption : "");
//            result.setCorrect(isCorrect);
//
//            resultService.saveResult(result);
//        }
//
//        status.setComplete();
//        model.addAttribute("score", score);
//        model.addAttribute("totalQuestions", questions.size());
//        return "result";
//    }
//
//    @GetMapping("/results")
//    public String viewResults(Model model) {
//        List<Result> results = resultService.getAllResults();
//        model.addAttribute("results", results);
//        return "viewResults";
//    }
//}

//package com.gigasea.learning_management.controller;
//
//import com.gigasea.learning_management.model.Question;
//import com.gigasea.learning_management.model.Result;
//import com.gigasea.learning_management.service.QuestionService;
//import com.gigasea.learning_management.service.ResultService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@SessionAttributes("selectedOptions")
//public class MCQTestController {
//
//    @Autowired
//    private QuestionService questionService;
//
//    @Autowired
//    private ResultService resultService;
//
//    @GetMapping("/take-mcq-test")
//    public String getMcqTest(Model model, @RequestParam(defaultValue = "0") int q, @RequestParam Map<String, String> params) {
//        List<Question> questions = questionService.getAllQuestions();
//        if (questions.isEmpty()) {
//            model.addAttribute("error", "No questions available.");
//            return "error";
//        }
//
//        if (q < 0 || q >= questions.size()) {
//            q = 0; // Reset to first question if index is out of bounds
//        }
//
//        model.addAttribute("question", questions.get(q));
//        model.addAttribute("totalQuestions", questions.size());
//        model.addAttribute("currentQuestion", q);
//
//        // Preserve selected options
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        if (selectedOptions == null) {
//            selectedOptions = new HashMap<>();
//        }
//        if (params.containsKey("question" + questions.get(q).getId())) {
//            selectedOptions.put(questions.get(q).getId(), params.get("question" + questions.get(q).getId()));
//        }
//        model.addAttribute("selectedOptions", selectedOptions);
//
//        return "TakeMCQTest";
//    }
//
//    @PostMapping("/submit-mcq-test")
//    public String submitMcqTest(@RequestParam Map<String, String> params, Model model, SessionStatus status) {
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        List<Question> questions = questionService.getAllQuestions();
//        if (questions.isEmpty()) {
//            model.addAttribute("error", "No questions available for submission.");
//            return "error";
//        }
//
//        // Ensure selected options are correctly retrieved
//        for (Question question : questions) {
//            String paramKey = "question" + question.getId();
//            String selectedOption = params.get(paramKey);
//            if (selectedOption != null) {
//                selectedOptions.put(question.getId(), selectedOption);
//            }
//        }
//
//        int studentId = 1; // Replace with actual student ID
//        int score = 0;
//
//        for (Question question : questions) {
//            String selectedOption = selectedOptions.get(question.getId());
//
//            // Log correct and selected options for debugging
//            System.out.println("Question ID: " + question.getId());
//            System.out.println("Correct Option: " + question.getCorrectOption());
//            System.out.println("Selected Option: " + selectedOption);
//
//            boolean isCorrect = selectedOption != null && selectedOption.equals(question.getCorrectOption());
//            if (isCorrect) {
//                score++;
//            }
//
//            Result result = new Result();
//            result.setStudentId(studentId);
//            result.setQuestionId(question.getId());
//            result.setSelectedOption(selectedOption != null ? selectedOption : "");
//            result.setCorrect(isCorrect);
//
//            resultService.saveResult(result);
//        }
//
//        status.setComplete();
//        model.addAttribute("score", score);
//        model.addAttribute("totalQuestions", questions.size());
//        return "result";
//    }
//
//    @GetMapping("/results")
//    public String viewResults(Model model) {
//        List<Result> results = resultService.getAllResults();
//        model.addAttribute("results", results);
//        return "viewResults";
//    }
//}

//package com.gigasea.learning_management.controller;
//
//import com.gigasea.learning_management.model.Question;
//import com.gigasea.learning_management.model.Result;
//import com.gigasea.learning_management.service.QuestionService;
//import com.gigasea.learning_management.service.ResultService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@SessionAttributes("selectedOptions")
//public class MCQTestController {
//
//    @Autowired
//    private QuestionService questionService;
//
//    @Autowired
//    private ResultService resultService;
//
//    @GetMapping("/take-mcq-test")
//    public String getMcqTest(Model model, @RequestParam(defaultValue = "0") int q, @RequestParam Map<String, String> params) {
//        List<Question> questions = questionService.getAllQuestions();
//        if (questions.isEmpty()) {
//            model.addAttribute("error", "No questions available.");
//            return "error";
//        }
//
//        if (q < 0 || q >= questions.size()) {
//            q = 0; // Reset to first question if index is out of bounds
//        }
//
//        // Preserve selected options
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        if (selectedOptions == null) {
//            selectedOptions = new HashMap<>();
//        }
//        // Update selected options with current question's answer if available in params
//        String paramKey = "question" + questions.get(q).getId();
//        if (params.containsKey(paramKey)) {
//            selectedOptions.put(questions.get(q).getId(), params.get(paramKey));
//        }
//        model.addAttribute("selectedOptions", selectedOptions);
//
//        model.addAttribute("question", questions.get(q));
//        model.addAttribute("totalQuestions", questions.size());
//        model.addAttribute("currentQuestion", q);
//
//        return "TakeMCQTest";
//    }
//
//    @PostMapping("/submit-mcq-test")
//    public String submitMcqTest(@RequestParam Map<String, String> params, Model model, SessionStatus status) {
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        List<Question> questions = questionService.getAllQuestions();
//        if (questions.isEmpty()) {
//            model.addAttribute("error", "No questions available for submission.");
//            return "error";
//        }
//
//        int studentId = 1; // Replace with actual student ID
//        int score = 0;
//
//        for (Question question : questions) {
//            String selectedOption = selectedOptions.get(question.getId());
//
//            // Log correct and selected options for debugging
//            System.out.println("Question ID: " + question.getId());
//            System.out.println("Correct Option: " + question.getCorrectOption());
//            System.out.println("Selected Option: " + selectedOption);
//
//            boolean isCorrect = selectedOption != null && selectedOption.equals(question.getCorrectOption());
//            if (isCorrect) {
//                score++;
//            }
//
//            Result result = new Result();
//            result.setStudentId(studentId);
//            result.setQuestionId(question.getId());
//            result.setSelectedOption(selectedOption != null ? selectedOption : "");
//            result.setCorrect(isCorrect);
//
//            resultService.saveResult(result);
//        }
//
//        status.setComplete();
//        model.addAttribute("score", score);
//        model.addAttribute("totalQuestions", questions.size());
//        return "result";
//    }
//
//    @GetMapping("/results")
//    public String viewResults(Model model) {
//        List<Result> results = resultService.getAllResults();
//        model.addAttribute("results", results);
//        return "viewResults";
//    }
//}

//package com.gigasea.learning_management.controller;
//
//import com.gigasea.learning_management.model.Question;
//import com.gigasea.learning_management.model.Result;
//import com.gigasea.learning_management.service.QuestionService;
//import com.gigasea.learning_management.service.ResultService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@SessionAttributes("selectedOptions")
//public class MCQTestController {
//
//    @Autowired
//    private QuestionService questionService;
//
//    @Autowired
//    private ResultService resultService;
//
//    @GetMapping("/take-mcq-test")
//    public String getMcqTest(Model model, @RequestParam(defaultValue = "0") int q, @RequestParam Map<String, String> params) {
//        List<Question> questions = questionService.getAllQuestions();
//        if (questions.isEmpty()) {
//            model.addAttribute("error", "No questions available.");
//            return "error";
//        }
//
//        if (q < 0 || q >= questions.size()) {
//            q = 0; // Reset to first question if index is out of bounds
//        }
//
//        // Preserve selected options
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        if (selectedOptions == null) {
//            selectedOptions = new HashMap<>();
//        }
//        // Update selected options with current question's answer if available in params
//        String paramKey = "question" + questions.get(q).getId();
//        if (params.containsKey(paramKey)) {
//            selectedOptions.put(questions.get(q).getId(), params.get(paramKey));
//        }
//        model.addAttribute("selectedOptions", selectedOptions);
//
//        model.addAttribute("question", questions.get(q));
//        model.addAttribute("totalQuestions", questions.size());
//        model.addAttribute("currentQuestion", q);
//
//        return "TakeMCQTest";
//    }
//
//    @PostMapping("/submit-mcq-test")
//    public String submitMcqTest(@RequestParam Map<String, String> params, Model model, SessionStatus status) {
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        if (selectedOptions == null) {
//            selectedOptions = new HashMap<>();
//        }
//
//        // Update selected options with any new answers from the final submission
//        for (String key : params.keySet()) {
//            if (key.startsWith("question")) {
//                int questionId = Integer.parseInt(key.substring(8)); // Extract question ID
//                String selectedOption = params.get(key);
//                selectedOptions.put(questionId, selectedOption);
//            }
//        }
//
//        List<Question> questions = questionService.getAllQuestions();
//        if (questions.isEmpty()) {
//            model.addAttribute("error", "No questions available for submission.");
//            return "error";
//        }
//
//        int studentId = 1; // Replace with actual student ID
//        int score = 0;
//
//        for (Question question : questions) {
//            String selectedOption = selectedOptions.get(question.getId());
//
//            // Log correct and selected options for debugging
//            System.out.println("Question ID: " + question.getId());
//            System.out.println("Correct Option: " + question.getCorrectOption());
//            System.out.println("Selected Option: " + selectedOption);
//
//            boolean isCorrect = selectedOption != null && selectedOption.equals(question.getCorrectOption());
//            if (isCorrect) {
//                score++;
//            }
//
//            Result result = new Result();
//            result.setStudentId(studentId);
//            result.setQuestionId(question.getId());
//            result.setSelectedOption(selectedOption != null ? selectedOption : "");
//            result.setCorrect(isCorrect);
//
//            resultService.saveResult(result);
//        }
//
//        status.setComplete();
//        model.addAttribute("score", score);
//        model.addAttribute("totalQuestions", questions.size());
//        return "result";
//    }
//
//    @GetMapping("/results")
//    public String viewResults(Model model) {
//        List<Result> results = resultService.getAllResults();
//        model.addAttribute("results", results);
//        return "viewResults";
//    }
//}


//package com.gigasea.learning_management.controller;
//
//import com.gigasea.learning_management.model.Question;
//import com.gigasea.learning_management.model.Result;
//import com.gigasea.learning_management.service.QuestionService;
//import com.gigasea.learning_management.service.ResultService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@SessionAttributes("selectedOptions")
//public class MCQTestController {
//
//    @Autowired
//    private QuestionService questionService;
//
//    @Autowired
//    private ResultService resultService;
//
//    @GetMapping("/take-mcq-test")
//    public String getMcqTest(Model model, @RequestParam(defaultValue = "0") int q, @RequestParam Map<String, String> params) {
//        List<Question> questions = questionService.getAllQuestions();
//        if (questions.isEmpty()) {
//            model.addAttribute("error", "No questions available.");
//            return "error";
//        }
//
//        if (q < 0 || q >= questions.size()) {
//            q = 0; // Reset to first question if index is out of bounds
//        }
//
//        // Preserve selected options
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        if (selectedOptions == null) {
//            selectedOptions = new HashMap<>();
//        }
//        // Update selected options with current question's answer if available in params
//        String paramKey = "question" + questions.get(q).getId();
//        if (params.containsKey(paramKey)) {
//            selectedOptions.put(questions.get(q).getId(), params.get(paramKey));
//        }
//        model.addAttribute("selectedOptions", selectedOptions);
//
//        model.addAttribute("question", questions.get(q));
//        model.addAttribute("totalQuestions", questions.size());
//        model.addAttribute("currentQuestion", q);
//
//        return "TakeMCQTest";
//    }
//
//    @PostMapping("/submit-mcq-test")
//    public String submitMcqTest(@RequestParam Map<String, String> params, Model model, SessionStatus status) {
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        if (selectedOptions == null) {
//            selectedOptions = new HashMap<>();
//        }
//
//        // Log the incoming parameters for debugging
//        System.out.println("Incoming parameters: " + params);
//
//        // Update selected options with any new answers from the final submission
//        for (String key : params.keySet()) {
//            if (key.startsWith("question")) {
//                int questionId = Integer.parseInt(key.substring(8)); // Extract question ID
//                String selectedOption = params.get(key);
//                selectedOptions.put(questionId, selectedOption);
//            }
//        }
//
//        List<Question> questions = questionService.getAllQuestions();
//        if (questions.isEmpty()) {
//            model.addAttribute("error", "No questions available for submission.");
//            return "error";
//        }
//
//        int studentId = 1; // Placeholder for student ID
//        int score = 0;
//
//        for (Question question : questions) {
//            String selectedOption = selectedOptions.get(question.getId());
//
//            // Log correct and selected options for debugging
//            System.out.println("Question ID: " + question.getId());
//            System.out.println("Correct Option: " + question.getCorrectOption());
//            System.out.println("Selected Option: " + selectedOption);
//
//            boolean isCorrect = selectedOption != null && selectedOption.equals(question.getCorrectOption());
//            if (isCorrect) {
//                score++;
//            }
//
//            Result result = new Result();
//            result.setStudentId(studentId);
//            result.setQuestionId(question.getId());
//            result.setSelectedOption(selectedOption != null ? selectedOption : "");
//            result.setCorrect(isCorrect);
//
//            resultService.saveResult(result);
//        }
//
//        status.setComplete();
//        model.addAttribute("score", score);
//        model.addAttribute("totalQuestions", questions.size());
//        return "result";
//    }
//
//    @GetMapping("/results")
//    public String viewResults(Model model) {
//        List<Result> results = resultService.getAllResults();
//        model.addAttribute("results", results);
//        return "viewResults";
//    }
//}


//package com.gigasea.learning_management.controller;
//
//import com.gigasea.learning_management.model.Question;
//import com.gigasea.learning_management.model.Result;
//import com.gigasea.learning_management.service.QuestionService;
//import com.gigasea.learning_management.service.ResultService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@SessionAttributes("selectedOptions")
//public class MCQTestController {
//
//    @Autowired
//    private QuestionService questionService;
//
//    @Autowired
//    private ResultService resultService;
//
//    @GetMapping("/take-mcq-test")
//    public String getMcqTest(Model model, @RequestParam(defaultValue = "0") int q, @RequestParam Map<String, String> params) {
//        List<Question> questions = questionService.getAllQuestions();
//        if (questions.isEmpty()) {
//            model.addAttribute("error", "No questions available.");
//            return "error";
//        }
//
//        if (q < 0 || q >= questions.size()) {
//            q = 0; // Reset to first question if index is out of bounds
//        }
//
//        // Preserve selected options
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        if (selectedOptions == null) {
//            selectedOptions = new HashMap<>();
//        }
//        // Update selected options with current question's answer if available in params
//        String paramKey = "question" + questions.get(q).getId();
//        if (params.containsKey(paramKey)) {
//            selectedOptions.put(questions.get(q).getId(), params.get(paramKey));
//        }
//        model.addAttribute("selectedOptions", selectedOptions);
//
//        model.addAttribute("question", questions.get(q));
//        model.addAttribute("totalQuestions", questions.size());
//        model.addAttribute("currentQuestion", q);
//
//        return "TakeMCQTest";
//    }
//
//    @PostMapping("/submit-mcq-test")
//    public String submitMcqTest(@RequestParam Map<String, String> params, Model model, SessionStatus status) {
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        if (selectedOptions == null) {
//            selectedOptions = new HashMap<>();
//        }
//
//        // Log the incoming parameters for debugging
//        System.out.println("Incoming parameters: " + params);
//
//        // Update selected options with any new answers from the final submission
//        for (String key : params.keySet()) {
//            if (key.startsWith("question")) {
//                int questionId = Integer.parseInt(key.substring(8)); // Extract question ID
//                String selectedOption = params.get(key);
//                selectedOptions.put(questionId, selectedOption);
//            }
//        }
//
//        // Log selected options for debugging
//        System.out.println("Final selected options: " + selectedOptions);
//
//        List<Question> questions = questionService.getAllQuestions();
//        if (questions.isEmpty()) {
//            model.addAttribute("error", "No questions available for submission.");
//            return "error";
//        }
//
//        int studentId = 1; // Placeholder for student ID
//        int score = 0;
//
//        for (Question question : questions) {
//            String selectedOption = selectedOptions.get(question.getId());
//
//            // Log correct and selected options for debugging
//            System.out.println("Question ID: " + question.getId());
//            System.out.println("Correct Option: " + question.getCorrectOption());
//            System.out.println("Selected Option: " + selectedOption);
//
//            boolean isCorrect = selectedOption != null && selectedOption.equals(question.getCorrectOption());
//            if (isCorrect) {
//                score++;
//            }
//
//            Result result = new Result();
//            result.setStudentId(studentId);
//            result.setQuestionId(question.getId());
//            result.setSelectedOption(selectedOption != null ? selectedOption : "");
//            result.setCorrect(isCorrect);
//
//            resultService.saveResult(result);
//        }
//
//        status.setComplete();
//        model.addAttribute("score", score);
//        model.addAttribute("totalQuestions", questions.size());
//        return "result";
//    }
//
//    @GetMapping("/results")
//    public String viewResults(Model model) {
//        List<Result> results = resultService.getAllResults();
//        model.addAttribute("results", results);
//        return "viewResults";
//    }
//}

//package com.gigasea.learning_management.controller;
//
//import com.gigasea.learning_management.model.Question;
//import com.gigasea.learning_management.model.Result;
//import com.gigasea.learning_management.service.QuestionService;
//import com.gigasea.learning_management.service.ResultService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import org.springframework.web.bind.support.SessionStatus;
//
//import java.util.*;
//
//@Controller
//@SessionAttributes("selectedOptions")
//public class MCQTestController {
//
//    @Autowired
//    private QuestionService questionService;
//
//    @Autowired
//    private ResultService resultService;
//
//    // Get the MCQ test page and load the first question
//    @GetMapping("/take-mcq-test")
//    public String getMcqTest(Model model, @RequestParam(defaultValue = "0") int q, @RequestParam Map<String, String> params) {
//        List<Question> questions = questionService.getAllQuestions();
//        if (questions.isEmpty()) {
//            model.addAttribute("error", "No questions available.");
//            return "error";
//        }
//
//        if (q < 0 || q >= questions.size()) {
//            q = 0; // Reset to first question if index is out of bounds
//        }
//
//        // Retrieve or initialize selected options map
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        if (selectedOptions == null) {
//            selectedOptions = new HashMap<>();
//        }
//
//        // If new answer is selected, update the selected options map
//        String paramKey = "question" + questions.get(q).getId();
//        if (params.containsKey(paramKey)) {
//            selectedOptions.put(questions.get(q).getId(), params.get(paramKey));
//        }
//
//        model.addAttribute("selectedOptions", selectedOptions);
//        model.addAttribute("question", questions.get(q));
//        model.addAttribute("totalQuestions", questions.size());
//        model.addAttribute("currentQuestion", q);
//
//        return "TakeMCQTest";
//    }
//
//    // Handle test submission
//    @PostMapping("/submit-mcq-test")
//    public String submitMcqTest(@RequestParam Map<String, String> params, Model model, SessionStatus status) {
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        if (selectedOptions == null) {
//            selectedOptions = new HashMap<>();
//        }
//
//        // Save the selected options for each question
//        for (String key : params.keySet()) {
//            if (key.startsWith("question")) {
//                int questionId = Integer.parseInt(key.substring(8)); // Extract question ID
//                String selectedOption = params.get(key);
//                selectedOptions.put(questionId, selectedOption);
//            }
//        }
//
//        // Calculate score
//        int score = 0;
//        int totalQuestions = questionService.getAllQuestions().size();
//        for (Map.Entry<Integer, String> entry : selectedOptions.entrySet()) {
//            Question question = questionService.getAllQuestions().get(entry.getKey() - 1);
//            if (question.getCorrectOption().equals(entry.getValue())) {
//                score++;
//            }
//        }
//
//        model.addAttribute("score", score);
//        model.addAttribute("totalQuestions", totalQuestions);
//
//        // Save result for each question selected by the student
//        for (Map.Entry<Integer, String> entry : selectedOptions.entrySet()) {
//            Question question = questionService.getAllQuestions().get(entry.getKey() - 1);
//            Result result = new Result();
//            result.setStudentId(1); // Use the logged-in student ID here
//            result.setQuestionId(question.getId());
//            result.setSelectedOption(entry.getValue());
//            result.setCorrect(question.getCorrectOption().equals(entry.getValue()));
//            resultService.saveResult(result);
//        }
//
//        status.setComplete(); // Clear session data
//
//        return "TestResults";
//    }
//}

package com.gigasea.learning_management.controller;

import com.gigasea.learning_management.model.Question;
import com.gigasea.learning_management.model.Result;
import com.gigasea.learning_management.service.QuestionService;
import com.gigasea.learning_management.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("selectedOptions")
public class MCQTestController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ResultService resultService;

    @GetMapping("/take-mcq-test")
    public String getMcqTest(Model model, @RequestParam(defaultValue = "0") int q, @RequestParam Map<String, String> params) {
        List<Question> questions = questionService.getAllQuestions();
        if (questions.isEmpty()) {
            model.addAttribute("error", "No questions available.");
            return "error";
        }

        if (q < 0 || q >= questions.size()) {
            q = 0; // Reset to first question if index is out of bounds
        }

        // Preserve selected options
        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
        if (selectedOptions == null) {
            selectedOptions = new HashMap<>();
        }
        // Update selected options with current question's answer if available in params
        String paramKey = "question" + questions.get(q).getId();
        if (params.containsKey(paramKey)) {
            selectedOptions.put(questions.get(q).getId(), params.get(paramKey));
        }
        model.addAttribute("selectedOptions", selectedOptions);

        model.addAttribute("question", questions.get(q));
        model.addAttribute("totalQuestions", questions.size());
        model.addAttribute("currentQuestion", q);

        return "TakeMCQTest";
    }

//    @PostMapping("/submit-mcq-test")
//    public String submitMcqTest(@RequestParam Map<String, String> params, Model model, SessionStatus status) {
//        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
//        if (selectedOptions == null) {
//            selectedOptions = new HashMap<>();
//        }
//
//        // Log the incoming parameters for debugging
//        System.out.println("Incoming parameters: " + params);
//
//        // Update selected options with any new answers from the final submission
//        for (String key : params.keySet()) {
//            if (key.startsWith("question")) {
//                int questionId = Integer.parseInt(key.substring(8)); // Extract question ID
//                String selectedOption = params.get(key);
//                selectedOptions.put(questionId, selectedOption);
//            }
//        }
//
//        // Log selected options for debugging
//        System.out.println("Final selected options: " + selectedOptions);
//
//        List<Question> questions = questionService.getAllQuestions();
//        if (questions.isEmpty()) {
//            model.addAttribute("error", "No questions available for submission.");
//            return "error";
//        }
//
//        int studentId = 1; // Placeholder for student ID
//        int score = 0;
//
//        for (Question question : questions) {
//            String selectedOption = selectedOptions.get(question.getId());
//
//            // Log correct and selected options for debugging
//            System.out.println("Question ID: " + question.getId());
//            System.out.println("Correct Option: " + question.getCorrectOption());
//            System.out.println("Selected Option: " + selectedOption);
//
//            boolean isCorrect = selectedOption != null && selectedOption.equals(question.getCorrectOption());
//            if (isCorrect) {
//                score++;
//            }
//
//            Result result = new Result();
//            result.setStudentId(studentId);
//            result.setQuestionId(question.getId());
//            result.setSelectedOption(selectedOption != null ? selectedOption : "");
//            result.setCorrect(isCorrect);
//
//            resultService.saveResult(result);
//        }
//
//        status.setComplete();
//        model.addAttribute("score", score);
//        model.addAttribute("totalQuestions", questions.size());
//        return "result";
//    }

    @PostMapping("/submit-mcq-test")
    public String submitMcqTest(@RequestParam Map<String, String> params, Model model, SessionStatus status) {
        // Get or initialize the selectedOptions map
        Map<Integer, String> selectedOptions = (Map<Integer, String>) model.getAttribute("selectedOptions");
        if (selectedOptions == null) {
            selectedOptions = new HashMap<>();
        }

        // Log the incoming parameters for debugging
        System.out.println("Incoming parameters: " + params);

        // Update selected options with any new answers from the final submission
        for (String key : params.keySet()) {
            if (key.startsWith("question")) {
                int questionId = Integer.parseInt(key.substring(8)); // Extract question ID
                String selectedOption = params.get(key);
                selectedOptions.put(questionId, selectedOption);
            }
        }

        // Log selected options for debugging
        System.out.println("Final selected options: " + selectedOptions);

        // Retrieve all questions to evaluate answers
        List<Question> questions = questionService.getAllQuestions();
        if (questions.isEmpty()) {
            model.addAttribute("error", "No questions available for submission.");
            return "error";
        }

        // Initialize student ID and score
        int studentId = 1; // Placeholder for student ID
        int score = 0;

        // Loop through questions to check the selected options
        for (Question question : questions) {
            String selectedOption = selectedOptions.get(question.getId());

            // Log correct and selected options for debugging
            System.out.println("Question ID: " + question.getId());
            System.out.println("Correct Option: " + question.getCorrectOption());
            System.out.println("Selected Option: " + selectedOption);

            // Check if the answer is correct
            boolean isCorrect = selectedOption != null && selectedOption.equals(question.getCorrectOption());
            if (isCorrect) {
                score++;
            }

            // Create a Result object and save the result
            Result result = new Result();
            result.setStudentId(studentId);
            result.setQuestionId(question.getId());
            result.setSelectedOption(selectedOption != null ? selectedOption : "");  // Ensure no nulls
            result.setCorrect(isCorrect);

            resultService.saveResult(result);
        }

        // Clear session status and add the score and total number of questions to the model
        status.setComplete();
        model.addAttribute("score", score);
        model.addAttribute("totalQuestions", questions.size());

        return "result"; // Return the result view with the score
    }


    @GetMapping("/results")
    public String viewResults(Model model) {
        List<Result> results = resultService.getAllResults();
        model.addAttribute("results", results);
        return "viewResults";
    }
}
