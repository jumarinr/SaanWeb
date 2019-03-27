/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.administrador;

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
import javax.swing.JOptionPane;
import models.Estudiante;
import models.Grupo;
import models.Materia;
import models.Matricula;
import models.Nota;
import models.Persona;
import models.Profesor;
import util.Mensajes;
import util.extra;

/**
 *
 * @author Juan Pablo
 */
@WebServlet(urlPatterns = {"/administrador_buscarAdministrador"})
public class AdminBuscarMateria extends HttpServlet {

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
        List<Materia> materias = new ArrayList<Materia>();
        HttpSession session = request.getSession();
        if (session.getAttribute("materias") != null) {
            materias = (ArrayList<Materia>) session.getAttribute("materias");
        }
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            Materia mat = null;
            mat = Materia.buscarMateria(materias, id);
            request.setAttribute("mat",  mat);
        }
        request.setAttribute("mensaje", Mensajes.mensaje);
        request.setAttribute("usua", session.getAttribute("usua"));
        RequestDispatcher view = request.getRequestDispatcher("adminBusMateria.jsp");
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
        //Eliminar
        List<Materia> materias = new ArrayList<Materia>();
        List<Nota> notas = new ArrayList<Nota>();
        List<Matricula> matriculas = new ArrayList<Matricula>();
        List<Grupo> grupos = new ArrayList<Grupo>();
        HttpSession session = request.getSession();
        if(session.getAttribute("notas") != null) {
            notas = (ArrayList<Nota>) session.getAttribute("notas");
        }
        if(session.getAttribute("materias") != null) {
            materias = (ArrayList<Materia>) session.getAttribute("materias");
        }
        if(session.getAttribute("matriculas") != null) {
            matriculas = (ArrayList<Matricula>) session.getAttribute("matriculas");
        }
        if(session.getAttribute("grupos") != null) {
            grupos = (ArrayList<Grupo>) session.getAttribute("grupos");
        }
        if (session.getAttribute("materias") != null) {
            materias = (ArrayList<Materia>) session.getAttribute("materias");
        }
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar este registro",
                    "SAAN", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, Materia.eliminar(materias, grupos, matriculas, notas, id), "SAAN",
                        JOptionPane.INFORMATION_MESSAGE);
                session.setAttribute("materias", materias);
            }
        }
        request.setAttribute("mensaje", Mensajes.mensaje);
        request.setAttribute("usua", session.getAttribute("usua"));
        RequestDispatcher view = request.getRequestDispatcher("adminBusPersona.jsp");
        view.forward(request, response);
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
