/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Blog;
import entity.Cancelbooking;
import entity.City;
import entity.Enquiry;
import entity.Packagebooking;
import entity.Packagerating;
import entity.Packages;
import entity.Payment;
import entity.Role;
import entity.User;
import java.util.Collection;
import java.util.Date;
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
public class UserBean implements UserBeanLocal {

    @PersistenceContext(unitName = "FinalJavaProjectPU")
    EntityManager em;

    @Override
    public Collection<User> getAllUser() {
        return em.createNamedQuery("User.findAll").getResultList();
    }

    @Override
    public void addUser(String FirstName, String MiddleName, String LastName, String EmailID, String ContactNumber, String Password, Boolean IsActive) {
        User u = new User(FirstName, MiddleName, LastName, EmailID, ContactNumber, Password, IsActive);
        em.persist(u);
    }

    @Override
    public void updateUser(Integer UserID, String FirstName, String MiddleName, String LastName, String EmailID, String ContactNumber, String Password, Boolean IsActive) {
        User u = em.find(User.class, UserID);
        u.setFirstName(FirstName);
        u.setMiddleName(MiddleName);
        u.setLastName(LastName);
        u.setEmailID(EmailID);
        u.setContactNumber(ContactNumber);
        u.setIsActive(true);

        em.merge(u);
    }

    @Override
    public void removeUser(Integer UserID) {
        User u = (User) em.find(User.class, UserID);

        System.out.println(u);
        if (u != null) {
            em.remove(u);
        }

    }

    @Override
    public Collection<User> getUserByFirstName(String fname) {
        Collection<User> users = em.createNamedQuery("User.findByFirstName")
                .setParameter("firstName", fname)
                .getResultList();

        return users;
    }

    @Override
    public Collection<User> getUserById(Integer userID) {
        return em.createNamedQuery("User.findByUserID")
                .setParameter("userID", userID)
                .getResultList();
    }

    @Override
    public Collection<Blog> getAllBlog() {
        return em.createNamedQuery("Blog.findAll").getResultList();
    }

    @Override
    public void addBlog(String BlogTitle, String BlogImage, String Questions, String Answers, String Description) {
        Blog blog = new Blog(BlogTitle, BlogImage, Questions, Answers, Description);
        em.persist(blog);
    }

    @Override
    public void updateBlog(Integer BlogID, String BlogTitle, String BlogImage, String Questions, String Answers, String Description) {
        Blog b = em.find(Blog.class, BlogID);
        b.setBlogTitle(BlogTitle);
        b.setBlogImage(BlogImage);
        b.setQuestions(Questions);
        b.setAnswers(Answers);
        b.setDescription(Description);

        em.merge(b);
    }

    @Override
    public void removeBlog(Integer BlogID) {
        Blog b = (Blog) em.find(Blog.class, BlogID);
        em.remove(b);
    }

    @Override
    public Collection<Blog> getBlogName(String Blogname) {
        Collection<Blog> blog = em.createNamedQuery("Blog.findByBlogTitle")
                .setParameter("blogTitle", Blogname)
                .getResultList();

        return blog;
    }

    @Override
    public Blog getBlogById(Integer BlogID) {
        return em.find(Blog.class, BlogID);
    }

    @Override
    public Collection<Packagerating> getAllPackageRate() {
        return em.createNamedQuery("Packagerating.findAll").getResultList();
    }

    @Override
    public void giveRating(Integer PackageID, Integer RatingStar, Integer UserID, String Description) {
        User u = em.find(User.class, UserID);
        Packages p = em.find(Packages.class, PackageID);

        Collection<Packagerating> pb = p.getPackageratingCollection();
        Collection<Packagerating> pb1 = u.getPackageratingCollection();
        Packagerating packagerate = new Packagerating();
        packagerate.setPackageID(p);
        packagerate.setRatingStar(RatingStar);
        packagerate.setUserID(u);
        packagerate.setDescription(Description);

        pb.add(packagerate);
        pb1.add(packagerate);
        p.setPackageratingCollection(pb);
        u.setPackageratingCollection(pb1);

        em.persist(packagerate);
        em.merge(u);
        em.merge(p);

    }

    @Override
    public void updateRating(Integer PackageRatingID, Integer PackageID, Integer RatingStar, Integer UserID, String Description) {
        Packagerating pr1 = em.find(Packagerating.class, PackageRatingID);
        pr1.setRatingStar(RatingStar);
        em.merge(pr1);

    }

