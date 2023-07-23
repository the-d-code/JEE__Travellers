/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import RestClient.restClientUser;
import RestClient.rstClient;
import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import entity.Busdetails;
import entity.Category;
import entity.City;
import entity.Managehotel;
import entity.Offer;
import entity.Packages;
import entity.Payment;
import entity.State;
import entity.User;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
//import static entity.Category_.categoryID;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Radhika Maniya
 */
@Named(value = "adminManagedBean")
@ApplicationScoped
public class AdminManagedBean {

    @EJB
    private AdminBeanLocal adminBean;
//    new
    @EJB
    private UserBeanLocal userBean;
    Collection<Packages> multipleSearchOfPackage, Fourpackages;
    Collection<Packages> PackDesc, bookDesc, packCat, adminPackage;
    Collection<Packages> Cats;
    Collection<Managehotel> hotels;
    Collection<Busdetails> buscollection;
    Collection<Payment> PayOFPackage;
    Collection<City> CityByStateId;
    private String State;
//    restClientUser rest=new restClientUser();
    rstClient restc = new rstClient();
    restClientUser restcuser = new restClientUser();
    private Response res;

//    =================all collection==========
    private Collection<String> catname;
    private Collection<String> statename;
    private Collection<String> cityname;
    private Collection<String> offername;
    private Collection<String> busname;
    private Collection<String> username;

    private Collection<String> packagename;

//    =====================all generic==================
    private GenericType<Collection<Category>> categorygeneric;
    Collection<Category> categorylist;
    private GenericType<Collection<Category>> scategorygeneric;
    Collection<Category> scategorylist;
    private GenericType<Collection<State>> stategeneric;
    Collection<State> statelist;
    private GenericType<Collection<City>> citygeneric;
    Collection<City> citylist;
    private GenericType<Collection<Offer>> offergeneric;
    Collection<Offer> offerlist;
    private GenericType<Collection<Busdetails>> busgeneric;
    Collection<Busdetails> buslist;
    private GenericType<Collection<Packages>> packagegeneric;
    Collection<Packages> packagelist;
    GenericType<Collection<Managehotel>> hotelgeneric;
    Collection<Managehotel> hotellist;
    GenericType<Collection<User>> usergeneric;
    Collection<User> userlist;
    GenericType<Collection<Payment>> paymentgeneric;
    Collection<Payment> paymentlist;
//    =======================all objects===================
    Category category = new Category();
    City city = new City();
    State state = new State();
    Offer offer = new Offer();
    Busdetails busdetails = new Busdetails();
    Packages packages = new Packages();
    Managehotel objHotel = new Managehotel();
    User user = new User();

//    =====================add type declaration==================
    private String StateId, StateName;
    private String CityId, CityName, SID;
    private String categoryName, description, categoryId, cimage;
    private Part catfile;
    String catgrfile;
    ;
      private String offerID, offerName, isSpecial, offerdescription;
    int offerPrice;

    private String busID, busName, totalSeats, fromCityID, toCityID, costPerSeat, availableSeat, bimage1, bimage2, bimage3, busdescription;
    private Part busfile, busfile2, busfile1;
    String busgrfile, busgrfile1, busgrfile2;
    Date FromDate, ToDate;
    private String PackageID, packageName, pname, pImage1, pImage2, pImage3, pImage4, ScheDescription;
    private Part packagefile, packagefile2, packagefile1, packagefile3, packagefile4;
    String packagegrfile, packagegrfile1, packagegrfile2, packagegrfile3, packagegrfile4;
    int StaID, pbusID, HotID, CatID, NoOfDays, NoOfNights, PackCharge;
    String HotelID, HStateID, HCityID, HotelName, Image1, Image2, Image3;
    int CostPerRoom;
    private Part file, file2, file1;
    String grfile, grfile1, grfile2;
    int spCatId, spNOD,spStaId, spPackageCharge, cstateId, pacDesID;
    int PackcatID, paymentPackageID, AdmincatID,saStaId,saCityID,busFromId,busToId;

    public AdminManagedBean() {
    }

    public UserBeanLocal getUserBean() {
        return userBean;
    }

    public Collection<City> getCityByStateId() {
        return CityByStateId;
    }

    public String getCimage() {
        return cimage;
    }

    public int getSaStaId() {
        return saStaId;
    }

    public void setSaStaId(int saStaId) {
        this.saStaId = saStaId;
    }

    public int getSaCityID() {
        return saCityID;
    }

    public Collection<Busdetails> getBuscollection() {
        return buscollection;
    }

    public void setBuscollection(Collection<Busdetails> buscollection) {
        this.buscollection = buscollection;
    }

    public void setSaCityID(int saCityID) {
        this.saCityID = saCityID;
    }

    public Collection<Packages> getPackCat() {
        return packCat;
    }

    public int getSpStaId() {
        return spStaId;
    }

    public int getBusFromId() {
        return busFromId;
    }

    public void setBusFromId(int busFromId) {
        this.busFromId = busFromId;
    }

    public int getBusToId() {
        return busToId;
    }

    public void setBusToId(int busToId) {
        this.busToId = busToId;
    }

    public void setSpStaId(int spStaId) {
        this.spStaId = spStaId;
    }

    public Collection<Packages> getCats() {
        return Cats;
    }

    public void setCats(Collection<Packages> Cats) {
        this.Cats = Cats;
    }

    public int getAdmincatID() {
        return AdmincatID;
    }

    public void setAdmincatID(int AdmincatID) {
        this.AdmincatID = AdmincatID;
    }

    public Collection<Payment> getPayOFPackage() {
        return PayOFPackage;
    }

    public void setPayOFPackage(Collection<Payment> PayOFPackage) {
        this.PayOFPackage = PayOFPackage;
    }

    public void setPackCat(Collection<Packages> packCat) {
        this.packCat = packCat;
    }

