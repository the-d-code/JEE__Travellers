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
//import static entity.Offer_.isSpecial;
import entity.Packages;
import entity.Places;
import entity.Role;
import entity.State;
import entity.SubPlaces;
import entity.User;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author Admin
 */
@Stateless
public class AdminBean implements AdminBeanLocal {
     @PersistenceContext(unitName = "FinalJavaProjectPU")
  EntityManager em;

//==========================Packages====================
    @Override
    public Collection<Packages> getAllPackages() {
       return em.createNamedQuery("Packages.findAll").getResultList();
       
    }

 @Override
    public void addPackages(String PackageName, Integer CategoryID, Integer StateID, Integer BusID,Integer HotelID, Integer NoOfDays, Integer NoOfNights, Integer PackageCharge,Date FromDate,Date ToDate, String Image1, String Image2, String Image3, String Image4, String ScheduleDescription) {
     Category c = em.find(Category.class, CategoryID);
     State s=em.find(State.class,StateID);
     Busdetails bd=em.find(Busdetails.class, BusID);
     Managehotel mh=em.find(Managehotel.class, HotelID);
     
     Collection<Packages> packagess = c.getPackagesCollection();
     Collection<Packages> packagess1 = s.getPackagesCollection();
     Collection<Packages> packagesbus = bd.getPackagesCollection();
     Collection<Packages> packageshotel = mh.getPackagesCollection();
     Packages packages = new Packages();
     packages.setPackageName(PackageName);
     packages.setCategoryID(c);
     packages.setStateID(s);
     packages.setBusID(bd);
     packages.setHotelID(mh);
     packages.setNoOfDays(NoOfDays);
     packages.setNoOfNights(NoOfNights);
     packages.setPackageCharge(PackageCharge);
     packages.setFromDate(FromDate);  //new Date()
//     packages.setFromDate(new Date());
     packages.setToDate(ToDate);
//     packages.setToDate(new Date());
     packages.setImage1(Image1);
     packages.setImage2(Image2);
     packages.setImage3(Image3);
     packages.setImage4(Image4);
     packages.setScheduleDescription(ScheduleDescription);
     packagess.add(packages);
     packagess1.add(packages);
     packagesbus.add(packages);
     packageshotel.add(packages);
     c.setPackagesCollection(packagess);
     s.setPackagesCollection(packagess1);
     bd.setPackagesCollection(packagesbus);
     mh.setPackagesCollection(packageshotel);
     em.persist(packages);
        em.merge(c);
        em.merge(s);
        em.merge(bd);
        em.merge(mh);
     }
  
    
//    @Override
//    public void addPackages(String PackageName, Integer CategoryID, Integer StateID, Integer NoOfDays, Integer NoOfNights, Integer PackageCharge, DateTime FromDate, DateTime ToDate, String Image1, String Image2, String Image3, String Image4, String ScheduleDescription) {
//     Category c = em.find(Category.class, CategoryID);
//     
////     System.out.println(c);
//     State s=em.find(State.class,StateID);
//     
//     // !packagess.isEmpty() 
//     
//     if(c != null && s != null)
//     {
//        Collection<Packages> packagess = c.getPackagesCollection();
//        Collection<Packages> packagess1 = s.getPackagesCollection();
//     Packages packages = new Packages();
//     packages.setPackageName(PackageName);
//     packages.setCategoryID(c);
//     packages.setStateID(s);
//     packages.setNoOfDays(NoOfDays);
//     packages.setNoOfNights(NoOfNights);
//     packages.setPackageCharge(PackageCharge);
//     //packages.setFromDate((Date) fromDate);  //new Date()
//     packages.setFromDate(new Date());
//     //packages.setToDate((Date) toDate);
//     packages.setToDate(new Date());
//     packages.setImage1(Image1);
//     packages.setImage2(Image2);
//     packages.setImage3(Image3);
//     packages.setImage4(Image4);
//     packages.setScheduleDescription(ScheduleDescription);
//     packagess.add(packages);
//     packagess1.add(packages);
//        em.persist(packages);
//        em.merge(c);
//        em.merge(s);
//     }
//     
//    
//    // packages.setFromDate(fromDate);
//     
//    }

@Override
    public void updatePackages(Integer PackageID, String PackageName, Integer CategoryID, Integer StateID, Integer NoOfDays, Integer NoOfNights, Integer PackageCharge,Date FromDate,Date ToDate, String Image1, String Image2, String Image3, String Image4, String ScheduleDescription) {
     Packages p= em.find(Packages.class,PackageID);
         
         Category c = em.find(Category.class, CategoryID);
         
//         System.out.println(p);
//         System.out.println(c);
         
         State s =em.find(State.class, StateID);
          System.out.println(s);
         p.setPackageName(PackageName);
         p.setCategoryID(c);
         p.setStateID(s);
         p.setNoOfDays(NoOfDays);
         p.setNoOfNights(NoOfNights);
         p.setPackageCharge(PackageCharge);
         p.setFromDate(new Date());
         p.setToDate(new Date());
         p.setImage1(Image1);
         p.setImage2(Image2);
         p.setImage3(Image3);
         p.setImage4(Image4);
         p.setScheduleDescription(ScheduleDescription);
         
         
                 
      
       em.merge(p);
    }
//    @Override
//    public void updatePackages(Integer PackageID, String PackageName, Integer CategoryID, Integer StateID, Integer NoOfDays, Integer NoOfNights, Integer PackageCharge, DateTime FromDate, DateTime ToDate, String Image1, String Image2, String Image3, String Image4, String ScheduleDescription) {
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//         Packages p= em.find(Packages.class,PackageID);
//         
//         Category c = em.find(Category.class, CategoryID);
//         
//         System.out.println(p);
//         System.out.println(c);
//         
//         State s =em.find(State.class, StateID);
//          System.out.println(s);
//         p.setPackageName(PackageName);
//         p.setCategoryID(c);
//         p.setStateID(s);
//         p.setNoOfDays(NoOfDays);
//         p.setNoOfNights(NoOfNights);
//         p.setPackageCharge(PackageCharge);
//         p.setFromDate(new Date());
//         p.setToDate(new Date());
//         p.setImage1(Image1);
//         p.setImage2(Image2);
//         p.setImage3(Image3);
//         p.setImage4(Image4);
//         p.setScheduleDescription(ScheduleDescription);
//         
//         
//                 
//      
//       em.merge(p);
//    }

