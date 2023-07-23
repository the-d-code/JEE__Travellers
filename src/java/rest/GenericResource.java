/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import entity.Blog;
import entity.Busdetails;
import entity.Cancelbooking;
import entity.Category;
import entity.City;
import entity.Enquiry;
import entity.Managehotel;
import entity.Offer;
import entity.Packagebooking;
import entity.Packagerating;
import entity.Packages;
import entity.Payment;
import entity.Places;
import entity.Role;
import entity.State;
import entity.SubPlaces;
import entity.User;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 * REST Web Service
 *
 * @author Radhika Maniya
 */
@Path("generic")
public class GenericResource {
    @EJB AdminBeanLocal pbl;
    @EJB UserBeanLocal pbl2;
    @Context
    private UriInfo context;

    public GenericResource() {
    }
    //==========================Packages====================
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getAllPackages")
    public Collection<Packages> getAllPackages() {
       return pbl.getAllPackages();
    }
    
    @Path("addPackages/{PackageName}/{CategoryID}/{StateID}/{BusID}/{HotelID}/{NoOfDays}/{NoOfNights}/{PackageCharge}/{FromDate}/{ToDate}/{Image1}/{Image2}/{Image3}/{Image4}/{ScheduleDescription}")
    @POST
    public void addPackages(@PathParam("PackageName") String PackageName,@PathParam("CategoryID") Integer CategoryID,@PathParam("StateID") Integer StateID,@PathParam("BusID") Integer BusID,@PathParam("HotelID") Integer HotelID,@PathParam("StateID") Integer NoOfDays,@PathParam("NoOfNights") Integer NoOfNights,@PathParam("PackageCharge") Integer PackageCharge,@PathParam("FromDate") Date FromDate,@PathParam("ToDate") Date ToDate,@PathParam("Image1") String Image1,@PathParam("Image2") String Image2,@PathParam("Image3") String Image3,@PathParam("Image4") String Image4,@PathParam("ScheduleDescription") String ScheduleDescription) {
           pbl.addPackages(PackageName, CategoryID, StateID, BusID, HotelID, NoOfDays, NoOfNights, PackageCharge, FromDate, ToDate, Image1, Image2, Image3, Image4, ScheduleDescription);
    }
    
    
    @Path("updatePackages/{PackageID}/{PackageName}/{CategoryID}/{StateID}/{NoOfDays}/{NoOfNights}/{PackageCharge}/{FromDate}/{ToDate}/{Image1}/{Image2}/{Image3}/{Image4}/{ScheduleDescription}")
    @POST
    public void updatePackages(@PathParam("PackageID") Integer PackageID, @PathParam("PackageName") String PackageName,@PathParam("CategoryID") Integer CategoryID,@PathParam("StateID") Integer StateID,@PathParam("StateID") Integer NoOfDays,@PathParam("NoOfNights") Integer NoOfNights,@PathParam("PackageCharge") Integer PackageCharge,@PathParam("FromDate") Date FromDate,@PathParam("ToDate") Date ToDate,@PathParam("Image1") String Image1,@PathParam("Image2") String Image2,@PathParam("Image3") String Image3,@PathParam("Image4") String Image4,@PathParam("ScheduleDescription") String ScheduleDescription) {
      pbl.updatePackages(PackageID, PackageName, CategoryID, StateID, NoOfDays, NoOfNights, PackageCharge, FromDate, ToDate, Image1, Image2, Image3, Image4, ScheduleDescription);
    }
    

