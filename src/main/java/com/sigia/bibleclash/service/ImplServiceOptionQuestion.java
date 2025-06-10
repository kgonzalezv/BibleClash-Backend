package com.sigia.bibleclash.service;

import com.sigia.bibleclash.modelo.OptionQuestion;
import com.sigia.bibleclash.modelo.Question;
import com.sigia.bibleclash.repository.IOptionQuestion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ImplServiceOptionQuestion implements IOptionQuestion {
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public void saveOneOption(OptionQuestion option) {
        em.persist(option);
    }

    @Override
    @Transactional
    public void saveOptionQuestion(List<OptionQuestion> options) {

        for (OptionQuestion option : options) {
            em.persist(option);
        }
    }

//    @Override
//    @Transactional
//    public void deleteOptionQuestionById(Long id) {
//        em.remove(getOptionQuestionById(id));
//    }

    @Override
    @Transactional
    public List<OptionQuestion> getOptionByQuestionsId(Long id) {
        return em.createQuery("SELECT o FROM OptionQuestion o where o.question.id = :id", OptionQuestion.class)
                .setParameter("id",id).getResultList();
    }

//    @Override
//    @Transactional
//    public Optional<OptionQuestion> getOptionQuestionById(Long id) {
//        OptionQuestion optionQuestion = em.find(OptionQuestion.class, id);
//        return Optional.ofNullable(optionQuestion);
//    }
}
