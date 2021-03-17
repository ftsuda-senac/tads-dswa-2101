/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosweb;

import br.senac.tads.dsw.exemplosweb.modelo.DadosPessoais;
import br.senac.tads.dsw.exemplosweb.modelo.ExperienciaProfissional;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ftsuda
 */
@WebServlet(name = "DadosPessoaisServlet", urlPatterns = {"/dados-pessoais"})
public class DadosPessoaisServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        DadosPessoais dp = new DadosPessoais();
        dp.setNome("Fulano da Silva");
        dp.setDataNascimento(LocalDate.of(2000, 1, 20));
        dp.setTelefone("(11) 99999-1234");
        dp.setEmail("fulano@teste.com.br");
        
        ExperienciaProfissional ep1 = new ExperienciaProfissional();
        ep1.setCargo("Cargo 1");
        ep1.setEmpresa("Empresa 1");
        ep1.setDataInicio(LocalDate.of(2000, 1, 20));
        ep1.setDataTermino(LocalDate.of(2000, 1, 20));
        
        ExperienciaProfissional ep2 = new ExperienciaProfissional();
        ep2.setCargo("Cargo 2");
        ep2.setEmpresa("Empresa 2");
        ep2.setDataInicio(LocalDate.of(2000, 1, 20));
        ep2.setDataTermino(LocalDate.of(2000, 1, 20));
        
        dp.setExperienciasProfissionais(Arrays.asList(ep1, ep2));
        
        request.setAttribute("dp", dp);
        RequestDispatcher dispatcher  = request.getRequestDispatcher("/WEB-INF/jsp/dados-pessoais.jsp");
        dispatcher.forward(request, response);

    }

}
