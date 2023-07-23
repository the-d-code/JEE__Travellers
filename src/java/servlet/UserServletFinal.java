/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import ejb.UserBeanLocal;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UserServletFinal", urlPatterns = {"/UserServletFinal"})
public class UserServletFinal extends HttpServlet {

    @EJB UserBeanLocal pbl;

    
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserServletFinal</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserServletFinal at " + request.getContextPath() + "</h1>");
//            pbl.removeBookPackage(9);
            //========================================================USER=========================================================================
            //---------------------remove User--------------------------
        
                             // pbl.removeUser(2);
            //---------------------Update User--------------------------
        
//                              pbl.updateUser(8,"shruti","GOrasiya","h","shruti@gmail.com","98675434","shruti123",0);
       //-------------------------get all user by FirstName------------------------
            
//             Collection<User> users = pbl.getUserByFirstName("Radhika");
//             for(User c : users)
//             {
//              out.println("<br/>UserName : "+ c.getFirstName() + " LastName : " + c.getLastName());
//             }
        //----------------------get all user by id--------------------
//            
//         User user = pbl.getUserById(1);
//         out.println("<br/>UserName : "+ user.getFirstName() + " LastName : " + user.getLastName());

        //----------------------get all user list-----------------------
        
//        Collection<User> Users = pbl.getAllUser();
//            pbl.addUser("Radhika", "V","Maniya","Radhika@gmail.com","123456776","ju", Boolean.TRUE);
//
//            pbl.addUser("vaibhav", "h","gorasiya","vaibhav@gmail.com","123456776","ju", Boolean.TRUE);
//               for(User c : Users)
//          {
//            out.println("<br/>UserName : "+ c.getFirstName() + " LastName : " + c.getLastName());
//           }


//=====================================================BLOG=============================================================
        //---------------------remove BLog--------------------------
        
                          // pbl.removeBlog(1);
         //---------------------Update BLog--------------------------
        
                       // pbl.updateBlog(2,"aprilfoollll","dad","Questions1"," Answers1"," Description");

           //-----------------------------ADD BLog-----------------------------
     // pbl.addBlog("Radhika","image","quetion","answer","desc");
//
//            pbl.addBlog("Shruti","image1","quetion1","answer1","desc1");
           //----------------------get all BLOG list-----------------------
        
//        Collection<Blog> blogs = pbl.getAllBlog();
//        
//            
//               for(Blog c : blogs)
//          {
//            out.println("<br/>BlogName : "+ c.getBlogTitle()+ " desc : " + c.getDescription());
//           }
            
       //-------------------------get all BLog by BLogTitle------------------------
            
//             Collection<Blog> bloges = pbl.getBlogName("Radhika");
//             for(Blog c : bloges)
//             {
//              out.println("<br/>BlogName : "+ c.getBlogTitle()+ " desc : " + c.getDescription());
//             }
        //----------------------get all blog by id--------------------
//            Blog b=pbl.getBlogById(2);
//         
//         out.println("<br/>BlogName : "+ b.getBlogTitle()+ " desc : " + b.getDescription());
//
       
//==============================================PACKAGE BOOKING ======================================================
        //---------------------remove package--------------------------
        
//                              pbl.removeBookPackage(3);
         //---------------------Update package--------------------------
        
  //pbl.updateBookPackage(2,1,6,8," gfhjklj", 65432,null);

           //-----------------------------ADD bookpackage-----------------------------
// pbl.addBookPackagesInfo(4,3,6,"EmailID",12345,null);
//           pbl.addBookPackagesInfo(1,2,3,"EmailID123",1234589,null);

      //  pbl.addBookPackagesInfo(2,1,6,"EmailID123",1234589,null);
           //----------------------get all BOOKPACKAGE list-----------------------
        
//        Collection<PackageBooking> BOOKP = pbl.getAllPackageBooking();
//            
//               for(PackageBooking bp : BOOKP)
//          {
//              
//            out.println("<br/>NoOfTravelers package book: "+ bp.getNoOfTravelers()+ " ContactNumber : " + bp.getContactNumber()+ " EmailID : " + bp.getEmailID());
//           }
            
    
        //----------------------get all bookedpackage by id--------------------
//            PackageBooking b=pbl.getPackageBookingById(1);
//         
//         out.println("<br/>not for booking package: "+ b.getNoOfTravelers()+ " cont : " + b.getContactNumber());
////========================================================Package rating=========================================================================
//          
//            //---------------------Update PackageRate--------------------------
//        
//                              pbl.updateRating(1,1,1,2," Description");
//       
//
//        //----------------------get all package rate-----------------------
//        
//        Collection<PackageRating> pr = pbl.getAllPackageRate();
//            pbl.giveRating(1,4,1,"desc");
//
//            pbl.giveRating(4,1,1,"desc2"); 
//           
//               for(PackageRating prat : pr)
//          {
//            out.println("<br/>ratingstar for package rating : "+ prat.getRatingStar());
//           }
////==============================================PAYMENT ======================================================
//    
//         //---------------------Update Payment--------------------------
//        
   //pbl.updatePayment(1,1,1,7654,"7654567876",876,null);
//
//           //-----------------------------ADD bookpackage-----------------------------
// pbl.addPayment(3,4,654,"764",43423,new Date());
//          pbl.addPayment(1,2,6534,7624,43423,null);
////          pbl.addPayment(1,1,6454,87764,43423,null);
//           //----------------------get all BOOKPACKAGE list-----------------------
//        
//        Collection<Payment> p = pbl.getAllPayment();
//            
//               for(Payment pay : p)
//          {
//              
//            out.println("<br/>amount for book packages : "+ pay.getAmount());
//           }
//            
//    
//        //----------------------get all bookedpackage by id--------------------
//            Payment pay1=pbl.getPaymentByUserId(1);
//         
//         out.println("<br/>amount of user 1 : "+ pay1.getAmount());
////==============================================Cancel BOOKING======================================================
//      //-----------------------------ADD cancel booking-----------------------------
//          pbl.addCancelBooking(1,1,1,"delay",null);
////          pbl.addCancelBooking(2,2,1,"personal reason",null);
//           //----------------------get all BOOKPACKAGE list-----------------------
//        
//        Collection<CancelBooking> cb = pbl.getAllCancleBookingDeatil();
//            
//               for(CancelBooking cbook : cb)
//          {
//              
//            out.println("<br/>REasonForCanceling BOoking : "+ cbook.getReasonForCancel());
//           }
// //=====================================================Enquiry=============================================================
//        //---------------------remove ENQUIRY--------------------------
//        
//pbl.removeEnquiry(1);
//         //---------------------Update BLog--------------------------
//        
//                              pbl.updateEnquiry(1,1,98765432," EmailID"," Message");
//           //-----------------------------ADD BLog-----------------------------
//    pbl.addEnquiry(1,67687654," EmailID"," Message");
//            pbl.addEnquiry(6,76548765," EmailID1"," Message32");
//            pbl.addEnquiry(5,68712654," EmailID2"," Message46e56");
//           
//            //----------------------get all Enquiry list-----------------------
     
//        Collection<Enquiry>  e= pbl.getAllEnquiry();
//            
//               for(Enquiry eq : e)
//          {
//            out.println("<br/>Enquiry mailids : "+ eq.getEmailID());
//           }
//            
       
//    pbl.MultipleSearchOfPackageIndex(12, 5, 7000);
            
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
