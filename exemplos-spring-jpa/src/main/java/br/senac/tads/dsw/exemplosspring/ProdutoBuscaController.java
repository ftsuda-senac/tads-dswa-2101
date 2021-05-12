/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring;

import br.senac.tads.dsw.exemplosspring.produto.Produto;
import br.senac.tads.dsw.exemplosspring.produto.ProdutoRepositorySpringData;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/produto/busca")
public class ProdutoBuscaController {
    
    @Autowired
    private ProdutoRepositorySpringData repository;
    
    @GetMapping
    public ModelAndView buscar(@RequestParam("termo") String termo) {
        List<Produto> resultados = repository.buscaPorNomeSqlNativa(termo);
        return new ModelAndView("produto/lista").addObject("produtos", resultados);
    }
    
}
