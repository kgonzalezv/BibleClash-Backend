package com.sigia.bibleclash.controller;

import com.sigia.bibleclash.modelo.Question;
import com.sigia.bibleclash.service.ImplServiceQuestion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bibleClash/question")
public class QuestionController {

    private ImplServiceQuestion implServiceQuestion;

    public QuestionController(ImplServiceQuestion implServiceQuestion) {
        this.implServiceQuestion = implServiceQuestion;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Question question) {
        implServiceQuestion.save(question);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id) {
        return ResponseEntity.ok(implServiceQuestion.getQuestionById(id)).getBody();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Question>> getAllQuestion() {
        return ResponseEntity.ok(implServiceQuestion.getALlQuestions());
    }
}