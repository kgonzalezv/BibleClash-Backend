package com.sigia.bibleclash.repository;

import com.sigia.bibleclash.modelo.EntUsuario;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IUsuario {
    void saveUsuario(EntUsuario entUsuario);
    void deleteUsuarioById(Long id);
    List<EntUsuario> getAllUsuario();
    EntUsuario getUsuarioById(Long id);
}
