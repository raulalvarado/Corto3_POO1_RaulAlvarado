/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vistas;

import com.sv.udb.contoladores.controlPrestamos;
import com.sv.udb.modelos.libros;
import com.sv.udb.modelos.prestamos;
import com.sv.udb.modelos.usuarios;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Henry
 */
@WebServlet(name = "vistaPrestamos", urlPatterns = {"/vistaPrestamos"})
public class vistaPrestamos extends HttpServlet {

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
        boolean esValido = request.getMethod().equals("POST");
        boolean flag = true;
        String mens = "";

        if(!esValido)
        {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
        else
        {
            try{
            String CRUD = request.getParameter("btonBode");
            if(CRUD.equals("Guardar"))
            {   
                libros libro = new libros();
                libro.setCodilib(Integer.parseInt(request.getParameter("libro")));
                usuarios usuario = new usuarios();
                usuario.setCodiusua(Integer.parseInt(request.getParameter("usuario")));
                prestamos prestamo = new prestamos();
                prestamo.setLibro(libro);
                prestamo.setUsuario(usuario);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
                Date fecha = format.parse(request.getParameter("fecha_pres"));
                prestamo.setFechaprest(fecha);
                if(new controlPrestamos().agregarPrestamo(prestamo)){
                    mens="Datos guardados";
                }else{
                    mens="Error al guardar";
                }
            }
            
            else if(CRUD.equals("Consultar"))
            {
                int codi = Integer.parseInt(request.getParameter("codi_pres") == null ? "-1" : 
                        request.getParameter("codi_pres"));
                prestamos obje = new controlPrestamos().obtenerPorId(codi);
                if(obje != null)
                {
                    request.setAttribute("codigo", obje.getCodipres());
                    request.setAttribute("libro", String.valueOf(obje.getLibro().getCodilib()));
                    request.setAttribute("usuario",String.valueOf(obje.getUsuario().getCodiusua()));
                    request.setAttribute("fecha_pres", new SimpleDateFormat("dd-MM-yyyy").format(obje.getFechaprest()));
                    mens = "Información consultada";
                    request.setAttribute("estaModi", "true"); //Esta modificando
                    flag = true;
                }
                else
                {
                    mens = "Error al consultar";
                }
            }
            
            }catch(Exception e){
                mens = e.getMessage();
                System.err.print(mens);
            }
        }
            request.setAttribute("mensAler", mens);
            request.setAttribute("valid",flag);
            request.getRequestDispatcher("/prestamos.jsp").forward(request, response);
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
