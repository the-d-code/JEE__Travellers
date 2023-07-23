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
import entity.Cancelbooking;
import entity.Enquiry;
import entity.Packagebooking;
import entity.Packagerating;
import entity.Packages;
import entity.Payment;
import entity.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Radhika Maniya
 */
@Named(value = "UserMangedBean")
@ApplicationScoped
public class UserMangedBean {

    @EJB
    AdminBeanLocal ASBL;

//    new
    @EJB
    private UserBeanLocal userBean;
    Collection<Packages> PackDesc, bookDesc;
    Collection<Packagebooking> packbook, packbooktopay,bookConfirm;
    Collection<Payment> paycart;
    Collection<User> userinfo;
    rstClient restc = new rstClient();
    //    =================all collection==========
    //    =====================all generic==================
    private GenericType<Collection<Packagerating>> packageRatinggeneric;
    Collection<Packagerating> packageRatinglist;
    private GenericType<Collection<Packages>> packagegeneric;
    Collection<Packages> packagelist;
    private GenericType<Collection<Enquiry>> enquirygeneric;
    Collection<Enquiry> enquirylist;
    private GenericType<Collection<Packagebooking>> bookinggeneric;
    Collection<Packagebooking> bookinglist;
    private GenericType<Collection<Cancelbooking>> cancelbookgeneric;
    Collection<Cancelbooking> cancelbooklist;
    private GenericType<Collection<Payment>> paymentgeneric;
    Collection<Payment> paymentlist;
    Collection<User> UserProfile;
    //    =======================all objects===================
    Packagerating packageRating = new Packagerating();
    Packagebooking packageBooking = new Packagebooking();
    Cancelbooking cancelBooking = new Cancelbooking();
    Payment payment = new Payment();
    Enquiry enquiry = new Enquiry();
    //    =====================add type declaration==================

    private String PackageRatingID, PackageID, RatingStar, RRUserID, Description;
    private String PbankIfsc;

    int PaymentPackageID, PaccountNo, Pamount;
    static Packages objShowPackage = new Packages();

//    login register
    restClientUser rest = new restClientUser();
    private User user;
    String emailID,username, Password;
    private User us;
    private Response res;
    private String passwordConfirm;
    private String EnquiryID, EUserID, EContactNumber, EEmailID, EMessage;
    private String BookEmail;
    Date BookDate, Pdate;
    int bPackID, NoOfTraveler, BookContact, pbUserID;
    private String UFirstName, UMiddleName, ULastName, UEmailID, UContactNumber, UPassword;
    int ProfileuserID;
    private GenericType<User> u;
    int packBookId;
    public static final String SALT = "secret-code";

    public UserMangedBean() {
        user = new User();
    }

//    ==============================LOGIN RGISTR==================================
    public AdminBeanLocal getASBL() {
        return ASBL;
    }

    public void setASBL(AdminBeanLocal ASBL) {
        this.ASBL = ASBL;
    }