    @Override
    public void removePackages(Integer PackageID) {
         Packages p= em.find(Packages.class,PackageID);
         em.remove(p);
    
    }

    @Override
    public Collection<Packages> SearchPacagesByName(String PackageName) {
          Collection<Packages> packages = em.createNamedQuery("Packages.findByPackageName")
             .setParameter("packageName", PackageName)
             .getResultList();
     
     return packages;
    }

   
    @Override
    public Packages SearchPacagesById(Integer PackageID) {
        return em.find(Packages.class, PackageID);
    }

//    =======================================Places=======================================
    @Override
    public Collection<Places> getAllPlaces() {
         return em.createNamedQuery("Places.findAll").getResultList();
    }

    @Override
    public void addPlaces(Integer CategoryID, String PlaceName, Integer StateID, String Description) {
        Category c = em.find(Category.class, CategoryID);
        State s=em.find(State.class,StateID);
       if(c != null && s != null)
      {
          Collection<Places> p = c.getPlacesCollection();
          Collection<Places> p1 = s.getPlacesCollection();
           Places places = new Places();
            places.setCategoryID(c);
             places.setPlaceName(PlaceName);
             places.setStateID(s);
             places.setDescription(Description);
             em.persist(places);
             em.merge(c);
             em.merge(s);
     }
     
    
    }

    @Override
    public void updatePlaces(Integer PlaceID, Integer CategoryID, String PlaceName, Integer StateID, String Description) {
          //Packages p= em.find(Packages.class,PackageID);
         Places p = em.find(Places.class, PlaceID);
         Category c = em.find(Category.class, CategoryID);
         State s =em.find(State.class, StateID);
         p.setCategoryID(c);
         p.setPlaceName(PlaceName);
         p.setStateID(s);
         p.setDescription(Description);
       em.merge(p);
    }

