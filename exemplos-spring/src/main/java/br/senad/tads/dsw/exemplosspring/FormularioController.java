/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senad.tads.dsw.exemplosspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/formulario")
public class FormularioController {

    @GetMapping
    public ModelAndView mostrarForm() {
        ModelAndView mv = new ModelAndView("formulario");
        return mv;
    }
    
    @PostMapping("/salvar")
    public ModelAndView salvarDados(
            @ModelAttribute DadosPessoais dados) {
        ModelAndView mv = new ModelAndView("resultado");
        mv.addObject("dados", dados);
        return mv;
    }
    
}
