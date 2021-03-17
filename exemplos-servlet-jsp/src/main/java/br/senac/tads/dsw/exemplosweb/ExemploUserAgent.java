/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ftsuda
 */
@WebServlet(name = "ExemploUserAgent", urlPatterns = {"/user-agent"})
public class ExemploUserAgent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String ua = request.getHeader("user-agent");
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Exemplo User Agent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Exemplo User-agent</h1>");
            out.println("<h2>User-agent: " + ua + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