    @Override
    public Collection<Packagebooking> getAllPackageBooking() {
        return em.createNamedQuery("Packagebooking.findAll").getResultList();
    }

    @Override
    public void addBookPackagesInfo(Integer PackageID, Integer UserID, Integer NoOfTravelers, String EmailID, Integer ContactNumber, Date BookingDate) {

        User u = em.find(User.class, UserID);
        Packages p = em.find(Packages.class, PackageID);

        Collection<Packagebooking> pb = p.getPackagebookingCollection();
        Collection<Packagebooking> pb1 = u.getPackagebookingCollection();
        Packagebooking packagebook = new Packagebooking();
        packagebook.setNoOfTravelers(NoOfTravelers);
        packagebook.setEmailID(EmailID);
        packagebook.setContactNumber(ContactNumber);
        packagebook.setBookingDate(new Date());
        packagebook.setUserID(u);
        packagebook.setPackageID(p);

        pb.add(packagebook);
        pb1.add(packagebook);
        u.setPackagebookingCollection(pb1);
        p.setPackagebookingCollection(pb);

        em.persist(packagebook);
        em.merge(u);
        em.merge(p);

    }

    @Override
    public void updateBookPackage(Integer PackageBookingID, Integer PackageID, Integer UserID, Integer NoOfTravelers, String EmailID, Integer ContactNumber, Date BookingDate) {
        Packages p = em.find(Packages.class, PackageID);
        Packagebooking pb = em.find(Packagebooking.class, PackageBookingID);
        User u = em.find(User.class, UserID);

        pb.setNoOfTravelers(NoOfTravelers);
        pb.setUserID(u);
        pb.setPackageID(p);
        pb.setBookingDate(new Date());
        pb.setContactNumber(ContactNumber);
        pb.setEmailID(EmailID);

        em.merge(pb);
    }

    @Override
    public Packagebooking getPackageBookingById(Integer PackageBookingID) {
        return em.find(Packagebooking.class, PackageBookingID);
    }

    @Override
    public Collection<Payment> getAllPayment() {
        return em.createNamedQuery("Payment.findAll").getResultList();
    }

    @Override
    public void addPayment(Integer UserID, Integer PackageID, Integer AccountNo, String BankIFSC, Integer Amount, Date Date) {
        User u = em.find(User.class, UserID);
        Packages p = em.find(Packages.class, PackageID);

        Collection<Payment> pb = p.getPaymentCollection();
        Collection<Payment> pb1 = u.getPaymentCollection();
        Payment payment = new Payment();
        payment.setAccountNo(AccountNo);
        payment.setBankIFSC(BankIFSC);
        payment.setAmount(Amount);
        payment.setDate(new Date());
        payment.setUserID(u);
        payment.setPackageID(p);

        pb.add(payment);
        pb1.add(payment);
        u.setPaymentCollection(pb1);
        p.setPaymentCollection(pb);

        em.persist(payment);
        em.merge(u);
        em.merge(p);

    }

    @Override
    public void updatePayment(Integer PaymentID, Integer UserID, Integer PackageID, Integer AccountNo, String BankIFSC, Integer Amount, Date Date) {
        Packages p = em.find(Packages.class, PackageID);
        Payment pm = em.find(Payment.class, PaymentID);
        User u = em.find(User.class, UserID);

        pm.setUserID(u);
        pm.setPackageID(p);
        pm.setAccountNo(AccountNo);
        pm.setAmount(Amount);
        pm.setBankIFSC(BankIFSC);
        pm.setDate(new Date());

        em.merge(pm);
    }

    @Override
    public Collection<Cancelbooking> getAllCancleBookingDeatil() {
        return em.createNamedQuery("Cancelbooking.findAll").getResultList();
    }

    @Override
    public void addCancelBooking(Integer UserID, Integer PackageID, Integer PaymentID, String ReasonForCancel, Date Date) {
        User u = em.find(User.class, UserID);
        Packages p = em.find(Packages.class, PackageID);
        Payment pm = em.find(Payment.class, PaymentID);

        Collection<Cancelbooking> pb = u.getCancelbookingCollection();
        Collection<Cancelbooking> pb1 = p.getCancelbookingCollection();
        Collection<Cancelbooking> pb2 = pm.getCancelbookingCollection();

        Cancelbooking cancelBooking = new Cancelbooking();
        cancelBooking.setReasonForCancel(ReasonForCancel);
        cancelBooking.setPaymentID(pm);
        cancelBooking.setDate(new Date());
        cancelBooking.setUserID(u);
        cancelBooking.setPackageID(p);

        pb.add(cancelBooking);
        pb1.add(cancelBooking);
        pb2.add(cancelBooking);
        u.setCancelbookingCollection(pb);
        p.setCancelbookingCollection(pb1);
        pm.setCancelbookingCollection(pb2);
        em.persist(cancelBooking);
        em.merge(u);
        em.merge(p);
        em.merge(pm);
    }

