package com.sigia.bibleclash.repository;

import com.sigia.bibleclash.modelo.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IQuestion {

   void save(Question question);
   List<Question> getALlQuestions();
   void deleteQuestionById(Long id);
   void update(Long id, String name);
   Question getQuestionById(Long id);

}
