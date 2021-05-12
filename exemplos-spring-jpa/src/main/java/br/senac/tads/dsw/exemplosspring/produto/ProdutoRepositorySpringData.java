/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring.produto;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorySpringData
        extends JpaRepository<Produto, Long> {

    Page<Produto> findByCategorias_IdIn(List<Integer> idsCat, Pageable pageable);

    List<Produto> findByNome(String nome);

    List<Produto> findByNomeIgnoreCase(String nome);

    List<Produto> findByDescricaoIgnoreCaseContaining(String termo);
    
    //List<Produto> findByNomeIgnoreCaseContainingOrDescricaoIgnoreCaseContaining(String nome, String descricao);
    
    List<Produto> findByNomeIgnoreCaseContaining(String nome);
    
    @Query("SELECT p FROM Produto p WHERE UPPER(p.nome) LIKE UPPER('%'||:termo||'%')")
    List<Produto> buscaPorNomeJpql(@Param("termo") String nome);
    
    @Query(nativeQuery = true, value = "SELECT * FROM produto WHERE upper(nome) LIKE upper('%'||:termo||'%')")
    List<Produto> buscaPorNomeSqlNativa(@Param("termo") String nome);
}