    @Path("removePackages/{PackageID}")
    @DELETE
    public void removePackages(@PathParam("PackageID") Integer PackageID) {
         pbl.removePackages(PackageID);
    
    }
    @GET
//    @Consumes(MediaType.APPLICATION_JSON)//only when collctions
    @Produces(MediaType.APPLICATION_XML)
    @Path("SearchPacagesByName/{PackageName}")
    public Collection<Packages> SearchPacagesByName(@PathParam("PackageName") String PackageName) {
          return pbl.SearchPacagesByName(PackageName);
    }
  
    
   @GET
//    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    @Path("SearchPacagesById/{PackageID}")
    public Packages SearchPacagesById(@PathParam("PackageID") Integer PackageID) {
        return pbl.SearchPacagesById(PackageID);
    }

//    =======================================Places=======================================
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getAllPlaces")
    public Collection<Places> getAllPlaces() {
         return pbl.getAllPlaces();
    }

    @Path("addPlaces/{CategoryID}/{PlaceName}/{StateID}/{Description}")
    @POST
    public void addPlaces(@PathParam("CategoryID") Integer CategoryID,@PathParam("PlaceName") String PlaceName,@PathParam("StateID") Integer StateID,@PathParam("Description") String Description) {
      pbl.addPlaces(CategoryID, PlaceName, StateID, Description);
    }

    @Path("updatePlaces/{PlaceID}/{CategoryID}/{PlaceName}/{StateID}/{Description}")
    @POST
    public void updatePlaces(@PathParam("PlaceID") Integer PlaceID,@PathParam("CategoryID") Integer CategoryID,@PathParam("PlaceName") String PlaceName,@PathParam("StateID") Integer StateID,@PathParam("Description") String Description) {
         pbl.updatePlaces(PlaceID, CategoryID, PlaceName, StateID, Description);
    }

