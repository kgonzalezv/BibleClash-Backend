package com.sigia.bibleclash.service;

import com.sigia.bibleclash.modelo.Question;
import com.sigia.bibleclash.repository.IQuestion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplServiceQuestion implements IQuestion {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public void save(Question question) {
        em.persist(question);
    }

    @Transactional
    @Override
    public List<Question> getALlQuestions() {
        return em.createQuery("SELECT q FROM Question q ", Question.class).getResultList();
    }

    @Transactional
    @Override
    public void deleteQuestionById(Long id) {
        em.remove(getQuestionById(id));
    }

    @Transactional
    @Override
    public void update(Long id, String name) {
        em.createQuery("UPDATE Question q SET q.name = :name WHERE q.id = :id")
                .setParameter("name", name).setParameter("id", id).executeUpdate();
    }

    @Transactional
    @Override
    public Question getQuestionById(Long id) {
        return em.find(Question.class,id);
    }
}
