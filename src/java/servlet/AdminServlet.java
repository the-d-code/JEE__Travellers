///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package servlet;
//
//import ejb.AdminBeanLocal;
//import static entity.Payment_.date;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.text.ParseException;
//import java.time.format.DateTimeFormatter;
//import javax.ejb.EJB;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.eclipse.persistence.jpa.jpql.parser.DateTime;
//
///**
// *
// * @author Admin
// */
//@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
//public class AdminServlet extends HttpServlet {
// @EJB AdminBeanLocal pbl;
// 
// protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, ParseException {
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//           //================get all Category list=============
//        
////        Collection<Category> Categories = pbl.getAllCategory();
////         
////               for(Category c : Categories)
////          {
////            out.println("<br/>CategoryName : "+ c.getCategoryName()+ " desc : " + c.getDescription());
////           }
//               
////               pbl.addCategory("beach", "asjdgag sjdhjasdbasj");
////               pbl.addCategory("mountain", "asjdgag sjdhjasdbasj");
////               pbl.addCategory("historical", "asjdgag sjdhjasdbasj");
//
//               //================get all Category by Name=============
//            
////             Collection<Category> Categories = pbl.getCategoryDetail("mountain");
////             for(Category c : Categories)
////             {
////              out.println("<br/>CategoryName : "+ c.getCategoryName()+ " desc : " + c.getDescription());
////             }
//
//
////     pbl.updateCategory(1, "beachhh", "gugjjhv hvhjvh");
//          //pbl.removeCategory(1);
//          
//          
////          =========================Packages=================
//
//  pbl.addPackages("first", 1,1,2,2,300,null ,null,"jkhjghj","hjkhk","hjvhjhj", "hgj","ghccghcgfcgf");
//
//
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
