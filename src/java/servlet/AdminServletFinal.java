/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import ejb.AdminBeanLocal;
import entity.Busdetails;
import entity.Category;
import entity.City;
import entity.Managehotel;
import entity.Offer;
import entity.Packages;
import entity.Places;
import entity.State;
import entity.SubPlaces;
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
@WebServlet(name = "AdminServletFinal", urlPatterns = {"/AdminServletFinal"})
public class AdminServletFinal extends HttpServlet {
@EJB AdminBeanLocal pbl;
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
            out.println("<title>Servlet AdminServletFinal</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminServletFinal at " + request.getContextPath() + "</h1>");
            
            
              
//*************************************Package Testing******************************************
//pbl.addPackages("beach in goa", 12, 1, 4, 4, 6, 7, 7000, new Date(),new Date(), "sdas","Sf","DFSA","SDF","fF");
//           pbl.addPackages("second",2,2,3,3,30000,new Date(),new Date(),"jkhjghj","hjkhk","hjvhjhj", "hgj","ghccghcgfcgf");
//            pbl.addPackages("first",2,2,2,3,300,null ,null,"jkhjghj","hjkhk","hjvhjhj", "hgj","ghccghcgfcgf");
//           pbl.updatePackages(1,"FIrstttt",1,3,2,30,10,null ,null,"jkhjghj","hjkhk","hjvhjhj", "hgj","ghccghcgfcgf");
           // pbl.removePackages(2);
            // Collection<Packages> packages = pbl.SearchPacagesByName("second");
             //for(Packages p : packages)
            // {
             // out.println("<br/>PackageName : "+ p.getPackageName() + " Charge : " + p.getPackageCharge());
             //}
            // Packages packages = pbl.SearchPacagesById(1);
             //out.println("<br/>PackageName : "+ packages.getPackageName() + " Charge : " + packages.getPackageCharge());
             
             
           
//**********************************Ctaegory Testing******************************************


             //================get all Category list=============
       
//                       Collection<Category> Categories = pbl.getAllCategory();
//
//                              for(Category c : Categories)
//                         {
//                           out.println("<br/>CategoryName : "+ c.getCategoryName()+ " desc : " + c.getDescription());
//                          }

               //               pbl.addCategory("beach", "asjdgag sjdhjasdbasj");
               //               pbl.addCategory("mountain", "asjdgag sjdhjasdbasj");
               //               pbl.addCategory("historical", "asjdgag sjdhjasdbasj");
                //================get all Category by Name=============            
               //             Collection<Category> Categories = pbl.getCategoryDetail("mountain");
               //             for(Category c : Categories)
               //             {
               //              out.println("<br/>CategoryName : "+ c.getCategoryName()+ " desc : " + c.getDescription());
               //             }
               //    pbl.updateCategory(1, "beachhh", "gugjjhv hvhjvh");
               //          //pbl.removeCategory(1);

               

//************************************state Testing******************************************


//                        Collection<State> states = pbl.getAllState();
//                        for(State s : states)
//                        {
//                           out.println("<br/>StateID : "+ s.getStateID()+ " StateName : " + s.getStateName());
//                        }
                         //pbl.addState("maharashtra");
                         // pbl.updateState(2,"Maharashtra");
                          //pbl.removeState(2);
                          
         
//*************************************Offer******************************************

            // pbl.addOffer("SecondPAckageOffer",Boolean.TRUE,"bjhvjhhjvh");
                // Collection<Offer> offers = pbl.getAllOffer();
                 //Collection<Offer> offers = pbl.getOfferByName("SecondPAckageOffer");
                 //Offer offers = pbl.getOfferById(1);
                 
                 //for(Offer o : offers)
                 //{
                 //     out.println("<br/>OfferName : "+ o.getOfferName() + " Description : " + o.getDescription());
                // }
                //pbl.removeOffer(2);
                //pbl.updateOffer(1,"FirstOffferrr", Boolean.TRUE, "firstttttt");
              
                
                
//*************************************City******************************************

                   // Collection<City> city = pbl.getAllCity();
                    //for(City c : city)
                   //{
                     // out.println("<br/>CityID : "+ c.getCityID()+ " CityName : " + c.getCityName());
                   //}
//                    pbl.addCity("Bhavnagar", 1);
//                    pbl.addCity("Baroda", 1);
                   // pbl.updateCity(1,"SURAT",1);
                      //pbl.removeCity(2);
                     

//*************************************Places******************************************

//             Collection<Places> place = pbl.getAllPlaces();
////              Collection<Places> place = pbl.SerchPlaces("Dwarika");
//              for(Places p : place )
//              {
//                  out.println("<br/>Placename : "+p.getPlaceName()+ " Description : " + p.getDescription());
//              }
              //pbl.addPlaces(1,"Dwarika",1,"Lord Krishna");
              // pbl.addPlaces(1,"Somnath",1,"Lord Krishna");
              //pbl.addPlaces(1,"sdas",1,"sadasds");
               //pbl.updatePlaces(1,1,"DWARIKA",1,"MY Krishna");
               //pbl.removePlaces(3);
               
               
//*************************************SubPlaces******************************************
//               pbl.addSplaces(2,1,"abc",1,1,"ghhghh");
//               pbl.addSplaces(2,1,"xyz",1,1,"ghhghh");
              //Collection<SubPlaces> splace = pbl.getAllSplaces();
             //Collection<SubPlaces> splace = pbl.SerchSubPlaces("Rrrr");
              //for(SubPlaces sp : splace)
              //{
               //   out.println("<br/>SubPlacename : "+sp.getSubPlaceName()+ " Description : " + sp.getDescription());
              //}
              //pbl.updateSplaces(2,2,1,"RRR",1,1,"ghhghh");
             // pbl.removeSplaces(2);
             
             
//*************************************Manage Hotel******************************************

//                 pbl.addHotel("abcdggu", 6000,1, 8, "hghh", "bhjjb", "hgjvjv","jhhgjhghj");
//                 pbl.addHotel("abc", 6000,1, 1, "hghh", "bhjjb", "hgjvjv","jhhgjhghj");
//                Collection<ManageHotel> mhotel = pbl.getHotelName("honest");
                //for(ManageHotel mh : mhotel)
                //{
                 //   out.println("<br/>Hotelname : " + mh.getHotelName()+ " Charge : " + mh.getCostPerRoom());
                //}
               //  pbl.updateHotel(1,"honest", 6000,1, 1, "hghh", "bhjjb", "hgjvjv","jhhgjhghj");
                 //pbl.removeHotel(2);


 
//*************************************Bus Details******************************************
//  pbl.addBus("abccc",20, 8, 8, 200, 19, "Image1", "Image2", "Image3", "Description");

//
// Collection<BusDetails> splace = pbl.getAllBus();
//              for(BusDetails sp : splace)
//              {
//                  out.println("<br/>busname : "+sp.getBusName()+ " image : " + sp.getImage1());
//              }

//pbl.addBus(BusName, Integer.BYTES, Integer.SIZE, Integer.SIZE, Integer.BYTES, Integer.MIN_VALUE, Image1, Image2, Image3, Description);
            
//            Collection<City> splace = pbl.getAllCityByStateId(1);
//              for(Packages sp : splace)
//              {
//                  out.println("<br/>busname : "+sp.getPackageName()+ " image : " + sp.getNoOfDays());
//              }
//    pbl.addOffer("test", true, "test", 300);
           pbl.GetPackageByCatID(12);
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
