/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senad.tads.dsw.exemplosspring;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @GetMapping("/ex4")
    public ModelAndView exemplo4() {
        List<Dados> lista = new ArrayList<>();
        lista.add(new Dados("Fulano da Silva", LocalDate.parse("2000-10-20"), 42));
        lista.add(new Dados("Ciclano de Souza", LocalDate.parse("2003-04-08"), 15));
        lista.add(new Dados("Beltrana dos Santos", LocalDate.parse("2004-01-23"), 38));
        
        ModelAndView mv = new ModelAndView("exemplo4");
        mv.addObject("lista", lista);
        return mv;
    }
    
    @GetMapping("/ex5")
    public ModelAndView exemplo5(
            @RequestParam("nome") String nome,
            @RequestParam(value = "dtnasc", required = false) String dtNascStr,
            @RequestParam(value = "numero", defaultValue = "0") int numero) {
        
        Dados dados = new Dados();
        dados.setNome(nome);
        if (dtNascStr != null) {
            dados.setDataNascimento(LocalDate.parse(dtNascStr));
        }
        dados.setNumero(numero);
        
        ModelAndView mv = new ModelAndView("exemplo5");
        mv.addObject("dados", dados);
        return mv;
    }

    @GetMapping("/ex6/{apelido}")
    public ModelAndView exemplo6(
            @PathVariable("apelido") String apelido) {
        
        ModelAndView mv = new ModelAndView("exemplo6");
        if ("fulano".equals(apelido)) {
            mv.addObject("dados", new Dados("Fulano da Silva", LocalDate.parse("2000-01-29"), 99));
        } else if ("ciclano".equals(apelido)) {
            mv.addObject("dados", new Dados("Ciclano de Souza", LocalDate.parse("2003-03-29"), 54));
        }
        return mv;
    }

    @GetMapping("/ex7")
    public ModelAndView exemplo7(
            @RequestHeader("user-agent") String userAgent) {
        ModelAndView mv = new ModelAndView("exemplo7");
        mv.addObject("ua", userAgent);
        return mv;
    }
  
    @GetMapping("/ex8")
    public ModelAndView exemplo8(
        @RequestHeader Map<String, String> headersHttp) {
        ModelAndView mv = new ModelAndView("exemplo8");
        mv.addObject("headers", headersHttp);
        return mv;
    }
}
