package com.sigia.bibleclash.service;

import com.sigia.bibleclash.modelo.EntUsuario;
import com.sigia.bibleclash.repository.IUsuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplServicieUsuario implements IUsuario {
    @PersistenceContext
    EntityManager em;

    @Override
    public void saveUsuario(EntUsuario entUsuario) {
        em.persist(entUsuario);
    }

    @Override
    public void deleteUsuarioById(Long id) {
        em.remove(getUsuarioById(id));
    }

    @Override
    public List<EntUsuario> getAllUsuario() {
        return em.createQuery("SELECT u FROM EntUsuario u", EntUsuario.class).getResultList();
    }

    @Override
    public EntUsuario getUsuarioById(Long id) {
        return em.find(EntUsuario.class, id);
    }
}