    @Override
    public Collection<Enquiry> getAllEnquiry() {
        return em.createNamedQuery("Enquiry.findAll").getResultList();
    }

    @Override
    public void addEnquiry(Integer UserID, Integer ContactNumber, String EmailID, String Message) {
        User u = em.find(User.class, UserID);

        Collection<Enquiry> enquiry = u.getEnquiryCollection();
        Enquiry enq = new Enquiry();
        enq.setContactNumber(ContactNumber);
        enq.setEmailID(EmailID);
        enq.setMessage(Message);
        enq.setUserID(u);
        enquiry.add(enq);
        u.setEnquiryCollection(enquiry);
        em.persist(enq);
        em.merge(u);

    }

    @Override
    public void updateEnquiry(Integer EnquiryID, Integer UserID, Integer ContactNumber, String EmailID, String Message) {
        Enquiry en = em.find(Enquiry.class, EnquiryID);
        User u = em.find(User.class, UserID);

        en.setUserID(u);
        en.setContactNumber(ContactNumber);
        en.setEmailID(EmailID);
        en.setMessage(Message);

        em.merge(en);
    }

    @Override
    public void removeEnquiry(Integer EnquiryID) {
        Enquiry e = em.find(Enquiry.class, EnquiryID);
        em.remove(e);
    }

