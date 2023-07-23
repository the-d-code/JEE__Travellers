/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestClient;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:GenericResource [generic]<br>
 * USAGE:
 * <pre>
 *        restClientUser client = new restClientUser();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Radhika Maniya
 */
public class restClientUser {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/FinalJavaProject/webresources";

    public restClientUser() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("generic");
    }

    public void updateCity(String CityID, String CityName, String StateID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCity/{0}/{1}/{2}", new Object[]{CityID, CityName, StateID})).request().post(null);
    }

    public void addPackages(String PackageName, String CategoryID, String StateID, String NoOfDays, String NoOfNights, String PackageCharge, String FromDate, String ToDate, String Image1, String Image2, String Image3, String Image4, String ScheduleDescription) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addPackages/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}", new Object[]{PackageName, CategoryID, StateID, NoOfDays, NoOfNights, PackageCharge, FromDate, ToDate, Image1, Image2, Image3, Image4, ScheduleDescription})).request().post(null);
    }

    public <T> T getEnquiryById(Class<T> responseType, String EnquiryID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getenquiryById/{0}", new Object[]{EnquiryID}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void addHotel(String HotelName, String CostPerRoom, String StateID, String CityID, String Image1, String Image2, String Image3, String Description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addHotel/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{HotelName, CostPerRoom, StateID, CityID, Image1, Image2, Image3, Description})).request().post(null);
    }

    public <T> T getAllState(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllState");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void addUser(String FirstName, String MiddleName, String LastName, String EmailID, String ContactNumber, String Password, String IsActive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("adduser/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{FirstName, MiddleName, LastName, EmailID, ContactNumber, Password, IsActive})).request().post(null);
    }

    public void updateCategory(String CategoryID, String CategoryName, String Description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCategory/{0}/{1}/{2}", new Object[]{CategoryID, CategoryName, Description})).request().post(null);
    }

    public <T> T getAllPlaces(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllPlaces");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T SerchPlaces(Class<T> responseType, String pname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SerchPlaces/{0}", new Object[]{pname}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getHotelName(Class<T> responseType, String Hname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getHotelName/{0}", new Object[]{Hname}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllPackages(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllPackages");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllOffer(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllOffer");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T SearchPacagesById(Class<T> responseType, String PackageID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SearchPacagesById/{0}", new Object[]{PackageID}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllCity(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllCity");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void removeUser(String UserID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeuser/{0}", new Object[]{UserID})).request().delete();
    }

    public <T> T getOfferByName(Class<T> responseType, String oname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getOfferByName/{0}", new Object[]{oname}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void removeOffer(String OfferID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeOffer/{0}", new Object[]{OfferID})).request().delete();
    }

    public void removeEnquiry(String EnquiryID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeenquiry/{0}", new Object[]{EnquiryID})).request().delete();
    }

    public void removePackages(String PackageID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removePackages/{0}", new Object[]{PackageID})).request().delete();
    }

    public void updateBus(String BusID, String BusName, String TotalSeats, String FromCityID, String ToCityID, String CostPerSeat, String AvailableSeat, String Image1, String Image2, String Image3, String Description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateBus/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}", new Object[]{BusID, BusName, TotalSeats, FromCityID, ToCityID, CostPerSeat, AvailableSeat, Image1, Image2, Image3, Description})).request().post(null);
    }

    public void updatePlaces(String PlaceID, String CategoryID, String PlaceName, String StateID, String Description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatePlaces/{0}/{1}/{2}/{3}/{4}", new Object[]{PlaceID, CategoryID, PlaceName, StateID, Description})).request().post(null);
    }

    public void addBus(String BusName, String TotalSeats, String FromCityID, String ToCityID, String CostPerSeat, String AvailableSeat, String Image1, String Image2, String Image3, String Description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addBus/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}", new Object[]{BusName, TotalSeats, FromCityID, ToCityID, CostPerSeat, AvailableSeat, Image1, Image2, Image3, Description})).request().post(null);
    }

    public void removeHotel(String HotelID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeHotel/{0}", new Object[]{HotelID})).request().delete();
    }

    public <T> T getBlogName(Class<T> responseType, String Blogname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getblogName/{0}", new Object[]{Blogname}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void addCity(String CityName, String StateID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCity/{0}/{1}", new Object[]{CityName, StateID})).request().post(null);
    }

    public void removeBus(String BusID, String FromCityID, String ToCityID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeBus/{0}/{1}/{2}", new Object[]{BusID, FromCityID, ToCityID})).request().delete();
    }

    public void removeBlog(String BlogID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeblog/{0}", new Object[]{BlogID})).request().delete();
    }

    public <T> T getAllPackageRate(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllpackageRate");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void giveRating(String PackageID, String RatingStar, String UserID, String Description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("giverating/{0}/{1}/{2}/{3}", new Object[]{PackageID, RatingStar, UserID, Description})).request().post(null);
    }

    public void removeSplaces(String SubPlaceID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeSplaces/{0}", new Object[]{SubPlaceID})).request().delete();
    }

    public <T> T getBusById(Class<T> responseType, String BusID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getBusById/{0}", new Object[]{BusID}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void addPlaces(String CategoryID, String PlaceName, String StateID, String Description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addPlaces/{0}/{1}/{2}/{3}", new Object[]{CategoryID, PlaceName, StateID, Description})).request().post(null);
    }

    public <T> T getAllUser(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAlluser");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void removeState(String StateID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeState/{0}", new Object[]{StateID})).request().delete();
    }

    public <T> T getAllCategory(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllCategory");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getCategoryDetail(Class<T> responseType, String cname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCategoryDetail/{0}", new Object[]{cname}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllSplaces(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllSplaces");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getUserById(Class<T> responseType, String UserID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getuserById/{0}", new Object[]{UserID}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T SearchPackages(Class<T> responseType, String CategoryID, String NoOfDays, String PackageCharge) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SearchPackages/{0}/{1}/{2}", new Object[]{CategoryID, NoOfDays, PackageCharge}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void updatePackages(String PackageID, String PackageName, String CategoryID, String StateID, String NoOfDays, String NoOfNights, String PackageCharge, String FromDate, String ToDate, String Image1, String Image2, String Image3, String Image4, String ScheduleDescription) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatePackages/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}", new Object[]{PackageID, PackageName, CategoryID, StateID, NoOfDays, NoOfNights, PackageCharge, FromDate, ToDate, Image1, Image2, Image3, Image4, ScheduleDescription})).request().post(null);
    }

    public <T> T getAllHotel(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllHotel");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getUserByEmailPassword(Class<T> responseType, String emailID, String password) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserByEmailPassword/{0}/{1}", new Object[]{emailID, password}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

      public <T> T getUsername(Class<T> responseType, String username, String password) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUsername/{0}/{1}", new Object[]{username, password}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }
    
    
    public <T> T getAllBlog(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllblog");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void addCategory(String CategoryName, String Description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCategory/{0}/{1}", new Object[]{CategoryName, Description})).request().post(null);
    }

    public <T> T getAllPackageBooking(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getallPackageBooking");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllBus(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllBus");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getOfferById(Class<T> responseType, String OfferID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getOfferById/{0}", new Object[]{OfferID}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void addEnquiry(String UserID, String ContactNumber, String EmailID, String Message) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addenquiry/{0}/{1}/{2}/{3}", new Object[]{UserID, ContactNumber, EmailID, Message})).request().post(null);
    }

    public void addOffer(String OfferName, String IsSpecial, String Description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addOffer/{0}/{1}/{2}", new Object[]{OfferName, IsSpecial, Description})).request().post(null);
    }

    public <T> T SerchSubPlaces(Class<T> responseType, String spname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SerchSubPlaces/{0}", new Object[]{spname}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void removeCategory(String CategoryID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeCategory/{0}", new Object[]{CategoryID})).request().delete();
    }

    public <T> T getAllPayment(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllPayment");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getEnquiryDetail(Class<T> responseType, String Edetail) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getenquiryDetail/{0}", new Object[]{Edetail}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void addState(String StateName) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addState/{0}", new Object[]{StateName})).request().post(null);
    }

    public void updateBlog(String BlogID, String BlogTitle, String BlogImage, String Questions, String Answers, String Description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateblog/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{BlogID, BlogTitle, BlogImage, Questions, Answers, Description})).request().post(null);
    }

    public void updateState(String StateID, String StateName) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateState/{0}/{1}", new Object[]{StateID, StateName})).request().post(null);
    }

    public void updateHotel(String HotelID, String HotelName, String CostPerRoom, String StateID, String CityID, String Image1, String Image2, String Image3, String Description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateHotel/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}", new Object[]{HotelID, HotelName, CostPerRoom, StateID, CityID, Image1, Image2, Image3, Description})).request().post(null);
    }

    public void removeRole(String RoleID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeRole/{0}", new Object[]{RoleID})).request().delete();
    }

    public <T> T getUserByFirstName(Class<T> responseType, String fname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getuserByFirstName/{0}", new Object[]{fname}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void addBlog(String BlogTitle, String BlogImage, String Questions, String Answers, String Description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addblog/{0}/{1}/{2}/{3}/{4}", new Object[]{BlogTitle, BlogImage, Questions, Answers, Description})).request().post(null);
    }

    public <T> T getBusName(Class<T> responseType, String Bname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getBusName/{0}", new Object[]{Bname}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void updateUser(String UserID, String FirstName, String MiddleName, String LastName, String EmailID, String ContactNumber, String Password, String IsActive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateuser/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{UserID, FirstName, MiddleName, LastName, EmailID, ContactNumber, Password, IsActive})).request().post(null);
    }

    public <T> T getBlogById(Class<T> responseType, String BlogID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getblogById/{0}", new Object[]{BlogID}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getHotelById(Class<T> responseType, String HotelID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getHotelById/{0}", new Object[]{HotelID}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T SearchPacagesByName(Class<T> responseType, String PackageName) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SearchPacagesByName/{0}", new Object[]{PackageName}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void updateRating(String PackageRatingID, String PackageID, String RatingStar, String UserID, String Description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updaterating/{0}/{1}/{2}/{3}/{4}", new Object[]{PackageRatingID, PackageID, RatingStar, UserID, Description})).request().post(null);
    }

    public void updateEnquiry(String EnquiryID, String UserID, String ContactNumber, String EmailID, String Message) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateenquiry/{0}/{1}/{2}/{3}/{4}", new Object[]{EnquiryID, UserID, ContactNumber, EmailID, Message})).request().post(null);
    }

    public void addSplaces(String CategoryID, String PlaceID, String SubPlaceName, String StateID, String CityID, String Description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addSplaces/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{CategoryID, PlaceID, SubPlaceName, StateID, CityID, Description})).request().post(null);
    }

    public void updateSplaces(String SubPlaceID, String CategoryID, String PlaceID, String SubPlaceName, String StateID, String CityID, String Description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateSplaces/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{SubPlaceID, CategoryID, PlaceID, SubPlaceName, StateID, CityID, Description})).request().post(null);
    }

    public void updateOffer(String OfferID, String OfferName, String IsSpecial, String Description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateOffer/{0}/{1}/{2}/{3}", new Object[]{OfferID, OfferName, IsSpecial, Description})).request().post(null);
    }

    public void removePlaces(String PlaceID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removePlaces/{0}", new Object[]{PlaceID})).request().delete();
    }

    public <T> T getAllCancleBookingDeatil(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getallCancleBookingDeatil");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void removeCity(String CityID, String StateID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeCity/{0}/{1}", new Object[]{CityID, StateID})).request().delete();
    }

    public <T> T getAllEnquiry(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getallEnquiry");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