    @Override
    public void removePlaces(Integer PlaceID) {
        Places p = em.find(Places.class, PlaceID);
        em.remove(p);
    }

    @Override
    public Collection<Places> SerchPlaces(String pname) {
        Collection<Places> places = em.createNamedQuery("Places.findByPlaceName")
             .setParameter("placeName", pname)
             .getResultList();
     
     return places;
    }

//    ==================================================subPlaces=============================
    @Override
    public Collection<SubPlaces> getAllSplaces() {
       return em.createNamedQuery("SubPlaces.findAll").getResultList();
    }

    @Override
    public void addSplaces(Integer CategoryID, Integer PlaceID, String SubPlaceName, Integer StateID, Integer CityID, String Description) {
          Category c = em.find(Category.class, CategoryID);
          Places p = em.find(Places.class,PlaceID);
          State s=em.find(State.class,StateID);
          City ci=em.find(City.class,CityID);
          
          System.out.print(c);
          System.out.print(p);
          System.out.print(s);
          System.out.print(ci);
          
       if(c != null && s != null && p != null && ci != null)
      {
          Collection<SubPlaces> sp = c.getSubPlacesCollection();
          Collection<SubPlaces> sp1 = p.getSubPlacesCollection();
          Collection<SubPlaces> sp2 = s.getSubPlacesCollection();
          Collection<SubPlaces> sp3 = ci.getSubPlacesCollection();
          
           SubPlaces splaces = new SubPlaces();
           splaces.setCategoryID(c);
           splaces.setPlaceID(p);
           splaces.setSubPlaceName(SubPlaceName);
           splaces.setStateID(s);
           splaces.setCityID(ci);
           splaces.setDescription(Description);
             em.persist(splaces);
             em.merge(c);
             em.merge(s);
             em.merge(p);
             em.merge(ci);
     }
    }

    @Override
    public void updateSplaces(Integer SubPlaceID, Integer CategoryID, Integer PlaceID, String SubPlaceName, Integer StateID, Integer CityID, String Description) {
        SubPlaces sp = em.find(SubPlaces.class, SubPlaceID);
         Category c = em.find(Category.class, CategoryID);
         Places p = em.find(Places.class,PlaceID);
         State s=em.find(State.class,StateID);
         City ci=em.find(City.class,CityID);
         sp.setCategoryID(c);
         sp.setPlaceID(p);
         sp.setSubPlaceName(SubPlaceName);
         sp.setStateID(s);
         sp.setCityID(ci);
         sp.setDescription(Description);
          em.merge(sp);
    }

    @Override
    public void removeSplaces(Integer SubPlaceID) {
         SubPlaces sp = em.find(SubPlaces.class, SubPlaceID);
        em.remove(sp);
    }

    @Override
    public Collection<SubPlaces> SerchSubPlaces(String spname) {
          Collection<SubPlaces> splaces = em.createNamedQuery("SubPlaces.findBySubPlaceName")
             .setParameter("subPlaceName", spname)
             .getResultList();
     
     return splaces;
    }

//    ================================================City======================================
    @Override
    public Collection<City> getAllCity() {
        return em.createNamedQuery("City.findAll").getResultList();
    }

    @Override
    public void addCity(String CityName, Integer StateID) {
    
     State s=em.find(State.class,StateID);
     if(s != null)
     {
        Collection<City> cities = s.getCityCollection();
        City city =new City();
        city.setCityName(CityName);
        city.setStateID(s);
        em.persist(city);
        em.merge(s);
    }
    }
    @Override
    public void updateCity(Integer CityID, String CityName, Integer StateID) {
        City c=em.find(City.class,CityID);
         State s =em.find(State.class, StateID);
         c.setCityName(CityName);
         c.setStateID(s);
         em.merge(c);
    }

