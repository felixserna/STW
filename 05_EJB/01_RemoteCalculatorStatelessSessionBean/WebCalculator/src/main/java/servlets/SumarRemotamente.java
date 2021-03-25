/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import demo.ejb.CalculadoraRemote;

/**
 *
 * @author FS
 */
@WebServlet(name = "SumarRemotamente", urlPatterns = {"/sumarRemotamente"})
public class SumarRemotamente extends HttpServlet {

    @EJB CalculadoraRemote calc;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        long t0 = System.nanoTime();

        HttpSession session = request.getSession(true);
        Integer resultadoRemoto = (Integer)session.getAttribute("resultado");
        
        int s1 = Integer.valueOf(request.getParameter("s1"));
        int s2 = Integer.valueOf(request.getParameter("s2"));
        
        resultadoRemoto = calc.sumar(s1, s2);
        session.setAttribute("s1", s1);
        session.setAttribute("s2", s2);
        session.setAttribute("resultadoRemoto", resultadoRemoto);

        long t1 = System.nanoTime();

        session.setAttribute("us", (Long)(t1-t0)/1000);
        
        response.sendRedirect(response.encodeURL("sumar.jsp"));
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
