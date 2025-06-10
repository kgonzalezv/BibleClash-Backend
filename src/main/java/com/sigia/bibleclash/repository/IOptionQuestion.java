package com.sigia.bibleclash.repository;

import com.sigia.bibleclash.modelo.OptionQuestion;
import com.sigia.bibleclash.modelo.Question;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOptionQuestion {

    void saveOneOption(OptionQuestion option);
    void saveOptionQuestion(List<OptionQuestion> options);
//    void deleteOptionQuestionById(Long id);
    List<OptionQuestion> getOptionByQuestionsId(Long question);
//    Optional<OptionQuestion> getOptionQuestionById(Long id);

}