    @Override
    public void removeCity(Integer CityID , Integer StateID) {
       
          State s = em.find(State.class, StateID);
          City city =  em.find(City.class,CityID);
          Collection<City> citys = s.getCityCollection();
          if(citys.contains(city))
          {
              citys.remove(city);
              s.setCityCollection(citys);
              em.remove(city);
              em.merge(s);
              
          }
          
          
    }

    
    //========================category======================
    @Override
    public Collection<Category> getAllCategory() {
        return em.createNamedQuery("Category.findAll").getResultList();
    }

    @Override
    public void addCategory(String CategoryName, String Description,String Image) {
        Category cat=new Category(CategoryName,Description,Image);
        em.persist(cat);
    }

    @Override
    public void updateCategory(Integer CategoryID, String CategoryName, String Description,String Image) {
         Category cat= em.find(Category.class,CategoryID);
         cat.setCategoryName(CategoryName);
         cat.setDescription(Description);
         cat.setImage(Image);
         em.merge(cat);
        
    }
    
    @Override
    public void removeCategory(Integer CategoryID) {
          Category cat = (Category) em.find(Category.class, CategoryID);
       em.remove(cat);
    }
    @Override
    public Collection<Category> getCategoryDetail(String cname) {
        Collection<Category> categories = em.createNamedQuery("Category.findByCategoryName")
             .setParameter("categoryName", cname)
             .getResultList();
     
     return categories;
    }

    //==============================state===================
    @Override
    public Collection<State> getAllState() {
        return em.createNamedQuery("State.findAll").getResultList();
    }

    @Override
    public void addState(String StateName) {
       State st=new State(StateName);
        em.persist(st);
    }

    @Override
    public void updateState(Integer StateID,String StateName) {
         State st= em.find(State.class,StateID);
         //st.StateName(StateName);
         st.setStateName(StateName);
         em.merge(st);
    }

    @Override
    public void removeState(Integer StateID) {
          State st = (State) em.find(State.class, StateID);
       em.remove(st);
    }

//    ==========================================Bus========================
    @Override
    public Collection<Busdetails> getAllBus() {
        return em.createNamedQuery("Busdetails.findAll").getResultList();
    }

    @Override
    public void addBus(String BusName, Integer TotalSeats, Integer FromCityID, Integer ToCityID, Integer CostPerSeat, Integer AvailableSeat, String Image1, String Image2, String Image3, String Description) {
        City fc = em.find(City.class, FromCityID);
        City tc = em.find(City.class, ToCityID);
        
       if(fc != null && tc != null)
      {
          Collection<Busdetails> bd = fc.getBusdetailsCollection();
          Collection<Busdetails> bd1 = tc.getBusdetailsCollection();
          
          Busdetails busdetails = new Busdetails();
          busdetails.setBusName(BusName);
          busdetails.setTotalSeats(TotalSeats);
          busdetails.setFromCityID(fc);
          busdetails.setToCityID(tc);
          busdetails.setCostPerSeat(CostPerSeat);
          busdetails.setAvailableSeat(AvailableSeat);
          busdetails.setImage1(Image1);
          busdetails.setImage2(Image2);
          busdetails.setImage3(Image3);
          busdetails.setDescription(Description);
         
             em.persist(busdetails);
             em.merge(fc);
             em.merge(tc);
     }
     
    }

    @Override
    public void updateBus(Integer BusID, String BusName, Integer TotalSeats, Integer FromCityID, Integer ToCityID, Integer CostPerSeat, Integer AvailableSeat, String Image1, String Image2, String Image3, String Description) {
        Busdetails bd = em.find(Busdetails.class, BusID);
         City fc = em.find(City.class, FromCityID);
         City tc = em.find(City.class, ToCityID);
        // State s =em.find(State.class, StateID);
        bd.setBusName(BusName);
        bd.setTotalSeats(TotalSeats);
        bd.setCostPerSeat(CostPerSeat);
        bd.setAvailableSeat(AvailableSeat);
        bd.setImage1(Image1);
        bd.setImage2(Image2);
        bd.setImage3(Image3);
        bd.setDescription(Description);
         
         em.merge(bd);
    }