    @Path("removePlaces/{PlaceID}")
    @DELETE
    public void removePlaces(@PathParam("PlaceID") Integer PlaceID) {
        pbl.removePlaces(PlaceID);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    @Path("SerchPlaces/{pname}")
    public Collection<Places> SerchPlaces(@PathParam("pname") String pname) {
        return pbl.SerchPlaces(pname);
    }

//    ==================================================subPlaces=============================
     @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getAllSplaces")
    public Collection<SubPlaces> getAllSplaces() {
       return pbl.getAllSplaces();
    }
    
    @Path("addSplaces/{CategoryID}/{PlaceID}/{SubPlaceName}/{StateID}/{CityID}/{Description}")
    @POST
    public void addSplaces(@PathParam("CategoryID") Integer CategoryID,@PathParam("PlaceID") Integer PlaceID,@PathParam("SubPlaceName") String SubPlaceName,@PathParam("StateID") Integer StateID,@PathParam("CityID") Integer CityID,@PathParam("Description") String Description) {
          pbl.addSplaces(CategoryID, PlaceID, SubPlaceName, StateID, CityID, Description);
    }

    @Path("updateSplaces/{SubPlaceID}/{CategoryID}/{PlaceID}/{SubPlaceName}/{StateID}/{CityID}/{Description}")
    @POST
    public void updateSplaces(@PathParam("SubPlaceID") Integer SubPlaceID,@PathParam("CategoryID") Integer CategoryID,@PathParam("PlaceID") Integer PlaceID,@PathParam("SubPlaceName") String SubPlaceName,@PathParam("StateID") Integer StateID,@PathParam("CityID") Integer CityID,@PathParam("Description") String Description) {
       pbl.updateSplaces(SubPlaceID, CategoryID, PlaceID, SubPlaceName, StateID, CityID, Description);
    }
    @Path("removeSplaces/{SubPlaceID}")
    @DELETE
    public void removeSplaces(@PathParam("SubPlaceID") Integer SubPlaceID) {
         pbl.removeSplaces(SubPlaceID);
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    @Path("SerchSubPlaces/{spname}")
    public Collection<SubPlaces> SerchSubPlaces(@PathParam("spname") String spname) {
         return pbl.SerchSubPlaces(spname);
    }

//    ================================================City======================================
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getAllCity")
    public Collection<City> getAllCity() {
        return pbl.getAllCity();
    }

    @Path("addCity/{CityName}/{StateID}")
    @POST
    public void addCity(@PathParam("CityName") String CityName,@PathParam("StateID") Integer StateID) {
       pbl.addCity(CityName, StateID);
    }
    @Path("updateCity/{CityID}/{CityName}/{StateID}")
    @POST
    public void updateCity(@PathParam("CityID") Integer CityID,@PathParam("CityName") String CityName,@PathParam("StateID") Integer StateID) {
        pbl.updateCity(CityID, CityName, StateID);
    }

    @Path("removeCity/{CityID}/{StateID}")
    @DELETE
    public void removeCity(@PathParam("CityID") Integer CityID,@PathParam("StateID") Integer StateID) {
        pbl.removeCity(CityID,StateID);
    }

    
    //========================category======================
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getAllCategory")
    public Collection<Category> getAllCategory() {
        return pbl.getAllCategory();
    }

    @Path("addCategory/{CategoryName}/{Description}/{Image}")
    @POST
    public void addCategory(@PathParam("CategoryName") String CategoryName,@PathParam("Description") String Description,@PathParam("Image") String Image) {
       pbl.addCategory(CategoryName, Description,Image);
    }

    @Path("updateCategory/{CategoryID}/{CategoryName}/{Description}/{Image}")
    @POST
    public void updateCategory(@PathParam("CategoryID") Integer CategoryID,@PathParam("CategoryName") String CategoryName,@PathParam("Description") String Description,@PathParam("Image") String Image) {
       pbl.updateCategory(CategoryID, CategoryName, Description,Image);
        
    } 
    @Path("removeCategory/{CategoryID}")
    @DELETE
    public void removeCategory(@PathParam("CategoryID") Integer CategoryID) {
        pbl.removeCategory(CategoryID);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    @Path("getCategoryDetail/{cname}")
    public Collection<Category> getCategoryDetail(@PathParam("cname") String cname) {
      return pbl.getCategoryDetail(cname);
    }

    //==============================state===================
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getAllState")
    public Collection<State> getAllState() {
        return pbl.getAllState();
    }

    @Path("addState/{StateName}")
    @POST
    public void addState(@PathParam("StateName") String StateName) {
      pbl.addState(StateName);
    }

    @Path("updateState/{StateID}/{StateName}")
    @POST
    public void updateState(@PathParam("StateID") Integer StateID,@PathParam("StateName") String StateName) {
        pbl.updateState(StateID, StateName);
    }

    @Path("removeState/{StateID}")
    @DELETE
    public void removeState(@PathParam("StateID") Integer StateID) {
          pbl.removeState(StateID);
    }

//    ==========================================Bus========================
   @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getAllBus")
    public Collection<Busdetails> getAllBus() {
        return pbl.getAllBus();
    }

    @Path("addBus/{BusName}/{TotalSeats}/{FromCityID}/{ToCityID}/{CostPerSeat}/{AvailableSeat}/{Image1}/{Image2}/{Image3}/{Description}")
    @POST
    public void addBus(@PathParam("BusName") String BusName,@PathParam("TotalSeats") Integer TotalSeats,@PathParam("FromCityID") Integer FromCityID,@PathParam("ToCityID") Integer ToCityID,@PathParam("CostPerSeat") Integer CostPerSeat,@PathParam("AvailableSeat") Integer AvailableSeat,@PathParam("Image1") String Image1,@PathParam("Image2") String Image2,@PathParam("Image3") String Image3,@PathParam("Description") String Description) {
       pbl.addBus(BusName, TotalSeats, FromCityID, ToCityID, CostPerSeat, AvailableSeat, Image1, Image2, Image3, Description);
    }

    @Path("updateBus/{BusID}/{BusName}/{TotalSeats}/{FromCityID}/{ToCityID}/{CostPerSeat}/{AvailableSeat}/{Image1}/{Image2}/{Image3}/{Description}")
    @POST
    public void updateBus(@PathParam("BusID") Integer BusID,@PathParam("BusName") String BusName,@PathParam("TotalSeats") Integer TotalSeats,@PathParam("FromCityID") Integer FromCityID,@PathParam("ToCityID") Integer ToCityID,@PathParam("CostPerSeat") Integer CostPerSeat,@PathParam("AvailableSeat") Integer AvailableSeat,@PathParam("Image1") String Image1,@PathParam("Image2") String Image2,@PathParam("Image3") String Image3,@PathParam("Description") String Description) {
       pbl.updateBus(BusID, BusName, TotalSeats, FromCityID, ToCityID, CostPerSeat, AvailableSeat, Image1, Image2, Image3, Description);
    }

    @Path("removeBus/{BusID}/{FromCityID}/{ToCityID}")
    @DELETE
    public void removeBus(@PathParam("BusID") Integer BusID,@PathParam("FromCityID") Integer FromCityID,@PathParam("ToCityID") Integer ToCityID) {
       pbl.removeBus(BusID,FromCityID,ToCityID);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    @Path("getBusName/{Bname}")
    public Collection<Busdetails> getBusName(@PathParam("Bname") String Bname) {
      return pbl.getBusName(Bname);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    @Path("getBusById/{BusID}")
    public Busdetails getBusById(@PathParam("BusID") Integer BusID) {
        return pbl.getBusById(BusID);
    
    }

//    =====================================hotel============================================
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getAllHotel")
    public Collection<Managehotel> getAllHotel() {
        return pbl.getAllHotel();
    }

    @Path("addHot/{HName}/{CPRoom}/{StaID}/{CitID}/{Img1}/{Img2}/{Img3}/{Descri}")
    @POST
    public void addHotel(@PathParam("HName") String HotelName,@PathParam("CPRoom") Integer CostPerRoom,@PathParam("StaID") Integer StateID,@PathParam("CitID") Integer CityID,@PathParam("Img1") String Image1,@PathParam("Img2") String Image2,@PathParam("Img3") String Image3,@PathParam("Descri") String Description) {
        pbl.addHotel(HotelName, CostPerRoom, StateID, CityID, Image1, Image2, Image3, Description);
    }

    @Path("updateHotel/{HotelID}/{HotelName}/{CostPerRoom}/{StateID}/{CityID}/{Image1}/{Image2}/{Image3}/{Description}")
    @POST
    public void updateHotel(@PathParam("HotelID") Integer HotelID,@PathParam("HotelName") String HotelName,@PathParam("CostPerRoom") Integer CostPerRoom,@PathParam("StateID") Integer StateID,@PathParam("CityID") Integer CityID,@PathParam("Image1") String Image1,@PathParam("Image2") String Image2,@PathParam("Image3") String Image3,@PathParam("Description") String Description) {
    }

//    @Path("removeHotel/{HotelID}")
//    @DELETE
//    public void removeHotel(@PathParam("HotelID")Integer HotelID) {
//          pbl.removeHotel(HotelID);
//    }
    @Path("removeHotel/{HotelID}/{StateID}/{CityID}")
    @DELETE
    public void removeHotel(@PathParam("HotelID") Integer HotelID,@PathParam("StateID") Integer StateID,@PathParam("CityID") Integer CityID){
        pbl.removeHotel(HotelID, StateID, CityID);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    @Path("getHotelName/{Hname}")
    public Collection<Managehotel> getHotelName(@PathParam("Hname") String Hname) {
     return pbl.getHotelName(Hname);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    @Path("getHotelById/{HotelID}")
    public Managehotel getHotelById(@PathParam("HotelID") Integer HotelID) {
        return pbl.getHotelById(HotelID);
    }
    
//    ===============================================Offer=========================================

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getAllOffer")
    public Collection<Offer> getAllOffer() {
        return pbl.getAllOffer();
    }

     @Path("addOffer/{OfferName}/{IsSpecial}/{Description}/{Price}")
    @POST
    public void addOffer(@PathParam("OfferName") String OfferName,@PathParam("IsSpecial") Boolean IsSpecial,@PathParam("Description") String Description ,@PathParam("Price") Integer Price) {
        pbl.addOffer(OfferName, IsSpecial, Description,Price);
    }

    @Path("updateOffer/{OfferID}/{OfferName}/{IsSpecial}/{Description}/{Price}")
    @POST
    public void updateOffer(@PathParam("OfferID") Integer OfferID,@PathParam("OfferName") String OfferName,@PathParam("IsSpecial") Boolean IsSpecial,@PathParam("Description") String Description,@PathParam("Price") Integer Price) {
      pbl.updateOffer(OfferID, OfferName, IsSpecial, Description,Price);
    }

    @Path("removeOffer/{OfferID}")
    @DELETE
    public void removeOffer(@PathParam("OfferID") Integer OfferID) {
          pbl.removeOffer(OfferID);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    @Path("getOfferByName/{oname}")
    public Collection<Offer> getOfferByName(@PathParam("oname") String oname) {
     return pbl.getOfferByName(oname);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    @Path("getOfferById/{OfferID}")
    public Offer getOfferById(@PathParam("OfferID") Integer OfferID) {
        return pbl.getOfferById(OfferID);
    }

//    =================================================ROle==================================
//    @Path("addRole/{RoleName}/{UserName}/{CreatedAt}/{UpdatedAt}")
//    @POST
//    public void addRole(@PathParam("RoleName") String RoleName,@PathParam("UserName") String UserName,@PathParam("CreatedAt") DateTime CreatedAt,@PathParam("UpdatedAt") DateTime UpdatedAt) {
//         pbl.addRole(RoleName, UserName, CreatedAt, UpdatedAt);
//    }
//
//    @Path("updateRole/{RoleID}/{RoleName}/{UserName}/{CreatedAt}/{UpdatedAt}")
//    @POST
//    public void updateRole(@PathParam("RoleID") Integer RoleID,@PathParam("RoleName") String RoleName,@PathParam("UserName") String UserName,@PathParam("CreatedAt") DateTime CreatedAt,@PathParam("UpdatedAt") DateTime UpdatedAt) {
//        pbl.updateRole(RoleID, RoleName, UserName, CreatedAt, UpdatedAt);
//    }

//    @Path("removeRole/{RoleID}")
//    @DELETE
//    public void removeRole(@PathParam("RoleID") Integer RoleID) {
//         pbl.removeRole(RoleID);
//    }
    //    ==================================user rest===========================
   
    
     @GET
    @Produces(MediaType.APPLICATION_XML)
     @Path("getAlluser")
      public Collection<User> getAllUser() {
         return pbl2.getAllUser();
      }
      
      @Path("adduser/{FirstName}/{MiddleName}/{LastName}/{EmailID}/{ContactNumber}/{Password}/{IsActive}")
      @POST
       public void addUser(@PathParam("FirstName") String FirstName,@PathParam("MiddleName") String MiddleName,@PathParam("LastName") String LastName,@PathParam("EmailID") String EmailID,@PathParam("ContactNumber") String ContactNumber,@PathParam("Password") String Password,@PathParam("IsActive") Boolean IsActive)
       {
       pbl2.addUser(FirstName, MiddleName, LastName, EmailID, ContactNumber, Password, IsActive);
       }
       
       @Path("updateuser/{UserID}/{FirstName}/{MiddleName}/{LastName}/{EmailID}/{ContactNumber}/{Password}/{IsActive}")
       @POST
         public void updateUser(@PathParam("UserID") Integer UserID,@PathParam("FirstName") String FirstName,@PathParam("MiddleName") String MiddleName,@PathParam("LastName") String LastName,@PathParam("EmailID") String EmailID,@PathParam("ContactNumber") String ContactNumber,@PathParam("Password") String Password,@PathParam("IsActive") Boolean IsActive) 
        {
            pbl2.updateUser(UserID, FirstName, MiddleName, LastName, EmailID, ContactNumber, Password, IsActive);
        }
        @Path("removeuser/{UserID}")
        @DELETE
        public void removeUser(@PathParam("UserID") Integer UserID)
        {
            pbl2.removeUser(UserID);
        }
        
     @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getuserByFirstName/{fname}") 
         public Collection<User> getUserByFirstName(@PathParam("fname") String fname) 
         {
             return pbl2.getUserByFirstName(fname);
         }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getuserById/{UserID}") 
          public Collection<User> getUserById(@PathParam("UserID") Integer UserID) 
         {
             return pbl2.getUserById(UserID);
         }
       @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getUserByEmailPassword/{emailID}/{password}") 
         public User getUserByEmailPassword(@PathParam("emailID") String emailID,@PathParam("password") String password) 
         {
             return pbl2.getUserByEmailPassword(emailID,password);
         }  
    @GET
    @Produces(MediaType.APPLICATION_XML)
     @Path("getAllblog") 
      public Collection<Blog> getAllBlog()
      {
         return pbl2.getAllBlog();
      }
      
      @Path("addblog/{BlogTitle}/{BlogImage}/{Questions}/{Answers}/{Description}")
      @POST
      public void addBlog(@PathParam("BlogTitle") String BlogTitle,@PathParam("BlogImage") String BlogImage,@PathParam("Questions") String Questions,@PathParam("Answers") String Answers,@PathParam("Description") String Description) 
       {
       pbl2.addBlog(BlogTitle, BlogImage, Questions, Answers, Description);
       }
       
       @Path("updateblog/{BlogID}/{BlogTitle}/{BlogImage}/{Questions}/{Answers}/{Description}")
       @POST
        public void updateBlog(@PathParam("BlogID") Integer BlogID,@PathParam("BlogTitle") String BlogTitle,@PathParam("BlogImage") String BlogImage,@PathParam("Questions") String Questions,@PathParam("Answers") String Answers,@PathParam("Description") String Description)
        {
            pbl2.updateBlog(BlogID, BlogTitle, BlogImage, Questions, Answers, Description);
        }
        @Path("removeblog/{BlogID}")
        @DELETE
      public void removeBlog(@PathParam("BlogID") Integer BlogID) 
        {
            pbl2.removeBlog(BlogID);
        }
        
     @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getblogName/{Blogname}") 
         public Collection<Blog> getBlogName(@PathParam("Blogname") String Blogname) 
         {
             return pbl2.getBlogName(Blogname);
         }
    
          @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getblogById/{BlogID}") 
    public Blog getBlogById(@PathParam("BlogID") Integer BlogID)
         {

             return pbl2.getBlogById(BlogID);
         }
    
     @GET
    @Produces(MediaType.APPLICATION_XML)
     @Path("getAllpackageRate")
      public Collection<Packagerating> getAllPackageRate() 
      {
         return pbl2.getAllPackageRate();
      }
      
       
     @Path("giverating/{PackageID}/{RatingStar}/{UserID}/{Description}")
      @POST
         public void giveRating(@PathParam("PackageID") Integer PackageID,@PathParam("RatingStar") Integer RatingStar,@PathParam("UserID") Integer UserID,@PathParam("Description") String Description) {
             pbl2.giveRating(PackageID, RatingStar, UserID, Description);
             
       }
         
     @Path("updaterating/{PackageRatingID}/{PackageID}/{RatingStar}/{UserID}/{Description}")
       @POST
       public void updateRating(@PathParam("PackageRatingID") Integer PackageRatingID,@PathParam("PackageID") Integer PackageID,@PathParam("RatingStar") Integer RatingStar,@PathParam("UserID") Integer UserID,@PathParam("Description") String Description) 
        {
            pbl2.updateRating(PackageRatingID, PackageID, RatingStar, UserID, Description);
        }
         
      @GET
    @Produces(MediaType.APPLICATION_XML)
      @Path("getallPackageBooking")
      public Collection<Packagebooking> getAllPackageBooking() 
      {
         return pbl2.getAllPackageBooking();
      }
      
       @Path("addbookPackagesInfo/{PackageID}/{UserID}/{NoOfTravelers}/{EmailID}/{ContactNumber}/{BookingDate}")
      @POST
       public void addBookPackagesInfo(@PathParam("PackageID") Integer PackageID,@PathParam("UserID") Integer UserID,@PathParam("NoOfTravelers") Integer NoOfTravelers,@PathParam("EmailID") String EmailID,@PathParam("ContactNumber") Integer ContactNumber,@PathParam("BookingDate") Date BookingDate) 
       {
       pbl2.addBookPackagesInfo(PackageID, UserID, NoOfTravelers, EmailID, ContactNumber, BookingDate);
       }
      
        @Path("updatebookPackage/{PackageBookingID}/{PackageID}/{UserID}/{NoOfTravelers}/{EmailID}/{ContactNumber}/{BookingDate}")
       @POST
       public void updateBookPackage(@PathParam("PackageBookingID") Integer PackageBookingID,@PathParam("PackageID") Integer PackageID,@PathParam("UserID") Integer UserID,@PathParam("NoOfTravelers") Integer NoOfTravelers,@PathParam("EmailID") String EmailID,@PathParam("ContactNumber") Integer ContactNumber,@PathParam("BookingDate") Date BookingDate)
        {
            pbl2.updateBookPackage(PackageBookingID, PackageID, UserID, NoOfTravelers, EmailID, ContactNumber, BookingDate);
                    }
         
//        @Path("removebookPackage/{PackageBookingID}")
//        @DELETE
//      public void removeBookPackage(@PathParam("PackageBookingID") Integer PackageBookingID) 
//        {
//            pbl2.removeBookPackage(PackageBookingID);
//        }
      
       @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getpackagebookingById/{PackageBookingID}") 
    public Packagebooking getPackageBookingById(@PathParam("PackageBookingID") Integer PackageBookingID) 
         {

             return pbl2.getPackageBookingById(PackageBookingID);
         }
    
    
         
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getAllPayment")
      public Collection<Payment> getAllPayment() 
      {
         return pbl2.getAllPayment();
      }
        
      @Path("addpayment/{UserID}/{PackageID}/{AccountNo}/{BankIFSC}/{Amount}/{Date}")
      @POST
       public void addPayment(@PathParam("UserID") Integer UserID,@PathParam("PackageID") Integer PackageID,@PathParam("AccountNo") Integer AccountNo,@PathParam("BankIFSC") String BankIFSC,@PathParam("Amount") Integer Amount,@PathParam("Date") Date Date) 
       {
       pbl2.addPayment(UserID, PackageID, AccountNo, BankIFSC, Amount, Date);
       }
    
        @Path("updatepayment/{PaymentID}/{UserID}/{PackageID}/{AccountNo}/{BankIFSC}/{Amount}/{Date}")
       @POST
      public void updatePayment(@PathParam("PaymentID") Integer PaymentID,@PathParam("UserID") Integer UserID,@PathParam("PackageID") Integer PackageID,@PathParam("AccountNo") Integer AccountNo,@PathParam("BankIFSC") String BankIFSC,@PathParam("Amount") Integer Amount,@PathParam("Date") Date Date) 
        {
            pbl2.updatePayment(PaymentID, UserID, PackageID, AccountNo, BankIFSC, Amount, Date);
        }
    
//    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    @Path("getpaymentByUserId/{UserID}") 
//    public Payment getPaymentByUserId(@PathParam("UserID") Integer UserID)
//         {
//
//             return pbl2.getPaymentByUserId(UserID);
//         }
    
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getallCancleBookingDeatil")
      public Collection<Cancelbooking> getAllCancleBookingDeatil() 
      {
         return pbl2.getAllCancleBookingDeatil();
      }
      
    @Path("addcancelBooking/{UserID}/{PackageID}/{PaymentID}/{ReasonForCancel}/{Date}")
      @POST
       public void addCancelBooking(@PathParam("UserID") Integer UserID,@PathParam("PackageID") Integer PackageID,@PathParam("PaymentID") Integer PaymentID,@PathParam("ReasonForCancel") String ReasonForCancel,@PathParam("Date") Date Date) 
       {
       pbl2.addCancelBooking(UserID, PackageID, PaymentID, ReasonForCancel, Date);
       }
    
        @GET
    @Produces(MediaType.APPLICATION_XML)
        @Path("getallEnquiry")
      public Collection<Enquiry> getAllEnquiry() 
      {
         return pbl2.getAllEnquiry();
      }
      
      @Path("addenquiry/{UserID}/{ContactNumber}/{EmailID}/{Message}")
      @POST
      public void addEnquiry(@PathParam("UserID") Integer UserID,@PathParam("ContactNumber") Integer ContactNumber,@PathParam("EmailID") String EmailID,@PathParam("Message") String Message) 
       {
       pbl2.addEnquiry(UserID, ContactNumber, EmailID, Message);
       }
       
       @Path("updateenquiry/{EnquiryID}/{UserID}/{ContactNumber}/{EmailID}/{Message}")
       @POST
         public void updateEnquiry(@PathParam("EnquiryID") Integer EnquiryID,@PathParam("UserID") Integer UserID,@PathParam("ContactNumber") Integer ContactNumber,@PathParam("EmailID") String EmailID,@PathParam("Message") String Message) 
        {
            pbl2.updateEnquiry(EnquiryID, UserID, ContactNumber, EmailID, Message);
        }
         
         
        @Path("removeenquiry/{EnquiryID}")
        @DELETE
      public void removeEnquiry(@PathParam("EnquiryID") Integer EnquiryID) 
        {
            pbl2.removeEnquiry(EnquiryID);
        }
        
     @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getenquiryDetail/{Edetail}") 
            public Collection<Enquiry> getEnquiryDetail(@PathParam("Edetail") String Edetail)
         {
             return pbl2.getEnquiryDetail(Edetail);
         }
    
          @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getenquiryById/{EnquiryID}") 
   public User getEnquiryById(@PathParam("EnquiryID") Integer EnquiryID) 
         {

             return pbl2.getEnquiryById(EnquiryID);
         }
   
//    @Path("addrole/{RoleName}/{UserName}/{CreatedAt}/{UpdatedAt}")
//      @POST
//      public void addRole(@PathParam("RoleName") String RoleName,@PathParam("UserName") String UserName,@PathParam("CreatedAt") DateTime CreatedAt,@PathParam("UpdatedAt") DateTime UpdatedAt) 
//       {
//       pbl.addRole(RoleName, UserName, CreatedAt, UpdatedAt);
//       }
       
//       @Path("updaterole/{RoleID}/{RoleName}/{UserName}/{CreatedAt}/{UpdatedAt}")
//       @POST
//         public void updateRole(@PathParam("RoleID") Integer RoleID,@PathParam("RoleName") String RoleName,@PathParam("UserName") String UserName,@PathParam("CreatedAt") DateTime CreatedAt,@PathParam("UpdatedAt") DateTime UpdatedAt) 
//        {
//            pbl.updateBlog(RoleID, RoleName, RoleName, UserName, UserName, UserName);
//        }
         
         
//        @Path("removerole/{RoleID}")
//        @DELETE
//     public void removeRole(@PathParam("RoleID") Integer RoleID)
//        {
//            pbl.removeRole(RoleID);
//        }
        
   
}

