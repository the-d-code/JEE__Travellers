/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

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
import entity.User;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import javax.ejb.Local;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author Admin
 */
@Local
public interface AdminBeanLocal {
    
    //======================Packages==========================
      
      Collection<Packages> getAllPackages();
      Collection<Object[]> getFourPackages();

      void addPackages(String PackageName,Integer CategoryID,Integer StateID,Integer BusID,Integer HotelID,Integer NoOfDays,Integer NoOfNights,Integer PackageCharge,Date FromDate,Date ToDate,String Image1,String Image2,String Image3,String Image4,String ScheduleDescription);
      void updatePackages(Integer PackageID,String PackageName,Integer CategoryID,Integer StateID,Integer NoOfDays,Integer NoOfNights,Integer PackageCharge,Date FromDate,Date ToDate,String Image1,String Image2,String Image3,String Image4,String ScheduleDescription);
      void removePackages(Integer PackageID);
       Collection<Packages> SearchPacagesByName(String PackageName);
      Packages SearchPacagesById(Integer PackageID);

      //====================Places=========================
        Collection<Places> getAllPlaces();
        void addPlaces(Integer CategoryID,String PlaceName,Integer StateID,String Description);
        void updatePlaces(Integer PlaceID,Integer CategoryID,String PlaceName,Integer StateID,String Description);
        void removePlaces(Integer PlaceID);
        Collection<Places> SerchPlaces(String pname);
        
        
         //======================SubPlaces=================
                 
      Collection<SubPlaces> getAllSplaces();
        void addSplaces(Integer CategoryID,Integer PlaceID,String SubPlaceName,Integer StateID,Integer CityID,String Description);
        void updateSplaces(Integer SubPlaceID,Integer CategoryID,Integer PlaceID,String SubPlaceName,Integer StateID,Integer CityID,String Description);
        void removeSplaces(Integer SubPlaceID);
        Collection<SubPlaces> SerchSubPlaces(String spname);
        
        //========================City==================================
         
         Collection<City> getAllCity();
         void addCity(String CityName,Integer StateID);
         void updateCity(Integer CityID,String CityName,Integer StateID);
         void removeCity(Integer CityID , Integer StateID);
         City GetCityBYID(int CityID);
         
    //==========================Category============================
           Collection<Category> getAllCategory();
           Collection<Object[]> getThreeCategory();
         void addCategory(String CategoryName,String Description,String Image);
         void updateCategory(Integer CategoryID,String CategoryName,String Description,String Image);
         void removeCategory(Integer CategoryID);
         Collection<Category> getCategoryDetail(String Cname);
         
         //====================State=========================
          Collection<State> getAllState();
          void addState(String StateName);
          void updateState(Integer StateID,String StateName);
          void removeState(Integer StateID);
         
         // =========================BusDetails========================
         
           Collection<Busdetails> getAllBus();
          void addBus(String BusName,Integer TotalSeats,Integer FromCityID,Integer ToCityID,Integer CostPerSeat,Integer AvailableSeat,String Image1,String Image2,String Image3,String Description);
          void updateBus(Integer BusID,String BusName,Integer TotalSeats,Integer FromCityID,Integer ToCityID,Integer CostPerSeat,Integer AvailableSeat,String Image1,String Image2,String Image3,String Description);
          void removeBus(Integer BusID,Integer FromCityID,Integer ToCityID);
          Collection<Busdetails> getBusName(String Bname);
         Busdetails getBusById(Integer BusID);
         
         //=======================ManageHotel========================
         
          Collection<Managehotel> getAllHotel();
          void addHotel(String HotelName,Integer CostPerRoom,Integer StateID,Integer CityID,String Image1,String Image2,String Image3,String Description);
          void updateHotel(Integer HotelID,String HotelName,Integer CostPerRoom,Integer StateID,Integer CityID,String Image1,String Image2,String Image3,String Description);
          void removeHotel(Integer HotelID,Integer StateID,Integer CityID);
          Collection<Managehotel> getHotelName(String Hname);
         Managehotel getHotelById(Integer HotelID);
            //============================Offer==============================
         Collection<Offer> getAllOffer();
        void addOffer(String OfferName,Boolean IsSpecial,String Description,Integer Price);
         void updateOffer(Integer OfferID,String OfferName,Boolean IsSpecial,String Description,Integer Price);
         void removeOffer(Integer OfferID);
         Collection<Offer> getOfferByName(String oname);
         Offer getOfferById(Integer OfferID);
         
         
//============================Roles=======================
//         void addRole(String RoleName,String UserName, DateTime CreatedAt, DateTime UpdatedAt);
//         void updateRole(Integer RoleID,String RoleName,String UserName, DateTime CreatedAt, DateTime UpdatedAt);
//         void removeRole(Integer RoleID);
 
        Collection<Object[]> getAllCityByStateId(Integer StateId);
        Collection<Object[]> GetPackageByCatID(int categoryID);
        Collection<Object[]> GetPaymentByPackID(int PackageID);
        Collection<Object[]> GetHotelByStatCityID(int StateID,int CityID);
        Collection<Object[]> GetCityByCityCityID(int FromCityID,int TOCityID);
}
