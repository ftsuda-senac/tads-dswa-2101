/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring.produto;

import java.util.List;
import javax.persistence.EntityGraph;
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
public class ProdutoRepositoryJpaImpl implements ProdutoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Produto> findAll(int offset, int quantidade) {
        TypedQuery<Produto> jpqlQuery
                = em.createQuery("SELECT p FROM Produto p", Produto.class);
        jpqlQuery.setFirstResult(offset);
        jpqlQuery.setMaxResults(quantidade);
        return jpqlQuery.getResultList();
    }

    @Override
    public List<Produto> findByCategoria(List<Integer> idsCat, int offset, int quantidade) {
        TypedQuery<Produto> jpqlQuery = 
                em.createNamedQuery("Produto.findByCategoriasIds", Produto.class);
        jpqlQuery.setParameter("idsCat", idsCat);
        jpqlQuery.setFirstResult(offset);
        jpqlQuery.setMaxResults(quantidade);
        return jpqlQuery.getResultList();
    }

    @Override
    public Produto findById(Long id) {
        EntityGraph<?> entityGraph = em.getEntityGraph("graph.ProdutoCategoriasImagens");
        TypedQuery<Produto> jpqlQuery
                = em.createNamedQuery("Produto.findById", Produto.class);
        jpqlQuery.setParameter("idProd", id);
        jpqlQuery.setHint("javax.persistence.loadgraph", entityGraph);
        Produto p = jpqlQuery.getSingleResult();
        return p;
    }

    @Override
    @Transactional
    public Produto save(Produto p) {
        if (p.getId() == null) {
            // JPA cria novo produto
            em.persist(p);
        } else {
            // JPA atualiza produto existente
            p = em.merge(p);
        }
        return p;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        // TEM QUE CONSULTAR O PRODUTO QUE SERÁ APAGADO PARA
        // MANTE-LO ASSOCIADO AO ENTITY MANAGER (ATTACHED)
        Produto p = em.find(Produto.class, id);
        em.remove(p);
    }

    /*
select produto0_.id as id1_2_0_, categoria2_.id as id1_0_1_, imagens3_.id as id1_1_2_, produto0_.descricao as descrica2_2_0_, produto0_.disponivel as disponiv3_2_0_, produto0_.dt_cadastro as dt_cadas4_2_0_, produto0_.nome as nome5_2_0_, produto0_.preco_compra as preco_co6_2_0_, produto0_.preco_venda as preco_ve7_2_0_, produto0_.quantidade as quantida8_2_0_, categoria2_.nome as nome2_0_1_, categorias1_.produto_id as produto_1_3_0__, categorias1_.categoria_id as categori2_3_0__, imagens3_.legenda as legenda2_1_2_, imagens3_.nome_arquivo as nome_arq3_1_2_, imagens3_.produto_id as produto_4_1_2_, imagens3_.produto_id as produto_4_1_1__, imagens3_.id as id1_1_1__ 
from produto produto0_ 
left outer join produto_categoria categorias1_ 
    on produto0_.id=categorias1_.produto_id 
left outer join categoria categoria2_ 
    on categorias1_.categoria_id=categoria2_.id 
left outer join imagem_produto imagens3_ 
    on produto0_.id=imagens3_.produto_id
where produto0_.id=?

    */
    

}
