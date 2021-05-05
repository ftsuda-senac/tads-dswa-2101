/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring.produto;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ftsuda
 */
@Repository
public class CategoriaRepositoryJpaImpl implements CategoriaRepository {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Categoria> findAll() {
        TypedQuery<Categoria> jpqlQuery =
                em.createQuery("SELECT c FROM Categoria c", Categoria.class);
        return jpqlQuery.getResultList();
    }

    @Override
    public Categoria findById(Integer id) {
        TypedQuery<Categoria> jpqlQuery =
                em.createQuery("SELECT c FROM Categoria c WHERE c.id = :idCat", Categoria.class);
        jpqlQuery.setParameter("idCat", id);
        Categoria c = jpqlQuery.getSingleResult();
        return c;
    }

    @Override
    @Transactional
    public Categoria save(Categoria cat) {
        if (cat.getId() == null) {
            // JPA cria nova categoria
            em.persist(cat);
        } else {
            // JPA atualizar categoria existente
            cat = em.merge(cat);
        }
        return cat;
    }
    
}
