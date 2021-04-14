/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senad.tads.dsw.exemplosspring;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/formulario")
public class FormularioController {

    @GetMapping
    public ModelAndView mostrarForm() {
        ModelAndView mv = new ModelAndView("formulario");
        mv.addObject("dados", new DadosPessoais());
        return mv;
    }

    @GetMapping("/preenchido")
    public ModelAndView mostrarFormPreenchido() {
        DadosPessoais dados = new DadosPessoais();
        dados.setId(1);
        dados.setNome("Seu Madruga");
        dados.setEmail("madruga@teste.com.br");
        dados.setTelefone("(11) 99999-1234");
        dados.setSenha("abcd1234");
        dados.setRepetirSenha("abcd1234");
        dados.setDescricao("A vingança nunca é plena");
        dados.setNumero(70);
        dados.setPeso(new BigDecimal("70.5"));
        dados.setAltura(new BigDecimal("1.81"));
        dados.setDataNascimento(LocalDate.parse("1970-01-20"));
        dados.setGenero(1);
        dados.setInteresses(Arrays.asList("Esportes", "Viagens"));

        ModelAndView mv = new ModelAndView("formulario");
        mv.addObject("dados", dados);
        return mv;
    }
    
    @PostMapping("/salvar")
    public ModelAndView salvarDados(
            @ModelAttribute DadosPessoais dados) {
        ModelAndView mv = new ModelAndView("resultado");
        mv.addObject("dados", dados);
        return mv;
    }

    @PostMapping("/salvar-post-redirect-get")
    public ModelAndView salvarDadosPostRedirectGet(
            @ModelAttribute DadosPessoais dados,
            RedirectAttributes redirAttr) {
        ModelAndView mv = new ModelAndView("redirect:/formulario/resultado-post-redirect-get");
        redirAttr.addFlashAttribute("dados", dados);
        return mv;
    }

    @GetMapping("/resultado-post-redirect-get")
    public ModelAndView mostrarResultado() {
        return new ModelAndView("resultado");
    }

    @GetMapping("/validacao")
    public ModelAndView mostrarFormValidacao() {
        ModelAndView mv = new ModelAndView("formulario-validacao");
        mv.addObject("dados", new DadosPessoais());
        return mv;
    }
    
    @PostMapping("/validacao/salvar-post-redirect-get")
    public ModelAndView salvarDadosValidacaoPostRedirectGet(
            @ModelAttribute("dados") @Valid DadosPessoais dados,
            BindingResult bindingResult,
            RedirectAttributes redirAttr) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("formulario-validacao");
        }
        ModelAndView mv = new ModelAndView("redirect:/formulario/resultado-post-redirect-get");
        redirAttr.addFlashAttribute("dados", dados);
        return mv;
    }
    
}
