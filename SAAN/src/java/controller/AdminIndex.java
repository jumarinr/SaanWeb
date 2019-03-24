/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.*;
import models.*;

/**
 *
 * @author Juan Pablo
 */
@WebServlet(urlPatterns = {"/inicio"})
public class AdminIndex extends HttpServlet {

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
        
        //se crea listas
        List<Nota> notas = new ArrayList<Nota>();
        List<Materia> materias = new ArrayList<Materia>();
        List<Estudiante> estudiantes = new ArrayList<Estudiante>();
        List<Profesor> profesores = new ArrayList<Profesor>();
        List<Matricula> matriculas = new ArrayList<Matricula>();
        List<Persona> personas = new ArrayList<Persona>();
        List<Grupo> grupos = new ArrayList<Grupo>();
        
        Persona.registrar(personas, estudiantes, profesores, new Persona("Juan Pablo M", 123, "e@e.com", "000"));
        
        HttpSession session = request.getSession();   
        session.setAttribute("notas", notas);
        session.setAttribute("materias", materias);
        session.setAttribute("estudiantes", estudiantes);
        session.setAttribute("profesores", profesores);
        session.setAttribute("matriculas", matriculas);
        session.setAttribute("personas", personas);
        session.setAttribute("grupos", grupos);
                
        request.setAttribute("mensaje", Mensajes.mensaje);
        
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
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
