///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package servlet;
//
//import ejb.UserBeanLocal;
//import entity.User;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Collection;
//import javax.ejb.EJB;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
//public class UserServlet extends HttpServlet {
//    @EJB UserBeanLocal pbl;
//
//   
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//          
//        //================remove User=============     
//        
//             pbl.removeUser(2);
//            
//       //================get all user by FirstName=============
//            
////             Collection<User> users = pbl.getUserByFirstName("shruti");
////             for(User c : users)
////             {
////              out.println("<br/>UserName : "+ c.getFirstName() + " LastName : " + c.getLastName());
////             }
//
// //================get all user by id=============
////            
////             User users = pbl.getUserById(1);
////             
////              out.println("<br/>UserName : "+ users.getFirstName() + " LastName : " + users.getLastName());
////             
//
//        //================get all user list=============
//        
//        //Collection<User> Users = pbl.getAllUser();
//        
//            //pbl.addUser("vaibhav", "h","gorasiya","vaibhav@gmail.com","123456776","ju", Boolean.TRUE);
////               for(User c : Users)
////          {
////            out.println("<br/>UserName : "+ c.getFirstName() + " LastName : " + c.getLastName());
////           }
//
//
//
//           
//        }
//    }
//
//   
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//   
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }
//
//}
