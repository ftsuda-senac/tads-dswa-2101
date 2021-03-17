/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosweb;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ExemploMobile", urlPatterns = {"/exemplo-mobile"})
public class ExemploMobile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ua = request.getHeader("user-agent");
        boolean mobile = ua.toLowerCase().contains("mobile");
        
        if (mobile) {
            // Apresenta HTML mobile
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mobile.jsp");
            dispatcher.forward(request, response);
        } else {
            // Tela normal desktop
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/desktop.jsp");
            dispatcher.forward(request, response);
        }
    }

}
