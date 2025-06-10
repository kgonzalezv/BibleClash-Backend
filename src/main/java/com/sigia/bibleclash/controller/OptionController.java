package com.sigia.bibleclash.controller;

import com.sigia.bibleclash.modelo.OptionQuestion;
import com.sigia.bibleclash.service.ImplServiceOptionQuestion;
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
import java.util.Optional;

@RestController
@RequestMapping("/bibleClash/option")
public class OptionController {

    private ImplServiceOptionQuestion implServiceOption;

    public OptionController(ImplServiceOptionQuestion implServiceOption) {
        this.implServiceOption = implServiceOption;
    }

    @PostMapping()
    public ResponseEntity<OptionQuestion> create(@RequestBody OptionQuestion option) {
        implServiceOption.saveOneOption(option);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/groupOfOption")
    public ResponseEntity<OptionQuestion> createGroupOFOption(@RequestBody List<OptionQuestion> option) {
        implServiceOption.saveOptionQuestion(option);
        return ResponseEntity.ok().build();
    }

//    @GetMapping("/getAll")
//    public ResponseEntity<List<OptionQuestion>> getAll() {
//        return ResponseEntity.ok().body(implServiceOption.getAllOptionQuestions());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<List<OptionQuestion>> getOptionById(@PathVariable Long id) {
        return ResponseEntity.ok().body(implServiceOption.getOptionByQuestionsId(id));

//        OptionQuestion o = implServiceOption.getOptionQuestionById(id).orElse(null);
//        return Objects.nonNull(o) ? ResponseEntity.ok().body(o) : ResponseEntity.notFound().build();
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<OptionQuestion> deleteOptionById(@PathVariable Long id) {
//        implServiceOption.deleteOptionQuestionById(id);
//        return ResponseEntity.ok().build();
//    }


}