    public restClientUser getRest() {
        return rest;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    
    
    public Collection<Packagebooking> getBookConfirm() {
        return bookConfirm;
    }

    public void setBookConfirm(Collection<Packagebooking> bookConfirm) {
        this.bookConfirm = bookConfirm;
    }

    public Collection<Packages> getBookDesc() {
        return bookDesc;
    }

    public int getPackBookId() {
        return packBookId;
    }

    public void setPackBookId(int packBookId) {
        this.packBookId = packBookId;
    }

    public Collection<Payment> getPaycart() {
        return paycart;
    }

    public void setPaycart(Collection<Payment> paycart) {
        this.paycart = paycart;
    }

    public void setBookDesc(Collection<Packages> bookDesc) {
        this.bookDesc = bookDesc;
    }

    public static String getSALT() {
        return SALT;
    }

    public void setRest(restClientUser rest) {
        this.rest = rest;
    }

    public Date getPdate() {
        return Pdate;
    }

    public void setPdate(Date Pdate) {
        this.Pdate = Pdate;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public GenericType<Collection<Packages>> getPackagegeneric() {
        return packagegeneric;
    }

    public Collection<Packagebooking> getPackbook() {
        return packbook;
    }

    public void setPackbook(Collection<Packagebooking> packbook) {
        this.packbook = packbook;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public User getUs() {
        return us;
    }

    public void setUs(User us) {
        this.us = us;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public GenericType<User> getU() {
        return u;
    }

    public void setU(GenericType<User> u) {
        this.u = u;
    }

    public rstClient getRestc() {
        return restc;
    }

    public void setRestc(rstClient restc) {
        this.restc = restc;
    }

    public Date getBookDate() {
        return BookDate;
    }

    public void setBookDate(Date BookDate) {
        this.BookDate = BookDate;
    }

    public int getbPackID() {
        return bPackID;
    }

    public void setbPackID(int bPackID) {
        this.bPackID = bPackID;
    }

    public int getNoOfTraveler() {
        return NoOfTraveler;
    }

    public void setNoOfTraveler(int NoOfTraveler) {
        this.NoOfTraveler = NoOfTraveler;
    }

    public int getBookContact() {
        return BookContact;
    }

    public Collection<User> getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Collection<User> userinfo) {
        this.userinfo = userinfo;
    }

    public void setBookContact(int BookContact) {
        this.BookContact = BookContact;
    }

    public GenericType<Collection<Packagerating>> getPackageRatinggeneric() {
        return packageRatinggeneric;
    }

    public void setPackageRatinggeneric(GenericType<Collection<Packagerating>> packageRatinggeneric) {
        this.packageRatinggeneric = packageRatinggeneric;
    }

    public Collection<Packagerating> getPackageRatinglist() {
        return packageRatinglist;
    }

    public void setPackageRatinglist(Collection<Packagerating> packageRatinglist) {
        this.packageRatinglist = packageRatinglist;
    }

    public Packagerating getPackageRating() {
        return packageRating;
    }

    public void setPackageRating(Packagerating packageRating) {
        this.packageRating = packageRating;
    }

    public String getPackageRatingID() {
        return PackageRatingID;
    }

    public void setPackageRatingID(String PackageRatingID) {
        this.PackageRatingID = PackageRatingID;
    }

    public String getPackageID() {
        return PackageID;
    }

    public String getPbankIfsc() {
        return PbankIfsc;
    }

    public void setPbankIfsc(String PbankIfsc) {
        this.PbankIfsc = PbankIfsc;
    }

    public int getPaymentPackageID() {
        return PaymentPackageID;
    }

    public void setPaymentPackageID(int PaymentPackageID) {
        this.PaymentPackageID = PaymentPackageID;
    }

    public int getPaccountNo() {
        return PaccountNo;
    }

    public void setPaccountNo(int PaccountNo) {
        this.PaccountNo = PaccountNo;
    }

    public int getPamount() {
        return Pamount;
    }

    public void setPamount(int Pamount) {
        this.Pamount = Pamount;
    }

    public void setPackageID(String PackageID) {
        this.PackageID = PackageID;
    }

    public String getRatingStar() {
        return RatingStar;
    }

    public void setRatingStar(String RatingStar) {
        this.RatingStar = RatingStar;
    }

    public String getRRUserID() {
        return RRUserID;
    }

    public Collection<Packagebooking> getPackbooktopay() {
        return packbooktopay;
    }

    public void setPackbooktopay(Collection<Packagebooking> packbooktopay) {
        this.packbooktopay = packbooktopay;
    }

    public void setRRUserID(String RRUserID) {
        this.RRUserID = RRUserID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public static Packages getObjShowPackage() {
        return objShowPackage;
    }

    public GenericType<Collection<Enquiry>> getEnquirygeneric() {
        return enquirygeneric;
    }

    public void setEnquirygeneric(GenericType<Collection<Enquiry>> enquirygeneric) {
        this.enquirygeneric = enquirygeneric;
    }

    public Collection<Enquiry> getEnquirylist() {
        return enquirylist;
    }

    public void setEnquirylist(Collection<Enquiry> enquirylist) {
        this.enquirylist = enquirylist;
    }

    public Enquiry getEnquiry() {
        return enquiry;
    }

    public void setEnquiry(Enquiry enquiry) {
        this.enquiry = enquiry;
    }

    public String getEnquiryID() {
        return EnquiryID;
    }

    public void setEnquiryID(String EnquiryID) {
        this.EnquiryID = EnquiryID;
    }

    public String getEUserID() {
        return EUserID;
    }

    public void setEUserID(String EUserID) {
        this.EUserID = EUserID;
    }

    public String getEContactNumber() {
        return EContactNumber;
    }

    public void setEContactNumber(String EContactNumber) {
        this.EContactNumber = EContactNumber;
    }

    public int getPbUserID() {
        return pbUserID;
    }

    public void setPbUserID(int pbUserID) {
        this.pbUserID = pbUserID;
    }

    public Collection<Packages> getPackDesc() {
        return PackDesc;
    }

    public void setPackDesc(Collection<Packages> PackDesc) {
        this.PackDesc = PackDesc;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getEEmailID() {
        return EEmailID;
    }

    public void setEEmailID(String EEmailID) {
        this.EEmailID = EEmailID;
    }

    public String getEMessage() {
        return EMessage;
    }

    public void setEMessage(String EMessage) {
        this.EMessage = EMessage;
    }

    public GenericType<Collection<Packagebooking>> getBookinggeneric() {
        return bookinggeneric;
    }

    public void setBookinggeneric(GenericType<Collection<Packagebooking>> bookinggeneric) {
        this.bookinggeneric = bookinggeneric;
    }

    public Collection<Packagebooking> getBookinglist() {
        return bookinglist;
    }

    public void setBookinglist(Collection<Packagebooking> bookinglist) {
        this.bookinglist = bookinglist;
    }

    public GenericType<Collection<Cancelbooking>> getCancelbookgeneric() {
        return cancelbookgeneric;
    }

    public void setCancelbookgeneric(GenericType<Collection<Cancelbooking>> cancelbookgeneric) {
        this.cancelbookgeneric = cancelbookgeneric;
    }

    public Collection<Cancelbooking> getCancelbooklist() {
        return cancelbooklist;
    }

    public void setCancelbooklist(Collection<Cancelbooking> cancelbooklist) {
        this.cancelbooklist = cancelbooklist;
    }

    public Packagebooking getPackageBooking() {
        return packageBooking;
    }

    public void setPackageBooking(Packagebooking packageBooking) {
        this.packageBooking = packageBooking;
    }

    public Cancelbooking getCancelBooking() {
        return cancelBooking;
    }

    public void setCancelBooking(Cancelbooking cancelBooking) {
        this.cancelBooking = cancelBooking;
    }

    public UserBeanLocal getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBeanLocal userBean) {
        this.userBean = userBean;
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

    public Collection<User> getUserProfile() {
        return UserProfile;
    }

    public void setUserProfile(Collection<User> UserProfile) {
        this.UserProfile = UserProfile;
    }

    public String getUFirstName() {
        return UFirstName;
    }

    public void setUFirstName(String UFirstName) {
        this.UFirstName = UFirstName;
    }

    public String getUMiddleName() {
        return UMiddleName;
    }

    public void setUMiddleName(String UMiddleName) {
        this.UMiddleName = UMiddleName;
    }

    public String getULastName() {
        return ULastName;
    }

    public void setULastName(String ULastName) {
        this.ULastName = ULastName;
    }

    public String getUEmailID() {
        return UEmailID;
    }

    public void setUEmailID(String UEmailID) {
        this.UEmailID = UEmailID;
    }

    public String getUContactNumber() {
        return UContactNumber;
    }

    public void setUContactNumber(String UContactNumber) {
        this.UContactNumber = UContactNumber;
    }

    public String getUPassword() {
        return UPassword;
    }

    public void setUPassword(String UPassword) {
        this.UPassword = UPassword;
    }

    public int getProfileuserID() {
        return ProfileuserID;
    }

    public void setProfileuserID(int ProfileuserID) {
        this.ProfileuserID = ProfileuserID;
    }

    public String getBookEmail() {
        return BookEmail;
    }

    public void setBookEmail(String BookEmail) {
        this.BookEmail = BookEmail;
    }

    public static void setObjShowPackage(Packages objShowPackage) {
        UserMangedBean.objShowPackage = objShowPackage;
    }

    public String registerUser() {
        String saltedPassword = SALT + user.getPassword();
        String hashedPassword = generateHash(saltedPassword);
        rest.addUser(user.getFirstName(), user.getMiddleName(), user.getLastName(), user.getEmailID(), user.getContactNumber(), hashedPassword, String.valueOf(user.getIsActive()));
        clearUser();
        return "/Login/Login.xhtml?faces-redirect=true";
    }

    public String loginUser() {
//        Users a = ab.getUserByEmailPassword(user.getEmail(), user.getPassword());
//        clearUser();
//        System.out.print(a.getAddress());
        u = new GenericType<User>() {
        };
        String saltedPassword = SALT + user.getPassword();
        String hashedPassword = generateHash(saltedPassword);
        res = rest.getUsername(Response.class, user.getUsername(), hashedPassword);

        System.out.println(res);
        if (res.getStatus() == 200) {
            clearUser();
            User a = res.readEntity(u);
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("user", a);
            session.setMaxInactiveInterval(150 * 600);
            us = (User) session.getAttribute("user");
            System.out.print(us);
            this.RRUserID = us.getUserID().toString();
            System.out.print(RRUserID);
            this.EUserID = us.getUserID().toString();
            this.pbUserID = us.getUserID();
            this.ProfileuserID = us.getUserID();
            Collection<User> UserProfile = new ArrayList<User>();
            UserProfile = (Collection<User>) userBean.getUserById(pbUserID);
            this.setUserProfile(UserProfile);
//set cart
Collection<Packagebooking> lstSearchPackage = new ArrayList<Packagebooking>();
        Collection<Object[]> lst = userBean.GetUserCart(ProfileuserID);
        lst.stream().forEach((record) -> {
//            System.out.println("Bean.AdminManagedBean.searchPackagesIndex()");
            String id = "" + record[0];
            lstSearchPackage.add(userBean.getPackageBookingById(Integer.valueOf(id)));
//            System.out.println(record[0]);
        });
        this.setPackbook(lstSearchPackage);
            
//            set pay table
  Collection<Payment> lstPayUser = new ArrayList<Payment>();
            Collection<Object[]> lstpay = userBean.getPaymentByUserId(ProfileuserID);
            lstpay.stream().forEach((record) -> {
//            System.out.println("Bean.AdminManagedBean.searchPackagesIndex()");
                String id = "" + record[0];
                lstPayUser.add(userBean.GetPaymentBYID(Integer.valueOf(id)));
//            System.out.println(record[0]);
            });
            this.setPaycart(lstPayUser);
            
            this.emailID = "admin@gmail.com";
            this.Password = a.getPassword();
            if (us.getEmailID() == emailID) {
                System.out.println("admin");
                return "/admin2/index.xhtml?faces-redirect=true";
            } else {
                return "/user/index.xhtml?faces-redirect=true";
            }
        } else {
            clearUser();
//            open error popup
            return "/Login/Login.xhtml?faces-redirect=true";
        }
    }

    public String logoutUser() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session.getAttribute("user") != null) {
//            us = (Users) session.getAttribute("user");
//            System.out.print(us);
            session.removeAttribute("user");
        }
        return "/Login/Login.xhtml?faces-redirect=true";
    }

    public void validatePasswordCorrect(FacesContext context, UIComponent component,
            Object value) {

        // Retrieve the value passed to this method
        String confirmPassword = (String) value;

        // Retrieve the temporary value from the password field
        UIInput passwordInput = (UIInput) component.findComponent("password");
        String password = (String) passwordInput.getLocalValue();

        if (password == null || confirmPassword == null || !password.equals(confirmPassword)) {
            String message = context.getApplication().evaluateExpressionGet(context, "#{msgs['nomatch']}", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }

    public static String generateHash(String input) {
        StringBuilder hash = new StringBuilder();

        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = sha.digest(input.getBytes());
            char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
            for (int idx = 0; idx < hashedBytes.length; ++idx) {
                byte b = hashedBytes[idx];
                hash.append(digits[(b & 0xf0) >> 4]);
                hash.append(digits[b & 0x0f]);
            }
        } catch (NoSuchAlgorithmException e) {
            // handle error here.
        }

        return hash.toString();
    }

    public void clearUser() {
        user = new User();
        setPasswordConfirm("");
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @PostConstruct
    public void init() {
        
    }

    public String addpackageRating(Integer pid) {
//       restc.addOffer(PackageRating, "1", offerdescription);
        if (EUserID == null) {
            return "Login.xhtml?faces-redirect=true";
        } else {

//      this.RRUserID = "1"; 
            this.PackageID = pid.toString();

//  this.PackageID = "1";
            System.out.println("userID=" + this.RRUserID);
            System.out.println("PackageID=" + this.PackageID);
            System.out.println("ratingStar=" + this.RatingStar);
            System.out.println("Description=" + this.Description);
            restc.giveRating(PackageID, RatingStar, RRUserID, Description);
//      restc.giveRating("12","5","1", "ssssss");
            this.packageRating = new Packagerating();
            //System.out.println(this.packageRating);
            return "packages";
        }
    }

//    =================================Start Enquiry=========================
    public String addEnquiry() {
//       restc.addOffer(PackageRating, "1", offerdescription);

//      this.EUserID = "1"; 
//  this.PackageID = "1";
        if (EUserID == null) {
            return "/Login/Login.xhtml?faces-redirect=true";
        } else {

            System.out.println("userID=" + this.EUserID);
            System.out.println("Email=" + this.EEmailID);
            System.out.println("message=" + this.EMessage);
            System.out.println("pno=" + this.EContactNumber);

            restc.addEnquiry(EUserID, EContactNumber, EEmailID, EMessage);
            clearEnquiry();
        }

        return "";
    }

    public void clearEnquiry() {
        EContactNumber = "";
        EEmailID = "";
        EMessage = "";
    }

    public Collection<Enquiry> findAllEnquiry() {
        enquirygeneric = new GenericType<Collection<Enquiry>>() {
        };
        res = restc.getAllEnquiry(Response.class);
        Collection<Enquiry> enquiry = res.readEntity(enquirygeneric);
        return enquiry;
    }

//    =================================End Enquiry=========================  
    public Collection<Packages> findAllPackage() {
        packagegeneric = new GenericType<Collection<Packages>>() {
        };
        
//        res = restc.getAllBus(Response.class);
        res = restc.getAllPackages(Response.class);

        Collection<Packages> packages = res.readEntity(packagegeneric);
        return packages;
    }

    public String GetPackageDesc(Packages p) {
//        System.out.println("test");
        Collection<Packages> Packagedesc = new ArrayList<Packages>();
        Collection<Object[]> pd = userBean.GetPackageDesc(p.getPackageID());
        pd.stream().forEach((record) -> {
            System.out.println("Bean.AdminManagedBean.searchPackagesIndex()");
            String id = "" + record[0];
            Packagedesc.add(userBean.GetPackageBYID(Integer.valueOf(id)));
            System.out.println(record[0]);
        });
        this.setPackDesc(Packagedesc);
        return "package_desc";
    }

    public String GetCart() {
        if (EUserID == null) {
            return "/Login/Login.xhtml?faces-redirect=true";
        } else {
            System.out.println("check it radhika" + EUserID);
            Collection<Packagebooking> lstSearchPackage = new ArrayList<Packagebooking>();
            Collection<Object[]> lst = userBean.GetUserCart(ProfileuserID);
            lst.stream().forEach((record) -> {
//            System.out.println("Bean.AdminManagedBean.searchPackagesIndex()");
                String id = "" + record[0];
                lstSearchPackage.add(userBean.getPackageBookingById(Integer.valueOf(id)));
//            System.out.println(record[0]);
            });
            this.setPackbook(lstSearchPackage);
            return "PackageCart";
        }
    }

    public String GoToBooking(Packages p) {
        if (EUserID == null) {

            return "/Login/Login.xhtml?faces-redirect=true";
        } else {
            System.out.println("testradhika");
            Collection<Packages> bookPackage = new ArrayList<Packages>();
            Collection<User> userinfo = new ArrayList<User>();

            Collection<Object[]> bp = userBean.GetPackageDesc(p.getPackageID());
            userinfo = (Collection<User>) userBean.getUserById(pbUserID);
            bp.stream().forEach((record) -> {
                System.out.println("Bean.AdminManagedBean.searchPackagesIndex()");
                String id = "" + record[0];
                bookPackage.add(userBean.GetPackageBYID(Integer.valueOf(id)));
                System.out.println(record[0]);
            });
//        System.out.println(userinfo.);
            this.setBookDesc(bookPackage);
            this.setUserinfo(userinfo);
        }
        return "PackageBooking";
    }

    public String AddBooking(Packages p, User U) {
        this.bPackID = p.getPackageID();
        this.BookEmail = U.getEmailID();
//           this.BookContact=U.getContactNumber();
        this.BookDate = new Date();
//           this.NoOfTraveler=p.getb
        System.out.println("hello=" + bPackID);
        System.out.println("pno=" + EUserID + NoOfTraveler + BookEmail + BookContact + BookDate);
        if (EUserID == null) {
            return "/Login/Login.xhtml?faces-redirect=true";
        } else {
            Collection<User> userinfo1 = new ArrayList<User>();
            userBean.addBookPackagesInfo(bPackID, pbUserID, NoOfTraveler, BookEmail, BookContact, BookDate);
            this.setNoOfTraveler(NoOfTraveler);
            this.packageBooking = new Packagebooking();
            return "Payment";
        }

    }

//       shruti
    //  ==================================Book Packages=========================
    public Collection<Packagebooking> findAllBookPackage() {
        bookinggeneric = new GenericType<Collection<Packagebooking>>() {
        };
        res = restc.getAllPackageBooking(Response.class);
        Collection<Packagebooking> packageBooking = res.readEntity(bookinggeneric);
        return packageBooking;
    }

//  ==================================End Book Packages=========================
//  ==================================Cacle bookPackages=========================
    public Collection<Cancelbooking> findAllcaclebookPackage() {
        cancelbookgeneric = new GenericType<Collection<Cancelbooking>>() {
        };
        res = restc.getAllCancleBookingDeatil(Response.class);

        Collection<Cancelbooking> cancelBooking = res.readEntity(cancelbookgeneric);
        return cancelBooking;
    }

//  ==================================End canclebook Packages=========================
    //         =================================fetch rating review details==================  
    public Collection<Packagerating> findAllReview() {
        packageRatinggeneric = new GenericType<Collection<Packagerating>>() {
        };
        res = restc.getAllPackageRate(Response.class);
        Collection<Packagerating> packageRating = res.readEntity(packageRatinggeneric);
        return packageRating;
    }

//          =================================End fetch rating review details==================
    // =====================================payment Start========================
    public String AddPayment(Packages p, int amount) {
//           System.out.println("hello Amount how are you"+Amount);
        if (EUserID == null) {
            return "/Login/Login.xhtml?faces-redirect=true";
        } else {

            this.PaymentPackageID = p.getPackageID();
            this.Pdate = new Date();
//           Pamount=nooftra*p.getPackageCharge();
            this.Pamount = p.getPackageCharge();
            System.out.println(Pamount);
            userBean.addPayment(pbUserID, PaymentPackageID, PaccountNo, PbankIfsc, amount, Pdate);
//          userBean.addPayment(pbUserID, bPackID, PaccountNo, PbankIfsc, Amount, Pdate);

            this.payment = new Payment();

            return "index";
        }

    }

    public String GoToPayment(Packagebooking pb) {
        if (EUserID == null) {

            return "/Login/Login.xhtml?faces-redirect=true";
        } else {
            System.out.println(pb.getPackageBookingID());
            Collection<Packagebooking> Packagebook = userBean.getPackageBokingById(pb.getPackageBookingID());

            this.setPackbooktopay(Packagebook);
            return "PaymentFromCart";
        }

    }

    public String PaymentFromCart(Packagebooking pb, int amount) {
//           System.out.println("hello Amount how are you"+Amount);
        if (EUserID == null) {
            return "/Login/Login.xhtml?faces-redirect=true";
        } else {

            this.PaymentPackageID = pb.getPackageID().getPackageID();
            this.Pdate = new Date();
            userBean.addPayment(pbUserID, PaymentPackageID, PaccountNo, PbankIfsc, amount, Pdate);
//          userBean.addPayment(pbUserID, bPackID, PaccountNo, PbankIfsc, Amount, Pdate);
             
            this.payment = new Payment();
//             this.setBookConfirm((Collection<Packagebooking>) pb);
//            return "PackageConfirmation";
return "index";
        }

    }

    public String deletepackbook(Integer packBookId) {
//        this.packBookId=pb.getPackageBookingID();
        System.out.println("hello Pack booking id" + packBookId);
        userBean.removeBookPackage(packBookId);

        return "PackageCart";
    }

    //    ==============================paymnt===================================

//          ===============================payment end================================
    public String EditProfile(User u) {
        this.UFirstName = u.getFirstName();
        this.UMiddleName = u.getMiddleName();
        this.UEmailID = u.getEmailID();
        this.UContactNumber = u.getContactNumber();
        this.ULastName = u.getLastName();
        this.UPassword = u.getPassword();

        return "EditUserProfile";
    }

    public String EditProfile() {

        //restc.updateUser(EUserID, UFirstName, UMiddleName, ULastName, UEmailID, UContactNumber, UPassword, "true");
        userBean.updateUser(ProfileuserID, UFirstName, UMiddleName, ULastName, UEmailID, UContactNumber, UPassword, true);
        this.user = new User();
        System.out.println("FirstNAMEEE:" + this.UFirstName);
//        Collection<User> UserProfile = new ArrayList<User>();
//        UserProfile = (Collection<User>) userBean.getUserById(pbUserID);
        return "UserProfile";
    }

}