    @Override
    public void removeBus(Integer BusID,Integer FromCityID,Integer ToCityID) {
      
//  Brandtb b = em.find(Brandtb.class, bid);
//        Categorytb c = em.find(Categorytb.class, cid);
//        Producttb p = em.find(Producttb.class,pid);
        
        City fc = em.find(City.class, FromCityID);
        City tc = em.find(City.class, ToCityID);
        Busdetails bd = em.find(Busdetails.class , BusID);
        
//        Collection<Producttb> brand = b.getProducttbCollection();
//        Collection<Producttb> category = c.getProducttbCollection();
    
           Collection<Busdetails> fromc = fc.getBusdetailsCollection();
           Collection<Busdetails> toc = tc.getBusdetailsCollection();
        
//        if(brand.contains(p)){
//            brand.remove(p);
//            b.setProducttbCollection(brand);
//            category.remove(p);
//            c.setProducttbCollection(category);
//            em.merge(b);
//            em.merge(c);
//            em.remove(p);
//        }      
        
        if(fromc.contains(bd))
        {
            fromc.remove(bd);
            fc.setBusdetailsCollection(fromc);
            toc.remove(bd);
            tc.setBusdetailsCollection(toc);
            em.merge(fc);
            em.merge(tc);
            em.merge(bd);
        }
    }

    @Override
    public Collection<Busdetails> getBusName(String Bname) {
       Collection<Busdetails> busdetails = em.createNamedQuery("Busdetails.findByBusName")
             .setParameter("busName", Bname)
             .getResultList();
     
        return busdetails;
    }

    @Override
    public Busdetails getBusById(Integer BusID) {
        return em.find(Busdetails.class, BusID);
    
    }

//    =====================================hotel============================================
    @Override
    public Collection<Managehotel> getAllHotel() {
        return em.createNamedQuery("Managehotel.findAll").getResultList();
    }

   @Override
    public void addHotel(String HotelName, Integer CostPerRoom, Integer StateID, Integer CityID, String Image1, String Image2, String Image3, String Description) {
        City c = em.find(City.class, CityID);
        State s=em.find(State.class,StateID);
       
          Collection<Managehotel> mh = c.getManagehotelCollection();
          Collection<Managehotel> mh1 = s.getManagehotelCollection();
          Managehotel managehotel = new Managehotel();
          managehotel.setHotelName(HotelName);
          managehotel.setCostPerRoom(CostPerRoom);
          managehotel.setStateID(s);
          managehotel.setCityID(c);
          managehotel.setImage1(Image1);
          managehotel.setImage2(Image2);
          managehotel.setImage3(Image3);
          managehotel.setDescription(Description);
          
          mh.add(managehotel);
          mh1.add(managehotel);
          c.setManagehotelCollection(mh);
          s.setManagehotelCollection(mh1);
          System.out.println(managehotel);
             em.persist(managehotel);
             em.merge(c);
             em.merge(s);
     
     
    }

    @Override
    public void updateHotel(Integer HotelID, String HotelName, Integer CostPerRoom, Integer StateID, Integer CityID, String Image1, String Image2, String Image3, String Description) {
        Managehotel mh = em.find(Managehotel.class, HotelID);
         City c = em.find(City.class, CityID);
         State s =em.find(State.class, StateID);
         mh.setHotelName(HotelName);
         mh.setCostPerRoom(CostPerRoom);
         mh.setImage1(Image1);
         mh.setImage2(Image2);
         mh.setImage3(Image3);
         mh.setDescription(Description);
        
         em.merge(mh);
    }

    @Override
    public void removeHotel(Integer HotelID, Integer StateID, Integer CityID) {

        State s=em.find(State.class, StateID);
        City c = em.find(City.class, CityID);
    Managehotel mh= em.find(Managehotel.class,HotelID);
    
    
            Collection<Managehotel> mhc = s.getManagehotelCollection();
         Collection<Managehotel> mhco = c.getManagehotelCollection();   
         
       
          if(mhc.contains(mh))
        {
            mhc.remove(mh);
            s.setManagehotelCollection(mhc);
            mhco.remove(mh);
           c.setManagehotelCollection(mhco);
            em.merge(s);
            em.merge(c);
            em.merge(mh);
        }
         
    
    }

