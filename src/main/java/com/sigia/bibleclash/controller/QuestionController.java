package com.sigia.bibleclash.controller;

import com.sigia.bibleclash.modelo.Question;
import com.sigia.bibleclash.service.ImplServiceQuestion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/bibleClash/question")
public class QuestionController {

    private ImplServiceQuestion implServiceQuestion;

    public QuestionController(ImplServiceQuestion implServiceQuestion) {
        this.implServiceQuestion = implServiceQuestion;
    }

    @PostMapping
    public ResponseEntity<Question> create(@RequestBody Question question) {
        implServiceQuestion.save(question);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Question question = implServiceQuestion.getQuestionById(id).orElse(null);
        return Objects.isNull(question) ? ResponseEntity.noContent().build() : ResponseEntity.ok(question);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Question>> getAllQuestion() {
        return ResponseEntity.ok(implServiceQuestion.getALlQuestions());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Question> delete(@PathVariable Long id) {
        implServiceQuestion.deleteQuestionById(id);
        return ResponseEntity.ok().build();
    }

}