    @Override
    public Collection<Enquiry> getEnquiryDetail(String Edetail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getEnquiryById(Integer EnquiryID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
//    
    @Override
    public User getUserByEmailPassword(String emailID, String password) {
        User u = (User) em.createNamedQuery("User.findByEmailPassword").setParameter("emailID", emailID).setParameter("password", password).getSingleResult();
        if (u == null) {
            return null;
        } else {
            return u;
        }
    }

    @Override
    public Collection<Object[]> MultipleSearchOfPackageIndex(int CategoryID,int StateID, int NoOfDays, int PackageCharge) {
        try {
            Query query = em.createNativeQuery("SELECT  p.packageID,p.packageName,p.noOfDays,p.noOfNights,p.packageCharge,p.fromDate,p.toDate,p.image1,p.image2,p.image3,p.image4,p.scheduleDescription,ct.categoryID,ct.categoryName\n"
                    + "FROM packages p\n"
                    + "INNER JOIN category ct ON p.categoryID = ct.categoryID\n"
                    + "INNER JOIN state st ON p.stateID = st.stateID\n"
                    + "WHERE p.categoryID = ?CategoryID AND p.stateID = ?StateID AND p.noOfDays <= ?NoOfDays AND p.packageCharge <= ?PackageCharge", "MultipleSearchOfPackages");

            query.setParameter("CategoryID", CategoryID);
            query.setParameter("StateID", StateID);
            query.setParameter("NoOfDays", NoOfDays);
            query.setParameter("PackageCharge", PackageCharge);

            Collection<Object[]> obj = query.getResultList();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Packages GetPackageBYID(int PackageID) {

        Packages objPackage = (Packages) em.find(Packages.class, PackageID);
        return objPackage;
    }

    @Override
    public Collection<Object[]> GetPackageDesc(int PackageID) {
        try {
            Query query = em.createNativeQuery("SELECT  p.packageID,p.packageName,p.noOfDays,p.noOfNights,p.packageCharge,p.fromDate,p.toDate,p.image1,p.image2,p.image3,p.image4,p.scheduleDescription,ct.categoryID,ct.categoryName,ct.description,ct.image,s.stateName,s.stateID\n"
                    + "FROM packages p\n"
                    + "INNER JOIN category ct ON p.categoryID = ct.categoryID\n"
                    + "INNER JOIN state s ON p.stateID = s.stateID\n"
                    + //"INNER JOIN bus details 'b ON p.busID = b.busID\n" +
                    //,b.busName,b.totalSeats,b.costPerSeat,b.image1,b.image2,b.description,h.hotelName,h.costPerRoom,h.image1,h.image2,h.image3,h.description
                    //"INNER JOIN manage hotel h ON p.hotelID = h.hotelID\n" +
                    "WHERE p.packageID = ?PackageID", "GetPackageDescs");

            query.setParameter("PackageID", PackageID);

            Collection<Object[]> obj = query.getResultList();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Collection<Object[]> GetUserCart(int UserID) {
        try {
            Query query = em.createNativeQuery("SELECT  pb.packageBookingID,pb.noOfTravelers,pb.emailID,pb.contactNumber,pb.bookingDate,p.packageID,p.packageName,p.packageCharge,p.image1,u.userID\n"
                    + "FROM packagebooking pb\n"
                    + "INNER JOIN packages p ON pb.packageID = p.packageID\n"
                    + "INNER JOIN user u ON pb.userID = u.userID\n"
                    + //"INNER JOIN category ct ON p.categoryID = ct.categoryID\n" +
                    //"INNER JOIN category ct ON p.categoryID = ct.categoryID\n" +
                    "WHERE pb.userID = ?UserID", "GetUserCart");

            query.setParameter("UserID", UserID);

            Collection<Object[]> obj = query.getResultList();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeBookPackage(Integer PackageBookingID) {
        try {
            Query query = em.createNativeQuery("DELETE\n"
                    + "FROM packagebooking\n"
                    + "WHERE packageBookingID = ?PackageBookingID", "removeBookPackage");
            query.setParameter("PackageBookingID", PackageBookingID);
            query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }

//        Packages p = em.find(Packages.class, PackageID);
//        User u = em.find(User.class, UserID);
//        Packagebooking pb = em.find(Packagebooking.class, PackageBookingID);
//        Collection<Packagebooking> pbs = p.getPackagebookingCollection();
//        Collection<Packagebooking> pbs1 = u.getPackagebookingCollection();
//        if (pbs.contains(pb)) {
//            pbs.remove(pb);
//            u.setPackagebookingCollection(pbs1);
//            pbs1.remove(pb);
//            p.setPackagebookingCollection(pbs);
//            em.merge(p);
//            em.merge(u);
//            em.merge(pb);
//        }
    }

//    @Override
//    public Collection<Object[]> GetpayByUserPackage(int PackageBookingID) {
//        try {
//            Query query = em.createNativeQuery("SELECT  pb.packageID,pb.noOfTravelers,pb.emailID,pb.contactNumber,pb.bookingDate,pb.userID,pb.packageBookingID\n"
//                    + "FROM packagebooking pb\n"
//                    + "INNER JOIN packages p ON pb.packageID = p.packageID\n"
//                    + "INNER JOIN user u ON pb.userID = u.userID\n"
//                    + //"INNER JOIN category ct ON p.categoryID = ct.categoryID\n" +
//                    //"INNER JOIN category ct ON p.categoryID = ct.categoryID\n" +
//                    "WHERE pb.userID = ?UserID AND pb.packageID = ?PackageID", "GetpayByUserPackage");
//
//            query.setParameter("UserID", UserID);
//            query.setParameter("PackageID", PackageID);
//            Collection<Object[]> obj = query.getResultList();
//            return obj;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @Override
    public Collection<Object[]> getPaymentByUserId(Integer UserID) {
        try {
            Query query = em.createNativeQuery("SELECT  p.paymentID,p.amount,p.date,p.userID,p.packageID,u.firstName,u.userID,pk.packageName,pk.packageID\n"
                    + "FROM payment p\n"
                    + "INNER JOIN user u ON p.userID = u.userID\n"
                    + "INNER JOIN packages pk ON p.packageID = pk.packageID\n"
                    + //"INNER JOIN category ct ON p.categoryID = ct.categoryID\n" +
                    "WHERE p.userID = ?UserID", "getPaymentByUserId");

            query.setParameter("UserID", UserID);

            Collection<Object[]> obj = query.getResultList();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Payment GetPaymentBYID(int PaymentID) {
        Payment objPackage = (Payment) em.find(Payment.class, PaymentID);
        return objPackage;
    }

    @Override
    public Collection<Packagebooking> getPackageBokingById(Integer packageBookingID) {
          return em.createNamedQuery("Packagebooking.findByPackageBookingID")
                .setParameter("packageBookingID", packageBookingID)
                .getResultList();
    }

}
