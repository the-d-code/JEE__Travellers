/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import RestClient.rstClient;
import entity.Busdetails;
import entity.Category;
import entity.City;
import entity.Managehotel;
import entity.Offer;
import entity.Packages;
import entity.Places;
import entity.Role;
import entity.State;
import entity.SubPlaces;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Radhika Maniya
 */
@WebServlet(name = "RestAdminServlet", urlPatterns = {"/RestAdminServlet"})
public class RestAdminServlet extends HttpServlet {
Response res;
    //Response res1;
    rstClient  pbl;
    //restRadhikaClient pbl1;
    Collection<Packages> packages;
    GenericType<Collection<Packages>> gpackages;
    Collection<Places> places;
    GenericType<Collection<Places>> gplaces;
    Collection<SubPlaces> subplaces;
    GenericType<Collection<SubPlaces>> gsubplaces;
    Collection<City> city;
    GenericType<Collection<City>> gcity;
     Collection<Category> category;
    GenericType<Collection<Category>> gcategory;
    Collection<State> state;
    GenericType<Collection<State>> gstate;
    Collection<Busdetails> bus;
    GenericType<Collection<Busdetails>> gbus;
    Collection<Managehotel> hotel;
    GenericType<Collection<Managehotel>> ghotel;
     Collection<Offer> offer;
    GenericType<Collection<Offer>> goffer;
    Collection<Role> role;
    GenericType<Collection<Role>> grole;
    
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
            out.println("<title>Servlet RestAdminServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RestAdminServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            pbl =  new rstClient();
             //pbl1 =  new restRadhikaClient();
             
            gpackages= new GenericType<Collection<Packages>>(){};
             gsubplaces= new GenericType<Collection<SubPlaces>>(){};
            ghotel= new GenericType<Collection<Managehotel>>(){};
//========================================package           
//            res = pbl.getAllPackages(Response.class);
//pbl.giveRating("12", "3", "3", "abc");

//pbl.addPackages("xyz","2","1","4","4","3","4","999","13/01/2022","03/02/2022", "ds", "AS", "Dc", "df", "DAf");
//            pbl.addPackages("Arf", 1, 1, 2, 1, 23, "frt", "gyu", "gy", "tgh", "fh", "fgh", "gh");  
//            pbl.addPackages("asa"," 1", "1"," 23"," 2", "23", "2", "3", "ge", "Ert", "e", "SDf", "n");
//Collection<Packages> packages = res.readEntity(gpackages);
//            
//            for(Packages c : packages)
//            {
//             out.println("custId : "+ c.getPackageName()+ " Name : " + c.getScheduleDescription());
//            }
//     pbl.addPackages("fvbxf", "2", "2", "2", "2", "2", null, null, "dsf", "SDF", "Af", "DF", "AFC");
//     pbl.removePackages("10");
//     pbl.updatePackages("5", "abc", "2", "5", "2", "2", "300", null, null, "DSv", "EF", "edvc", "Fwe", "Fvdac");
//pbl.addPackages("mountain",2,3,1,1,1,new Date(),new Date(),"sdas","Sf","DFSA","SDF","fF");
//===========================places
//    pbl.addPlaces("2", "fdsfc", "2", "DVZdv");
//    pbl.updatePlaces("1", "2", "hello", "4", "fdsa");
//    pbl.removePlaces("2");
//        res=pbl.getAllPlaces(Response.class);
//       Collection<Places> places = res.readEntity(gplaces);
//            
//            for(Places c : places)
//            {
//             out.println("custId : "+ c.getPlaceName());
//            }
// ===========================subplaces(-------------NOT WORKING------------)
//pbl.addSplaces("2", "1", "radhika", "1", "1", "wqefgd");
//pbl.addSplaces("2", "1", "radhika", "1", "1", "wqefgd");
//pbl.addSplaces(CategoryID, PlaceID, SubPlaceName, StateID, CityID, Description);
//pbl.removeSplaces("2");
//pbl.updateSplaces("3", "2", "1", "maniya", "1", "1", ",mnbvc");

//pbl.addOffer("tst2", "true", "tst2", 200);
////=============================city
//pbl.addCity("surat", "1");
//pbl.addCity("ahemdabad", "1");
//pbl.updateCity("1", "update", "1");
//pbl.removeCity("1");
//
////===============================Bus
//pbl.addBus("ram travels", "20", "2", "3", "200", "10", "CSD", "Xv", "Sf", "SFC");
//pbl.updateBus("12", "radhika", "20", "2", "3", "200", "10", "CSD", "Xv", "Sf", "SFC");
//pbl.removeBus("11");
////==========================hotel
pbl.addHotel("dwarikadhish", 1300, "1", "8", "sdf", "hgfd", "jh", "hgfdtion");
pbl.addHotel("radhika", 1200, "1", "8", "Da", "ASD", "AD", "Ds");
//pbl.updateHotel("1", "ram", "200", "1", "1", "D", "d", "Da", "WEd");
//pbl.removeHotel("3");
////=========================offer
//pbl.addOffer("31st", "0", "gdfvs");
//pbl.updateOffer("1", "3111", "0", "zacd");
//pbl.removeOffer("1");
//============================category
//pbl.addCategory("abc", "CDsa");
//pbl.updateCategory("2", "sea", "beach");
//pbl.removeCategory("3");
//res=pbl.getAllCategory(Response.class);
//Collection<Category> category = res.readEntity(gcategory);
//            
//            for(Category c : category)
//            {
//             out.println("custId : "+ c.getCategoryName());
//            }

//  ================================state
//Collection<State> states = res.readEntity(gstate);
//            
//            for(State c : states)
//            {
//             out.println("custId : "+ c.getStateName());
//            }
//           pbl.removeState("6");
//          pbl.updateState("2", "kerela");
//           pbl.addState("tamilnadu");
//  pbl.addEnquiry("1","98765432"," EmailID"," Message");

//pbl.addBookPackagesInfo("4", "3", "4", "radhika@gmail.com", "98762543", "02/02/2022");
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
