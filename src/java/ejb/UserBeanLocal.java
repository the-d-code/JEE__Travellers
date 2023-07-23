/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Blog;
import entity.Cancelbooking;
import entity.Enquiry;
import entity.Packagebooking;
import entity.Packagerating;
import entity.Packages;
import entity.Payment;
import entity.User;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author Admin
 */
@Local
public interface UserBeanLocal {
    
     //    ==================USer=================
         Collection<User> getAllUser();
        void addUser(String FirstName, String MiddleName, String LastName,String EmailID,String ContactNumber,String Password,Boolean IsActive);
        void updateUser(Integer UserID,String FirstName, String MiddleName, String LastName,String EmailID,String ContactNumber,String Password,Boolean IsActive);
        void removeUser(Integer UserID);
        Collection<User> getUserByFirstName(String fname);
         Collection<User> getUserById(Integer userID);
         
          User getUserByEmailPassword(String emailID,String password);
  
    
     //===============================Blog==================================
         
          Collection<Blog> getAllBlog();
          void addBlog(String BlogTitle,String BlogImage,String Questions,String Answers,String Description);
          void updateBlog(Integer BlogID,String BlogTitle,String BlogImage,String Questions,String Answers,String Description);
          void removeBlog(Integer BlogID);
          Collection<Blog> getBlogName(String Blogname);
         Blog getBlogById(Integer BlogID);
     //======================Packages Rating==========================   
      
       Collection<Packagerating> getAllPackageRate();
      void giveRating(Integer PackageID,Integer RatingStar,Integer UserID,String Description);
       void updateRating(Integer PackageRatingID,Integer PackageID,Integer RatingStar,Integer UserID,String Description);
      
  //=======================PackageBooking=========================
       
       Collection<Packagebooking> getAllPackageBooking();
       void addBookPackagesInfo(Integer PackageID,Integer UserID,Integer NoOfTravelers,String EmailID,Integer ContactNumber,Date BookingDate);
       void updateBookPackage(Integer PackageBookingID,Integer PackageID,Integer UserID,Integer NoOfTravelers,String EmailID,Integer ContactNumber,Date BookingDate);
       void removeBookPackage(Integer PackageBookingID);
       // Collection<PackageBooking> getPackageById(Integer PackageBookingID);
         Packagebooking getPackageBookingById(Integer PackageBookingID);
         Collection<Packagebooking> getPackageBokingById(Integer PackageBookingID);
//======================Payment==========================
      Collection<Payment> getAllPayment();
      void addPayment(Integer UserID,Integer PackageID,Integer AccountNo,String BankIFSC,Integer Amount,Date Date);
      void updatePayment(Integer PaymentID,Integer UserID,Integer PackageID,Integer AccountNo,String BankIFSC,Integer Amount,Date Date);
      public Collection<Object[]> getPaymentByUserId(Integer UserID);
      
          //======================CancleBooking==============
         
          Collection<Cancelbooking> getAllCancleBookingDeatil();
         void addCancelBooking(Integer UserID,Integer PackageID,Integer PaymentID,String ReasonForCancel,Date Date);
         
          //===========================Enquiry============================
         
         Collection<Enquiry> getAllEnquiry();
         void addEnquiry(Integer UserID,Integer ContactNumber,String EmailID,String Message);
         void updateEnquiry(Integer EnquiryID,Integer UserID,Integer ContactNumber,String EmailID,String Message);
         void removeEnquiry(Integer EnquiryID);
          Collection<Enquiry> getEnquiryDetail(String Edetail);
         User getEnquiryById(Integer EnquiryID);
         
         //============================Roles=======================
//         void addRole(String RoleName,String UserName, DateTime CreatedAt, DateTime UpdatedAt);
//         void updateRole(Integer RoleID,String RoleName,String UserName, DateTime CreatedAt, DateTime UpdatedAt);
//         void removeRole(Integer RoleID);
         
//         package methods
    public Collection<Object[]> MultipleSearchOfPackageIndex(int CategoryID,int StateID,int NoOfDays,int PackageCharge);
     public Packages GetPackageBYID(int PackageID);
     public Payment GetPaymentBYID(int PaymentID);
    public Collection<Object[]> GetPackageDesc(int PackageID);
    public Collection<Object[]> GetUserCart(int UserID);   
//    public Collection<Object[]> GetpayByUserPackage(int UserID,int PackageID);  
}
