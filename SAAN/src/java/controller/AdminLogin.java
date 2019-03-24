/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import util.Mensajes;
import java.util.ArrayList;
import java.util.List;
import models.*;
import util.extra;

/**
 *
 * @author pipel
 */
@WebServlet(urlPatterns = {"/login"})
public class AdminLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

        request.setAttribute("mensaje", Mensajes.mensaje);

        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
        view.forward(request, response);
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
        String id = request.getParameter("id");
        String clave = request.getParameter("clave");
        HttpSession session = request.getSession();
        if (session.getAttribute("personas") != null && session.getAttribute("profesores") != null && session.getAttribute("estudiantes") != null) {
            List<Persona> personas = (ArrayList<Persona>) session.getAttribute("personas");
            List<Estudiante> estudiantes = (ArrayList<Estudiante>) session.getAttribute("estudiantes");
            List<Profesor> profesores = (ArrayList<Profesor>) session.getAttribute("profesores");
            int usu = -1;
            if (extra.isInteger(id)) {
                usu = Persona.login(personas, estudiantes, profesores, Long.parseLong(id), clave);
            } else {
                usu = Persona.login(personas, estudiantes, profesores, id, clave);
            }
            switch (usu) {
                case 1:
                    RequestDispatcher ad = request.getRequestDispatcher("/menuAdministrador");
                    ad.forward(request, response);
                    break;
                case 2:
                    //Estudiante
                    break;
                case 3:
                    //Profesor
                    break;
                default:
                    request.setAttribute("mensaje", Mensajes.mensaje);
                    RequestDispatcher view = request.getRequestDispatcher("login.jsp");
                    view.forward(request, response);
                    break;
            }
        } else {
            RequestDispatcher view = request.getRequestDispatcher("/inicio");
            view.forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