    public void setCimage(String cimage) {
        this.cimage = cimage;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Part getCatfile() {
        return catfile;
    }

    public void setCatfile(Part catfile) {
        this.catfile = catfile;
    }

    public String getCatgrfile() {
        return catgrfile;
    }

    public void setCatgrfile(String catgrfile) {
        this.catgrfile = catgrfile;
    }

    public restClientUser getRestcuser() {
        return restcuser;
    }

    public void setRestcuser(restClientUser restcuser) {
        this.restcuser = restcuser;
    }

    public Collection<String> getUsername() {
        return username;
    }

    public void setUsername(Collection<String> username) {
        this.username = username;
    }

    public GenericType<Collection<User>> getUsergeneric() {
        return usergeneric;
    }

    public void setUsergeneric(GenericType<Collection<User>> usergeneric) {
        this.usergeneric = usergeneric;
    }

    public Collection<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(Collection<User> userlist) {
        this.userlist = userlist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCityByStateId(Collection<City> CityByStateId) {
        this.CityByStateId = CityByStateId;
    }

    public int getCstateId() {
        return cstateId;
    }

    public void setCstateId(int cstateId) {
        this.cstateId = cstateId;
    }

    public void setUserBean(UserBeanLocal userBean) {
        this.userBean = userBean;
    }

    public Collection<Packages> getMultipleSearchOfPackage() {
        return multipleSearchOfPackage;
    }

    public void setMultipleSearchOfPackage(Collection<Packages> multipleSearchOfPackage) {
        this.multipleSearchOfPackage = multipleSearchOfPackage;
    }

    public int getStaID() {
        return StaID;
    }

    public void setStaID(int StaID) {
        this.StaID = StaID;
    }

    public int getPbusID() {
        return pbusID;
    }

    public void setPbusID(int pbusID) {
        this.pbusID = pbusID;
    }

    public int getHotID() {
        return HotID;
    }

    public void setHotID(int HotID) {
        this.HotID = HotID;
    }

    public int getPaymentPackageID() {
        return paymentPackageID;
    }

    public void setPaymentPackageID(int paymentPackageID) {
        this.paymentPackageID = paymentPackageID;
    }

    public Collection<Packages> getFourpackages() {
        return Fourpackages;
    }

    public void setFourpackages(Collection<Packages> Fourpackages) {
        this.Fourpackages = Fourpackages;
    }

    public int getCatID() {
        return CatID;
    }

    public void setCatID(int CatID) {
        this.CatID = CatID;
    }

    public int getNoOfDays() {
        return NoOfDays;
    }

    public void setNoOfDays(int NoOfDays) {
        this.NoOfDays = NoOfDays;
    }

    public int getNoOfNights() {
        return NoOfNights;
    }

    public void setNoOfNights(int NoOfNights) {
        this.NoOfNights = NoOfNights;
    }

//    public String getpCategoryID() {
//        return pCategoryID;
//    }
//
//    public void setpCategoryID(String pCategoryID) {
//        this.pCategoryID = pCategoryID;
//    }
//  public String getpStateID() {
//        return pStateID;
//    }
//
//    public void setpStateID(String pStateID) {
//        this.pStateID = pStateID;
//    }
//        public String getpBusID() {
//        return pBusID;
//    }
//
//    public void setpBusID(String pBusID) {
//        this.pBusID = pBusID;
//    }
//
//    public String getpHotelID() {
//        return pHotelID;
//    }
//
//    public void setpHotelID(String pHotelID) {
//        this.pHotelID = pHotelID;
//    }
    public Collection<String> getCatname() {
        return catname;
    }

    public GenericType<Collection<Category>> getScategorygeneric() {
        return scategorygeneric;
    }

    public void setScategorygeneric(GenericType<Collection<Category>> scategorygeneric) {
        this.scategorygeneric = scategorygeneric;
    }

    public Collection<Category> getScategorylist() {
        return scategorylist;
    }

    public void setScategorylist(Collection<Category> scategorylist) {
        this.scategorylist = scategorylist;
    }

    public void setCatname(Collection<String> catname) {
        this.catname = catname;
    }

    public int getSpCatId() {
        return spCatId;
    }

    public void setSpCatId(int spCatId) {
        this.spCatId = spCatId;
    }

    public int getPackCharge() {
        return PackCharge;
    }

    public void setPackCharge(int PackCharge) {
        this.PackCharge = PackCharge;
    }

    public int getSpNOD() {
        return spNOD;
    }

    public void setSpNOD(int spNOD) {
        this.spNOD = spNOD;
    }

    public int getSpPackageCharge() {
        return spPackageCharge;
    }

    public void setSpPackageCharge(int spPackageCharge) {
        this.spPackageCharge = spPackageCharge;
    }

    public int getPacDesID() {
        return pacDesID;
    }

    public void setPacDesID(int pacDesID) {
        this.pacDesID = pacDesID;
    }

    public Collection<Packages> getPackDesc() {
        return PackDesc;
    }

    public void setPackDesc(Collection<Packages> PackDesc) {
        this.PackDesc = PackDesc;
    }

    public rstClient getRestc() {
        return restc;
    }

    public void setRestc(rstClient restc) {
        this.restc = restc;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public GenericType<Collection<Category>> getCategorygeneric() {
        return categorygeneric;
    }

    public void setCategorygeneric(GenericType<Collection<Category>> categorygeneric) {
        this.categorygeneric = categorygeneric;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public int getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(int offerPrice) {
        this.offerPrice = offerPrice;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Category> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(Collection<Category> categorylist) {
        this.categorylist = categorylist;
    }

    public Collection<String> getStatename() {
        return statename;
    }

    public void setStatename(Collection<String> statename) {
        this.statename = statename;
    }

    public Collection<String> getCityname() {
        return cityname;
    }

    public void setCityname(Collection<String> cityname) {
        this.cityname = cityname;
    }

    public GenericType<Collection<State>> getStategeneric() {
        return stategeneric;
    }

    public void setStategeneric(GenericType<Collection<State>> stategeneric) {
        this.stategeneric = stategeneric;
    }

    public Collection<State> getStatelist() {
        return statelist;
    }

    public void setStatelist(Collection<State> statelist) {
        this.statelist = statelist;
    }

    public GenericType<Collection<City>> getCitygeneric() {
        return citygeneric;
    }

    public void setCitygeneric(GenericType<Collection<City>> citygeneric) {
        this.citygeneric = citygeneric;
    }

    public Collection<City> getCitylist() {
        return citylist;
    }

    public Collection<String> getPackagename() {
        return packagename;
    }

    public void setPackagename(Collection<String> packagename) {
        this.packagename = packagename;
    }

    public void setCitylist(Collection<City> citylist) {
        this.citylist = citylist;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getStateId() {
        return StateId;
    }

    public void setStateId(String StateId) {
        this.StateId = StateId;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String StateName) {
        this.StateName = StateName;
    }

    public String getCityId() {
        return CityId;
    }

    public void setCityId(String CityId) {
        this.CityId = CityId;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public Collection<String> getOffername() {
        return offername;
    }

    public void setOffername(Collection<String> offername) {
        this.offername = offername;
    }

    public GenericType<Collection<Offer>> getOffergeneric() {
        return offergeneric;
    }

    public void setOffergeneric(GenericType<Collection<Offer>> offergeneric) {
        this.offergeneric = offergeneric;
    }

    public Collection<Offer> getOfferlist() {
        return offerlist;
    }

    public void setOfferlist(Collection<Offer> offerlist) {
        this.offerlist = offerlist;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public String getOfferID() {
        return offerID;
    }

    public void setOfferID(String offerID) {
        this.offerID = offerID;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(String isSpecial) {
        this.isSpecial = isSpecial;
    }

    public String getOfferdescription() {
        return offerdescription;
    }

    public void setOfferdescription(String offerdescription) {
        this.offerdescription = offerdescription;
    }

    public Collection<String> getBusname() {
        return busname;
    }

    public void setBusname(Collection<String> busname) {
        this.busname = busname;
    }

    public GenericType<Collection<Busdetails>> getBusgeneric() {
        return busgeneric;
    }

    public void setBusgeneric(GenericType<Collection<Busdetails>> busgeneric) {
        this.busgeneric = busgeneric;
    }

    public Collection<Busdetails> getBuslist() {
        return buslist;
    }

    public void setBuslist(Collection<Busdetails> buslist) {
        this.buslist = buslist;
    }

    public Busdetails getBusdetails() {
        return busdetails;
    }

    public void setBusdetails(Busdetails busdetails) {
        this.busdetails = busdetails;
    }

    public String getBusID() {
        return busID;
    }

    public void setBusID(String busID) {
        this.busID = busID;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(String totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getFromCityID() {
        return fromCityID;
    }

    public void setFromCityID(String fromCityID) {
        this.fromCityID = fromCityID;
    }

    public String getToCityID() {
        return toCityID;
    }

    public Collection<Packages> getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(Collection<Packages> bookDesc) {
        this.bookDesc = bookDesc;
    }

    public void setToCityID(String toCityID) {
        this.toCityID = toCityID;
    }

    public String getCostPerSeat() {
        return costPerSeat;
    }

    public void setCostPerSeat(String costPerSeat) {
        this.costPerSeat = costPerSeat;
    }

    public String getAvailableSeat() {
        return availableSeat;
    }

    public Collection<Managehotel> getHotels() {
        return hotels;
    }

    public void setHotels(Collection<Managehotel> hotels) {
        this.hotels = hotels;
    }

    public void setAvailableSeat(String availableSeat) {
        this.availableSeat = availableSeat;
    }

    public String getBimage1() {
        return bimage1;
    }

    public void setBimage1(String bimage1) {
        this.bimage1 = bimage1;
    }

    public String getBimage2() {
        return bimage2;
    }

    public void setBimage2(String bimage2) {
        this.bimage2 = bimage2;
    }

    public String getBimage3() {
        return bimage3;
    }

    public void setBimage3(String bimage3) {
        this.bimage3 = bimage3;
    }

    public String getBusdescription() {
        return busdescription;
    }

    public void setBusdescription(String busdescription) {
        this.busdescription = busdescription;
    }

    public Part getBusfile() {
        return busfile;
    }

    public void setBusfile(Part busfile) {
        this.busfile = busfile;
    }

    public Collection<Packages> getAdminPackage() {
        return adminPackage;
    }

    public void setAdminPackage(Collection<Packages> adminPackage) {
        this.adminPackage = adminPackage;
    }

    public GenericType<Collection<Payment>> getPaymentgeneric() {
        return paymentgeneric;
    }

    public void setPaymentgeneric(GenericType<Collection<Payment>> paymentgeneric) {
        this.paymentgeneric = paymentgeneric;
    }

    public Collection<Payment> getPaymentlist() {
        return paymentlist;
    }

    public void setPaymentlist(Collection<Payment> paymentlist) {
        this.paymentlist = paymentlist;
    }

    public Part getBusfile2() {
        return busfile2;
    }

    public void setBusfile2(Part busfile2) {
        this.busfile2 = busfile2;
    }

    public Part getBusfile1() {
        return busfile1;
    }

    public void setBusfile1(Part busfile1) {
        this.busfile1 = busfile1;
    }

    public String getBusgrfile() {
        return busgrfile;
    }

    public void setBusgrfile(String busgrfile) {
        this.busgrfile = busgrfile;
    }

    public String getBusgrfile1() {
        return busgrfile1;
    }

    public void setBusgrfile1(String busgrfile1) {
        this.busgrfile1 = busgrfile1;
    }

    public String getBusgrfile2() {
        return busgrfile2;
    }

    public void setBusgrfile2(String busgrfile2) {
        this.busgrfile2 = busgrfile2;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

//
//    public Collection<String> getPackagename() {
//        return packagename;
//    }
//
//    public void setPackagename(Collection<String> packagename) {
//        this.packagename = packagename;
//    }
    public GenericType<Collection<Packages>> getPackagegeneric() {
        return packagegeneric;
    }

    public void setPackagegeneric(GenericType<Collection<Packages>> packagegeneric) {
        this.packagegeneric = packagegeneric;
    }

    public Collection<Packages> getPackagelist() {
        return packagelist;
    }

    public void setPackagelist(Collection<Packages> packagelist) {
        this.packagelist = packagelist;
    }

    public Packages getPackages() {
        return packages;
    }

    public void setPackages(Packages packages) {
        this.packages = packages;
    }

    public String getImage1() {
        return Image1;
    }

    public void setImage1(String Image1) {
        this.Image1 = Image1;
    }

    public String getImage2() {
        return Image2;
    }

    public void setImage2(String Image2) {
        this.Image2 = Image2;
    }

    public String getImage3() {
        return Image3;
    }

    public void setImage3(String Image3) {
        this.Image3 = Image3;
    }

    public AdminBeanLocal getAdminBean() {
        return adminBean;
    }

    public void setAdminBean(AdminBeanLocal adminBean) {
        this.adminBean = adminBean;
    }

    public GenericType<Collection<Managehotel>> getHotelgeneric() {
        return hotelgeneric;
    }

    public void setHotelgeneric(GenericType<Collection<Managehotel>> hotelgeneric) {
        this.hotelgeneric = hotelgeneric;
    }

    public Collection<Managehotel> getHotellist() {
        return hotellist;
    }

    public void setHotellist(Collection<Managehotel> hotellist) {
        this.hotellist = hotellist;
    }

    public Managehotel getObjHotel() {
        return objHotel;
    }

    public void setObjHotel(Managehotel objHotel) {
        this.objHotel = objHotel;
    }

    public String getHotelID() {
        return HotelID;
    }

    public void setHotelID(String HotelID) {
        this.HotelID = HotelID;
    }

    public int getPackcatID() {
        return PackcatID;
    }

    public void setPackcatID(int PackcatID) {
        this.PackcatID = PackcatID;
    }

    public int getCostPerRoom() {
        return CostPerRoom;
    }

    public void setCostPerRoom(int CostPerRoom) {
        this.CostPerRoom = CostPerRoom;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String HotelName) {
        this.HotelName = HotelName;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public Part getFile2() {
        return file2;
    }

    public void setFile2(Part file2) {
        this.file2 = file2;
    }

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public String getGrfile() {
        return grfile;
    }

    public void setGrfile(String grfile) {
        this.grfile = grfile;
    }

    public String getGrfile1() {
        return grfile1;
    }

    public void setGrfile1(String grfile1) {
        this.grfile1 = grfile1;
    }

    public String getGrfile2() {
        return grfile2;
    }

    public void setGrfile2(String grfile2) {
        this.grfile2 = grfile2;
    }

    public String getHStateID() {
        return HStateID;
    }

    public void setHStateID(String HStateID) {
        this.HStateID = HStateID;
    }

    public String getHCityID() {
        return HCityID;
    }

    public void setHCityID(String HCityID) {
        this.HCityID = HCityID;
    }

    public String getPackageID() {
        return PackageID;
    }

    public void setPackageID(String PackageID) {
        this.PackageID = PackageID;
    }
//
//    public String getPackageName() {
//        return packageName;
//    }
//
//    public void setPackageName(String packageName) {
//        this.packageName = packageName;
//    }

    public Date getFromDate() {
        return FromDate;
    }

    public void setFromDate(Date FromDate) {
        this.FromDate = FromDate;
    }

    public Date getToDate() {
        return ToDate;
    }

    public void setToDate(Date ToDate) {
        this.ToDate = ToDate;
    }

    public String getpImage1() {
        return pImage1;
    }

    public void setpImage1(String pImage1) {
        this.pImage1 = pImage1;
    }

    public String getpImage2() {
        return pImage2;
    }

    public void setpImage2(String pImage2) {
        this.pImage2 = pImage2;
    }

    public String getpImage3() {
        return pImage3;
    }

    public void setpImage3(String pImage3) {
        this.pImage3 = pImage3;
    }

    public String getpImage4() {
        return pImage4;
    }

    public void setpImage4(String pImage4) {
        this.pImage4 = pImage4;
    }

    public String getScheDescription() {
        return ScheDescription;
    }

    public void setScheDescription(String ScheDescription) {
        this.ScheDescription = ScheDescription;
    }

    public Part getPackagefile() {
        return packagefile;
    }

    public void setPackagefile(Part packagefile) {
        this.packagefile = packagefile;
    }

    public Part getPackagefile2() {
        return packagefile2;
    }

    public void setPackagefile2(Part packagefile2) {
        this.packagefile2 = packagefile2;
    }

    public Part getPackagefile1() {
        return packagefile1;
    }

    public void setPackagefile1(Part packagefile1) {
        this.packagefile1 = packagefile1;
    }

    public Part getPackagefile3() {
        return packagefile3;
    }

    public void setPackagefile3(Part packagefile3) {
        this.packagefile3 = packagefile3;
    }

    public Part getPackagefile4() {
        return packagefile4;
    }

    public void setPackagefile4(Part packagefile4) {
        this.packagefile4 = packagefile4;
    }

    public String getPackagegrfile() {
        return packagegrfile;
    }

    public void setPackagegrfile(String packagegrfile) {
        this.packagegrfile = packagegrfile;
    }

    public String getPackagegrfile1() {
        return packagegrfile1;
    }

    public void setPackagegrfile1(String packagegrfile1) {
        this.packagegrfile1 = packagegrfile1;
    }

    public String getPackagegrfile2() {
        return packagegrfile2;
    }

    public void setPackagegrfile2(String packagegrfile2) {
        this.packagegrfile2 = packagegrfile2;
    }

    public String getPackagegrfile3() {
        return packagegrfile3;
    }

    public void setPackagegrfile3(String packagegrfile3) {
        this.packagegrfile3 = packagegrfile3;
    }

    public String getPackagegrfile4() {
        return packagegrfile4;
    }

    public void setPackagegrfile4(String packagegrfile4) {
        this.packagegrfile4 = packagegrfile4;
    }

    @PostConstruct
    public void init() {
        stategeneric = new GenericType<Collection<State>>() {
        };
        res = restc.getAllState(Response.class);
        this.statelist = res.readEntity(stategeneric);

        categorygeneric = new GenericType<Collection<Category>>() {
        };
        res = restc.getAllCategory(Response.class);
        this.categorylist = res.readEntity(categorygeneric);

        citygeneric = new GenericType<Collection<City>>() {
        };
        res = restc.getAllCity(Response.class);
        this.citylist = res.readEntity(citygeneric);

        busgeneric = new GenericType<Collection<Busdetails>>() {
        };
        res = restc.getAllBus(Response.class);
        this.buslist = res.readEntity(busgeneric);

        hotelgeneric = new GenericType<Collection<Managehotel>>() {
        };
        res = restc.getAllHotel(Response.class);
        this.hotellist = res.readEntity(hotelgeneric);

        packagegeneric = new GenericType<Collection<Packages>>() {
        };
        res = restc.getAllPackages(Response.class);
        this.packagelist = res.readEntity(packagegeneric);

        Collection<Packages> lstSearchPackage = new ArrayList<Packages>();
        Collection<Object[]> lst = adminBean.getFourPackages();
        lst.stream().forEach((record) -> {
//            System.out.println("Bean.AdminManagedBean.searchPackagesIndex()");
            String id = "" + record[0];
            lstSearchPackage.add(userBean.GetPackageBYID(Integer.valueOf(id)));
//            System.out.println(record[0]);
        });
        setFourpackages(lstSearchPackage);

//        Collection<Category> lstSearchCategory = new ArrayList<Category>();
//        Collection<Object[]> lstCat = adminBean.getThreeCategory();
//        lstCat.stream().forEach((record)->{
////            System.out.println("Bean.AdminManagedBean.searchPackagesIndex()");
//            String id= ""+record[0];
//            lstSearchPackage.add(userBean.GetPackageBYID(Integer.valueOf(id)));
////            System.out.println(record[0]);
//            });
//        this.setCats(lstSearchCategory);
    }

    public Collection<Category> categoryList() {
        scategorygeneric = new GenericType<Collection<Category>>() {
        };
        res = restc.getAllCategory(Response.class);
        this.scategorylist = res.readEntity(scategorygeneric);
        return scategorylist;
    }

    public Collection<Category> findAll() {
        categorygeneric = new GenericType<Collection<Category>>() {
        };
        res = restc.getAllCategory(Response.class);
        Collection<Category> category = res.readEntity(categorygeneric);
        return category;
    }

    public String addCategory() throws IOException {
        //        imag1
        InputStream input = catfile.getInputStream();
        String path = "D:\\8thSemProject\\FinalJavaProject\\web\\CategoryUpload";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        sb.append(random.nextInt(9) + 1);
        for (int i = 0; i < 11; i++) {
            sb.append(random.nextInt(10));
        }
        String temp = sb.toString();

        catgrfile = "IMG_" + temp + catfile.getSubmittedFileName();
        Files.copy(input, new File(path, catgrfile).toPath());
        restc.addCategory(categoryName, description, catgrfile);
        this.category = new Category();
        clear();
        return "category";
    }

    public void delete(Category c) {
        this.categoryId = c.getCategoryID().toString();
        restc.removeCategory(categoryId);
    }

    public String edit(Category c) {
        this.categoryId = c.getCategoryID().toString();
        this.categoryName = c.getCategoryName();
        this.description = c.getDescription();
        return "EditCategory";
    }

    public String edit() {
        restc.updateCategory(categoryId, categoryName, description, cimage);
        this.category = new Category();
        clear();
        return "category";
    }

    public void clear() {
        categoryId = "";
        categoryName = "";
        description = "";
    }

//     ==========================State CRUD======================
    public Collection<State> findAllState() {
        stategeneric = new GenericType<Collection<State>>() {
        };
        res = restc.getAllState(Response.class);
        Collection<State> state = res.readEntity(stategeneric);
        return state;

    }

    public String addState() {
        restc.addState(StateName);
        this.state = new State();
        Stateclear();
        return "state";
    }

    public void Stateclear() {
        this.StateId = "";
        this.StateName = "";
    }

    public void deleteState(State s) {
        this.StateId = s.getStateID().toString();
        restc.removeState(StateId);
    }

    public String editState(State s) {
        this.StateId = s.getStateID().toString();
        this.StateName = s.getStateName().toString();

        return "EditState";
    }

    public String editState() {
        restc.updateState(StateId, StateName);
        this.state = new State();
        Stateclear();
        return "state";
    }
//     ==========================End State CRUD======================

//    ==========================Start City CRUD===========================
    public Collection<City> findAllCity() {
        citygeneric = new GenericType<Collection<City>>() {
        };
        res = restc.getAllCity(Response.class);
        Collection<City> city = res.readEntity(citygeneric);
        return city;
    }

    public String addCity() {
        restc.addCity(CityName, SID);
        this.city = new City();
        Cityclear();
        return "city";
    }

    public void Cityclear() {
        this.CityName = "";

    }

    public void deleteCity(City c) {

        this.CityId = c.getCityID().toString();
        State s = c.getStateID();
        this.SID = s.getStateID().toString();
        restc.removeCity(CityId, SID);

    }

    public String editCity(City c) {

        this.CityId = c.getCityID().toString();
        State s = c.getStateID();
        this.SID = s.getStateID().toString();
        this.CityName = c.getCityName();
        return "EditCity";
    }

    public String editCity() {
        restc.updateCity(CityId, CityName, SID);
        this.city = new City();
        Cityclear();
        return "city";

    }

//==========================End City CRUD=========================== 
//  ==========================Start Offer=================================
    public Collection<Offer> findAllOffer() {
        offergeneric = new GenericType<Collection<Offer>>() {
        };
        res = restc.getAllOffer(Response.class);
        Collection<Offer> offer = res.readEntity(offergeneric);
        return offer;

    }

    public String addOffer() {
        restc.addOffer(offerName, "1", offerdescription, offerPrice);
        this.offer = new Offer();
        System.out.println("Price==" + this.offerPrice);
        Offerclear();
        return "offer.xhtml";
    }

    public void Offerclear() {
        this.offerName = "";
        this.offerdescription = "";
        this.offerPrice = 0;
    }

    public void deleteOffer(Offer o) {
        this.offerID = o.getOfferID().toString();
        restc.removeOffer(offerID);
    }

    public String editOffer(Offer o) {
        this.offerID = o.getOfferID().toString();
        this.offerName = o.getOfferName();
//        this.isSpecial = o.getIsSpecial().toString();
        this.offerdescription = o.getDescription();
        this.offerPrice = o.getPrice();
        return "EditOffer.xhtml";
    }

    public String editOffer() {
        restc.updateOffer(offerID, offerName, "1", offerdescription, offerPrice);
        this.offer = new Offer();
//        Offerclear();
        return "offer.xhtml";
    }

//    ==========================End Offer=================================
//    ==========================Start BusDetails=================================
    public Collection<Busdetails> findAllBus() {
        busgeneric = new GenericType<Collection<Busdetails>>() {
        };
        res = restc.getAllBus(Response.class);
        Collection<Busdetails> bus = res.readEntity(busgeneric);
        return bus;
    }

    public void addBus() throws IOException {
//        imag1
        InputStream input = busfile.getInputStream();
        String path = "D:\\8thSemProject\\FinalJavaProject\\web\\BusUpload";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        sb.append(random.nextInt(9) + 1);
        for (int i = 0; i < 11; i++) {
            sb.append(random.nextInt(10));
        }
        String temp = sb.toString();

        busgrfile = "IMG_" + temp + busfile.getSubmittedFileName();
        Files.copy(input, new File(path, busgrfile).toPath());
//            imag2
        InputStream input1 = busfile1.getInputStream();
        String path1 = "D:\\8thSemProject\\FinalJavaProject\\web\\BusUpload";
        Random random1 = new Random();
        StringBuilder sb1 = new StringBuilder();

        sb1.append(random1.nextInt(9) + 1);
        for (int i = 0; i < 11; i++) {
            sb1.append(random1.nextInt(10));
        }
        String temp1 = sb1.toString();

        busgrfile1 = "IMG_" + temp1 + busfile1.getSubmittedFileName();
        Files.copy(input1, new File(path1, busgrfile1).toPath());

//imag3
        InputStream input2 = busfile2.getInputStream();
        String path2 = "D:\\8thSemProject\\FinalJavaProject\\web\\BusUpload";
        Random random2 = new Random();
        StringBuilder sb2 = new StringBuilder();

        sb2.append(random2.nextInt(9) + 1);
        for (int i = 0; i < 11; i++) {
            sb2.append(random2.nextInt(10));
        }
        String temp2 = sb2.toString();

        busgrfile2 = "IMG_" + temp2 + busfile2.getSubmittedFileName();
        Files.copy(input2, new File(path2, busgrfile2).toPath());
        restc.addBus(busName, totalSeats, fromCityID, toCityID, costPerSeat, availableSeat, busgrfile, busgrfile1, busgrfile2, busdescription);
        // restc.addHotel(HotelName, CostPerRoom, StateID, CityID, grfile, grfile1, grfile2, description);
//             ASBL.addHotel(HotelName, CostPerRoom, StateID, CityID, Image1, Image2, Image3, description);
        this.category = new Category();
        this.busdetails = new Busdetails();
        FacesContext.getCurrentInstance().getExternalContext().redirect("BusDetail.xhtml");
//        return "BusDetail";
//        return "/admin2/BusDetail.xhtml?faces-redirect=true";
    }

    public void Busclear() {
        busName = "";
        totalSeats = "";
        fromCityID = "";
        toCityID = "";
        costPerSeat = "";
        availableSeat = "";
        busdescription = "";

    }

    public void deleteBus(Busdetails bd) {
        this.busID = bd.getBusID().toString();
        this.fromCityID = bd.getFromCityID().toString();
        this.toCityID = bd.getToCityID().toString();
        restc.removeBus(busID, fromCityID, toCityID);

    }

//    ==========================End BusDetails=================================
//    ==========================Start Packages=================================
    public Collection<Packages> findAllPackage() {
        packagegeneric = new GenericType<Collection<Packages>>() {
        };
////            res= restc.getAllBus(Response.class);
        res = restc.getAllPackages(Response.class);
        Collection<Packages> packages = res.readEntity(packagegeneric);
//            Collection<Packages> packages = adminBean.getAllPackages();
        return packages;

    }

    public String searchPackagesIndex() {
        System.out.println("test");
        Collection<Packages> lstSearchPackage = new ArrayList<Packages>();
        Collection<Object[]> lst = userBean.MultipleSearchOfPackageIndex(spCatId,spStaId, spNOD, spPackageCharge);
        lst.stream().forEach((record) -> {
//            System.out.println("Bean.AdminManagedBean.searchPackagesIndex()");
            String id = "" + record[0];
            lstSearchPackage.add(userBean.GetPackageBYID(Integer.valueOf(id)));
//            System.out.println(record[0]);
        });
        setMultipleSearchOfPackage(lstSearchPackage);
        return "/user/PackagesSearch.xhtml?faces-redirect=true";
    }
//          public String PackageFour()
//    {
//        System.out.println("test");
//        Collection<Packages> lstSearchPackage = new ArrayList<Packages>();
//        Collection<Object[]> lst = adminBean.getFourPackages();
//        lst.stream().forEach((record)->{
////            System.out.println("Bean.AdminManagedBean.searchPackagesIndex()");
//            String id= ""+record[0];
//            lstSearchPackage.add(userBean.GetPackageBYID(Integer.valueOf(id)));
////            System.out.println(record[0]);
//            });
//        setMultipleSearchOfPackage(lstSearchPackage);
//        return "/user/index.xhtml?faces-redirect=true";
//    }

    public String GetPackageByCatID(Category c) {
        System.out.println("Packges from CatID");
        Collection<Packages> lstSearchPackage = new ArrayList<Packages>();
        this.PackcatID = c.getCategoryID();
        Collection<Object[]> lst = adminBean.GetPackageByCatID(PackcatID);
        lst.stream().forEach((record) -> {
//            System.out.println("Bean.AdminManagedBean.searchPackagesIndex()");
            String id = "" + record[0];
            lstSearchPackage.add(userBean.GetPackageBYID(Integer.valueOf(id)));
//            System.out.println(record[0]);
        });
        setMultipleSearchOfPackage(lstSearchPackage);
        return "/user/PackagesSearch.xhtml?faces-redirect=true";
    }

    public String getPackageByCatIDForAdmin() {
        System.out.println("Packges from CatID");
        Collection<Packages> lstSearchPackage = new ArrayList<Packages>();
//        this.PackcatID = c.getCategoryID();
        Collection<Object[]> lst = adminBean.GetPackageByCatID(AdmincatID);
        lst.stream().forEach((record) -> {
//            System.out.println("Bean.AdminManagedBean.searchPackagesIndex()");
            String id = "" + record[0];
            lstSearchPackage.add(userBean.GetPackageBYID(Integer.valueOf(id)));
//            System.out.println(record[0]);
        });
        this.setAdminPackage(lstSearchPackage);
        return "/admin2/SearchOfPackage.xhtml?faces-redirect=true";
    }

        public String findHotelByStateCity() 
        {
        System.out.println("Hotel from State city");
        Collection<Managehotel> lstSearchPackage = new ArrayList<Managehotel>();
//        this.PackcatID = c.getCategoryID();
        Collection<Object[]> lst = adminBean.GetHotelByStatCityID(saStaId,saCityID);
        lst.stream().forEach((record) -> {
//            System.out.println("Bean.AdminManagedBean.searchPackagesIndex()");
            String id = "" + record[0];
            lstSearchPackage.add(adminBean.getHotelById(Integer.valueOf(id)));
//            System.out.println(record[0]);
        });
        this.setHotels(lstSearchPackage);
        return "SearchOfHotel";
    }
        
         public String findBusByCity() {
        System.out.println("bus from city");
        Collection<Busdetails> lstSearchPackage = new ArrayList<Busdetails>();
//        this.PackcatID = c.getCategoryID();
        Collection<Object[]> lst = adminBean.GetCityByCityCityID(busFromId,busToId);
        lst.stream().forEach((record) -> {
//            System.out.println("Bean.AdminManagedBean.searchPackagesIndex()");
            String id = "" + record[0];
            lstSearchPackage.add(adminBean.getBusById(Integer.valueOf(id)));
//            System.out.println(record[0]);
        });
        this.setBuscollection(lstSearchPackage);
        return "SearchOfBus";
    }
        
    public Collection<Payment> findAllPayment() {
        paymentgeneric = new GenericType<Collection<Payment>>() {
        };
        res = restc.getAllPayment(Response.class);
        Collection<Payment> pay = res.readEntity(paymentgeneric);
        return pay;

    }

    public String getPaymentByPackageId() {
        System.out.println("Packges from CatID");
        Collection<Payment> lstSearchPackage = new ArrayList<Payment>();

        Collection<Object[]> lst = adminBean.GetPaymentByPackID(paymentPackageID);
        lst.stream().forEach((record) -> {
//            System.out.println("Bean.AdminManagedBean.searchPackagesIndex()");
            String id = "" + record[0];
            lstSearchPackage.add(userBean.GetPaymentBYID(Integer.valueOf(id)));
//            System.out.println(record[0]);
        });
        this.setPayOFPackage(lstSearchPackage);
        return "SearchOfPayment";
    }

    public String GetPackageDesc(Integer PackageID) {
//        System.out.println("test");
        Collection<Packages> Packagedesc = new ArrayList<Packages>();
        Collection<Object[]> pd = userBean.GetPackageDesc(PackageID);
        pd.stream().forEach((record) -> {
            System.out.println("Bean.AdminManagedBean.searchPackagesIndex()");
            String id = "" + record[0];
            Packagedesc.add(userBean.GetPackageBYID(Integer.valueOf(id)));
            System.out.println(record[0]);
        });
        this.setPackDesc(Packagedesc);
        return "package_desc";
    }

    public String GoToBooking(Packages p) {
        System.out.println("testradhika");
        Collection<Packages> bookPackage = new ArrayList<Packages>();
        Collection<Object[]> bp = userBean.GetPackageDesc(p.getPackageID());
        bp.stream().forEach((record) -> {
            System.out.println("Bean.AdminManagedBean.searchPackagesIndex()");
            String id = "" + record[0];
            bookPackage.add(userBean.GetPackageBYID(Integer.valueOf(id)));
            System.out.println(record[0]);
        });
        this.setBookDesc(bookPackage);
        return "index";
    }

    public String addpackages() throws IOException {
//        imag1
        InputStream input = packagefile.getInputStream();
        String path = "D:\\8thSemProject\\FinalJavaProject\\web\\PackageUpload";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        sb.append(random.nextInt(9) + 1);
        for (int i = 0; i < 11; i++) {
            sb.append(random.nextInt(10));
        }
        String temp = sb.toString();

        packagegrfile = "IMG_" + temp + packagefile.getSubmittedFileName();
        Files.copy(input, new File(path, packagegrfile).toPath());
//        imag2
        InputStream input1 = packagefile1.getInputStream();
        String path1 = "D:\\8thSemProject\\FinalJavaProject\\web\\PackageUpload";
        Random random1 = new Random();
        StringBuilder sb1 = new StringBuilder();

        sb1.append(random1.nextInt(9) + 1);
        for (int i = 0; i < 11; i++) {
            sb1.append(random1.nextInt(10));
        }
        String temp1 = sb1.toString();

        packagegrfile1 = "IMG_" + temp1 + packagefile1.getSubmittedFileName();
        Files.copy(input1, new File(path1, packagegrfile1).toPath());
//        imag3
        InputStream input2 = packagefile2.getInputStream();
        String path2 = "D:\\8thSemProject\\FinalJavaProject\\web\\PackageUpload";
        Random random2 = new Random();
        StringBuilder sb2 = new StringBuilder();

        sb2.append(random2.nextInt(9) + 1);
        for (int i = 0; i < 11; i++) {
            sb2.append(random2.nextInt(10));
        }
        String temp2 = sb2.toString();

        packagegrfile2 = "IMG_" + temp2 + packagefile2.getSubmittedFileName();
        Files.copy(input2, new File(path2, packagegrfile2).toPath());

        //  img4
        InputStream input3 = packagefile3.getInputStream();
        String path3 = "D:\\8thSemProject\\FinalJavaProject\\web\\PackageUpload";
        Random random3 = new Random();
        StringBuilder sb3 = new StringBuilder();

        sb1.append(random3.nextInt(9) + 1);
        for (int i = 0; i < 11; i++) {
            sb1.append(random3.nextInt(10));
        }
        String temp3 = sb3.toString();

        packagegrfile3 = "IMG_" + temp3 + packagefile3.getSubmittedFileName();
        Files.copy(input3, new File(path3, packagegrfile3).toPath());
        adminBean.addPackages(pname, CatID, StaID, pbusID, HotID, NoOfDays, NoOfNights, PackCharge, FromDate, ToDate, packagegrfile, packagegrfile1, packagegrfile2, packagegrfile3, ScheDescription);

        this.packages = new Packages();
        Packageclear();
        return "package";
    }

    public void Packageclear() {
        pname = "";
        CatID = 0;
        StaID = 0;
        pbusID = 0;
        HotID = 0;
        NoOfDays = 0;
        NoOfNights = 0;
        PackCharge = 0;
        FromDate = null;
        ToDate = null;
        ScheDescription = "";

    }
//    ==========================End Packages=================================
//    ==========================Start Hotel=================================
//==============================Manage hotel===========================

    public Collection<Managehotel> findAllHotel() {
        hotelgeneric = new GenericType<Collection<Managehotel>>() {
        };
        res = restc.getAllHotel(Response.class);
        Collection<Managehotel> hotel = res.readEntity(hotelgeneric);
        return hotel;
    }

    public String insertHotel() throws IOException {
//        imag1
        InputStream input = file.getInputStream();
        String path = "D:\\8thSemProject\\FinalJavaProject\\web\\AdminUpload";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        sb.append(random.nextInt(9) + 1);
        for (int i = 0; i < 11; i++) {
            sb.append(random.nextInt(10));
        }
        String temp = sb.toString();

        grfile = "IMG_" + temp + file.getSubmittedFileName();
        Files.copy(input, new File(path, grfile).toPath());
//            imag2
        InputStream input1 = file1.getInputStream();
        String path1 = "D:\\8thSemProject\\FinalJavaProject\\web\\AdminUpload";
        Random random1 = new Random();
        StringBuilder sb1 = new StringBuilder();

        sb1.append(random1.nextInt(9) + 1);
        for (int i = 0; i < 11; i++) {
            sb1.append(random1.nextInt(10));
        }
        String temp1 = sb1.toString();

        grfile1 = "IMG_" + temp1 + file1.getSubmittedFileName();
        Files.copy(input1, new File(path1, grfile1).toPath());

//imag3
        InputStream input2 = file.getInputStream();
        String path2 = "D:\\8thSemProject\\FinalJavaProject\\web\\AdminUpload";
        Random random2 = new Random();
        StringBuilder sb2 = new StringBuilder();

        sb2.append(random2.nextInt(9) + 1);
        for (int i = 0; i < 11; i++) {
            sb2.append(random2.nextInt(10));
        }
        String temp2 = sb2.toString();

        grfile2 = "IMG_" + temp2 + file2.getSubmittedFileName();
        Files.copy(input2, new File(path2, grfile2).toPath());
        restc.addHotel(HotelName, CostPerRoom, HStateID, HCityID, grfile, grfile1, grfile2, description);
        Hotelclear();
        return "ManagHotel";
    }

    public void Hotelclear() {
        HotelName = "";
        CostPerRoom = 0;
        HCityID = "";
        HStateID = "";

        description = "";

    }

    public void deleteHotel(Managehotel h) {
//        this.fromCityID = bd.getFromCityID().toString();
//        this.toCityID = bd.getToCityID().toString();
//        restc.removeBus(busID, fromCityID, toCityID);
        this.HotelID = h.getHotelID().toString();
        this.HStateID=h.getStateID().toString();
        this.HCityID=h.getCityID().toString();
        restc.removeHotel(HotelID,HStateID,HCityID);
    }

    public Collection<Managehotel> hotelList() {
        return adminBean.getAllHotel();
    }

    public String editHotel(int hotelid) {
        for (Managehotel h : hotelList()) {

            if (hotelid == h.getHotelID()) {
                this.setHotelID(h.getHotelID().toString());
                this.setHotelName(h.getHotelName());
                this.setCostPerRoom(h.getCostPerRoom());
                this.setStateId(h.getStateID().getStateID().toString());
                this.setCityId(h.getCityID().getCityID().toString());
                this.setDescription(h.getDescription());
                this.setImage1(h.getImage1());
                this.setImage2(h.getImage2());
                this.setImage3(h.getImage3());

            }

//            return "EditHotel";

        }
        return "EditHotel";
    }
    public String editHotel() throws IOException {
                //        imag1
        InputStream input = file.getInputStream();
        String path = "D:\\8thSemProject\\FinalJavaProject\\web\\AdminUpload";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        sb.append(random.nextInt(9) + 1);
        for (int i = 0; i < 11; i++) {
            sb.append(random.nextInt(10));
        }
        String temp = sb.toString();

        grfile = "IMG_" + temp + file.getSubmittedFileName();
        Files.copy(input, new File(path, grfile).toPath());
//            imag2
        InputStream input1 = file1.getInputStream();
        String path1 = "D:\\8thSemProject\\FinalJavaProject\\web\\AdminUpload";
        Random random1 = new Random();
        StringBuilder sb1 = new StringBuilder();

        sb1.append(random1.nextInt(9) + 1);
        for (int i = 0; i < 11; i++) {
            sb1.append(random1.nextInt(10));
        }
        String temp1 = sb1.toString();

        grfile1 = "IMG_" + temp1 + file1.getSubmittedFileName();
        Files.copy(input1, new File(path1, grfile1).toPath());

//imag3
        InputStream input2 = file.getInputStream();
        String path2 = "D:\\8thSemProject\\FinalJavaProject\\web\\AdminUpload";
        Random random2 = new Random();
        StringBuilder sb2 = new StringBuilder();

        sb2.append(random2.nextInt(9) + 1);
        for (int i = 0; i < 11; i++) {
            sb2.append(random2.nextInt(10));
        }
        String temp2 = sb2.toString();

        grfile2 = "IMG_" + temp2 + file2.getSubmittedFileName();
        Files.copy(input2, new File(path2, grfile2).toPath());
        
        restc.updateHotel(HotelID, HotelName, CostPerRoom, StateId, CityId,grfile, grfile1, grfile2, description);
        this.objHotel = new Managehotel();
//        clear();
        return "ManagHotel";
    }

//    ==========================End Hotel=================================
//    dependentcombo
    public Collection<City> onStateChange() {

        Collection<City> lstSearchPackage = new ArrayList<City>();
        Collection<Object[]> lst = adminBean.getAllCityByStateId(cstateId);
        lst.stream().forEach((record) -> {
            System.out.println("Bean.AdminManagedBean.searchPackagesIndex()");
            String id = "" + record[0];
            lstSearchPackage.add(adminBean.GetCityBYID(Integer.valueOf(id)));
            System.out.println(record[0]);
            System.out.println("hrllozc");
        });
        this.setCityByStateId(lstSearchPackage);
        return lstSearchPackage;

    }
    //    ==================================Start User List==============================

    public Collection<User> findAllUser() {
        usergeneric = new GenericType<Collection<User>>() {
        };
        res = restc.getAllUser(Response.class);
        Collection<User> user = res.readEntity(usergeneric);
        return user;
    }

//    ==================================End User List==============================
}
