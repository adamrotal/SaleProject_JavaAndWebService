/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import manasik.marketplace.AddProductWS_Service;
import manasik.marketplace.ClassNotFoundException_Exception;
import manasik.marketplace.SQLException_Exception;

/**
 *
 * @author afp
 */
public class AddProduct extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8081/SOAP/AddProduct_WS.wsdl")
    private AddProductWS_Service service;

  

    

    

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddProduct</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddProduct at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        HttpSession session = request.getSession();
        
        if(session.getAttribute("token") != null) {
            String token;
            token = session.getAttribute("token").toString();
            String urlParameters;
            String urlTarget;
            urlParameters = "token=" + URLEncoder.encode(token, "UTF-8");
            urlTarget = GeneralConstant.getURLRest("/RESTToken");
            String result = DoHttpRequest.executePost(urlTarget,urlParameters);
            if(result.equals("false")) {
                session.invalidate();
                response.sendRedirect("/JSP/Login");
                return;
            }
        } else {
            session.invalidate();
            response.sendRedirect("/JSP/Login");
            return;
        }
        request.setAttribute("username",session.getAttribute("username").toString());
        request.getRequestDispatcher("/WEB-INF/addProduct.jsp").forward(request, response);
        
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
        HttpSession session = request.getSession();
        String idPenjual =session.getAttribute("idUser").toString();
        String name ="aa";//kerjakan
        String description ="aa";//kerjakan
        String price ="1550";//kerjakan
        String gambar ="iphone_5s.jpg";//kerjakan
        String namaPenjual =session.getAttribute("username").toString();
        try {
            String succes = addProduk(idPenjual, name, description, price, gambar, namaPenjual);
        } catch (SQLException_Exception | ClassNotFoundException_Exception ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        response.sendRedirect("/JSP/YourProduct");
                
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

    private String addProduk(java.lang.String idPenjual, java.lang.String name, java.lang.String description, java.lang.String price, java.lang.String gambar, java.lang.String namaPenjual) throws SQLException_Exception, ClassNotFoundException_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        manasik.marketplace.AddProductWS port = service.getAddProductWSPort();
        return port.addProduk(idPenjual, name, description, price, gambar, namaPenjual);
    }

   

    

    

}