    @Override
    public Collection<Managehotel> getHotelName(String Hname) {
     
          Collection<Managehotel> managehotel = em.createNamedQuery("Managehotel.findByHotelName")
             .setParameter("hotelName", Hname)
             .getResultList();
     
        return managehotel;
    }

    @Override
    public Managehotel getHotelById(Integer HotelID) {
        
        return em.find(Managehotel.class, HotelID);
    
    }
    
//    ===============================================Offer=========================================

    @Override
    public Collection<Offer> getAllOffer() {
        return em.createNamedQuery("Offer.findAll").getResultList();
    }

   
     @Override
    public void addOffer(String OfferName, Boolean IsSpecial, String Description,Integer Price) {
         Offer of=new Offer(OfferName,IsSpecial ,Description,Price);
        em.persist(of);
    }

    @Override
    public void updateOffer(Integer OfferID, String OfferName, Boolean IsSpecial, String Description,Integer Price) {
       Offer of= em.find(Offer.class,OfferID);
         of.setOfferName(OfferName);
         of.setIsSpecial(true);
         of.setDescription(Description);
         of.setPrice(Price);
         em.merge(of);
    }

    @Override
    public void removeOffer(Integer OfferID) {
          Offer of = (Offer) em.find(Offer.class, OfferID);
       em.remove(of);
    }

    @Override
    public Collection<Offer> getOfferByName(String oname) {
         Collection<Offer> ofers = em.createNamedQuery("Offer.findByOfferName")
             .setParameter("offerName", oname)
             .getResultList();
     
     return ofers;
    }

