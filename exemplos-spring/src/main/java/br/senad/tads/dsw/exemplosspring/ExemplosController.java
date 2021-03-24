/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senad.tads.dsw.exemplosspring;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExemplosController {
    
    @GetMapping("/ex1")
    public String exemplo1() {
        return "exemplo1";
    }
    
    @GetMapping("/ex2")
    public String exemplo2(Model model) {
        model.addAttribute("nome", "Fulano da Silva");
        model.addAttribute("dataNascimento", LocalDate.parse("2000-05-10"));
        model.addAttribute("numero", 38);
        model.addAttribute("dataHoraAtual", LocalDateTime.now());
        return "exemplo2";
    }
   
    @GetMapping("/ex2b")
    public ModelAndView exemplo2b() {
        ModelAndView mv = new ModelAndView("exemplo2");
        mv.addObject("nome", "Ciclano da Silva");
        mv.addObject("dataNascimento", LocalDate.parse("1998-04-25"));
        mv.addObject("numero", 28);
        mv.addObject("dataHoraAtual", LocalDateTime.now());
        return mv;
    }
    
    @GetMapping("/ex3")
    public ModelAndView exemplo3() {
        Dados dados = new Dados();
        dados.setNome("Beltrana das Cruzes");
        dados.setDataNascimento(LocalDate.parse("2001-02-23"));
        dados.setNumero(4);
        
        ModelAndView mv = new ModelAndView("exemplo3");
        mv.addObject("dados", dados);
        mv.addObject("dataHoraAtual", LocalDateTime.now());
        return mv;
    }
    
}