    @Override
    public Offer getOfferById(Integer OfferID) {
        return em.find(Offer.class, OfferID);
    }

//    =================================================ROle==================================
//    @Override
//    public void addRole(String RoleName, String UserName, DateTime CreatedAt, DateTime UpdatedAt) {
//         Role cat=new Role(RoleName,UserName,new Date(),new Date());
//        em.persist(cat);
//    }
//
//    @Override
//    public void updateRole(Integer RoleID, String RoleName, String UserName, DateTime CreatedAt, DateTime UpdatedAt) {
//        Role r= em.find(Role.class,RoleID);
//        r.setRoleName(RoleName);
//        r.setUserName(UserName);
//        r.setCreatedAt(new Date());
//        r.setUpdatedAt(new Date());
//        
//         em.merge(r);
//    }
//
//    @Override
//    public void removeRole(Integer RoleID) {
//         Role r = (Role) em.find(Role.class, RoleID);
//       em.remove(r);
//    }
@Override
    public Collection<Object[]> getAllCityByStateId(Integer StateId) {
        try{
        Query query = em.createNativeQuery("SELECT  s.stateID,c.cityID,c.cityName\n" +
"FROM city c\n" +
"INNER JOIN state s ON c.stateID = s.stateID\n" +
"WHERE c.stateID = ?StateId","MultipleSearchOfPackages");
        
        
        query.setParameter("StateId", StateId);
       
        
        Collection<Object[]> obj = query.getResultList();
        return obj;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;   
           }

    
    @Override
    public City GetCityBYID(int CityID) {
             City objCity = (City) em.find(City.class, CityID);
        return objCity;
    }
 @Override
    public Collection<Object[]> getFourPackages() {
      try{
        Query query = em.createNativeQuery("SELECT  p.packageID,p.packageName,p.noOfDays,p.noOfNights,p.packageCharge,p.fromDate,p.toDate,p.image1,p.image2,p.image3,p.image4,p.scheduleDescription\n" +
"FROM packages p LIMIT 4","getFourPackages");
        Collection<Object[]> obj = query.getResultList();
        return obj;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;    
    }
    @Override
    public Collection<Object[]> GetPackageByCatID(int CategoryID) {
try{
        Query query = em.createNativeQuery("SELECT  p.packageID,p.packageName,p.noOfDays,p.noOfNights,p.packageCharge,p.fromDate,p.toDate,p.image1,p.image2,p.image3,p.image4,p.scheduleDescription,ct.categoryID,ct.categoryName,ct.description,ct.image\n" +
"FROM packages p\n" +
"INNER JOIN category ct ON p.categoryID = ct.categoryID\n" +
//"INNER JOIN bus details 'b ON p.busID = b.busID\n" +
//,b.busName,b.totalSeats,b.costPerSeat,b.image1,b.image2,b.description,h.hotelName,h.costPerRoom,h.image1,h.image2,h.image3,h.description
//"INNER JOIN manage hotel h ON p.hotelID = h.hotelID\n" +
"WHERE p.categoryID = ?CategoryID","GetPackageByCatID");
        
        
        query.setParameter("CategoryID", CategoryID);
        
        
        Collection<Object[]> obj = query.getResultList();
        return obj;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;    
    }

    @Override
    public Collection<Object[]> getThreeCategory() {
try{
        Query query = em.createNativeQuery("SELECT c.categoryID,c.categoryName,c.description,c.image\n" +
"FROM category c LIMIT 3","getThreeCategory");
        Collection<Object[]> obj = query.getResultList();
        return obj;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;     
    }

    @Override
    public Collection<Object[]> GetPaymentByPackID(int PackageID) {
try{
    Query query = em.createNativeQuery("SELECT  pm.paymentID,pm.amount,pm.date,pm.userID,pm.packageID\n" +
"FROM payment pm\n" +
"INNER JOIN packages p ON pm.packageID = p.packageID\n" +
//"INNER JOIN bus details 'b ON p.busID = b.busID\n" +
//,b.busName,b.totalSeats,b.costPerSeat,b.image1,b.image2,b.description,h.hotelName,h.costPerRoom,h.image1,h.image2,h.image3,h.description
//"INNER JOIN manage hotel h ON p.hotelID = h.hotelID\n" +
"WHERE pm.packageID = ?PackageID","GetPaymentByPackID");
        
        
        query.setParameter("PackageID", PackageID);
        
        
        Collection<Object[]> obj = query.getResultList();
        return obj;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;    
}

    @Override
    public Collection<Object[]> GetHotelByStatCityID(int StateID, int CityID) {
try{
    Query query = em.createNativeQuery("SELECT  h.hotelName,h.costPerRoom,h.image1,h.image2,h.image3,h.description,h.hotelID\n" +
"FROM managehotel h\n" +
"INNER JOIN state s ON h.stateID = s.stateID\n" +
"INNER JOIN city c ON h.cityID = c.cityID\n" +
//,b.busName,b.totalSeats,b.costPerSeat,b.image1,b.image2,b.description,h.hotelName,h.costPerRoom,h.image1,h.image2,h.image3,h.description
//"INNER JOIN manage hotel h ON p.hotelID = h.hotelID\n" +
"WHERE h.stateID = ?StateID AND h.cityID =?CityID","GetHotelByStatCityID");
        
        
        query.setParameter("StateID", StateID);
        query.setParameter("CityID", CityID);
        
        Collection<Object[]> obj = query.getResultList();
        return obj;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;   
    }

    @Override
    public Collection<Object[]> GetCityByCityCityID(int FromCityID, int TOCityID) {
try{
    Query query = em.createNativeQuery("SELECT  c.busID,c.busName,c.totalSeats,c.costPerSeat,c.costPerSeat,c.fromCityID,c.toCityID,c.image1,c.image2,c.image3,c.description\n" +
"FROM Busdetails b\n" +
"INNER JOIN city c ON b.fromCityID = c.cityID\n" +
"INNER JOIN city c1 ON b.toCityID = c1.cityID\n" +
//,b.busName,b.totalSeats,b.costPerSeat,b.image1,b.image2,b.description,h.hotelName,h.costPerRoom,h.image1,h.image2,h.image3,h.description
//"INNER JOIN manage hotel h ON p.hotelID = h.hotelID\n" +
"WHERE b.cityID = ?FromCityID AND b.cityID =?TOCityID","GetCityByCityCityID");
        
        
        query.setParameter("FromCityID", FromCityID);
        query.setParameter("TOCityID", TOCityID);
        
        Collection<Object[]> obj = query.getResultList();
        return obj;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;   
    }

   
    

    

   
}
