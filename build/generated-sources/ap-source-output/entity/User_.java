package entity;

import entity.Cancelbooking;
import entity.Enquiry;
import entity.Packagebooking;
import entity.Packagerating;
import entity.Payment;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-24T09:55:44")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> lastName;
    public static volatile CollectionAttribute<User, Enquiry> enquiryCollection;
    public static volatile CollectionAttribute<User, Packagerating> packageratingCollection;
    public static volatile SingularAttribute<User, String> emailID;
    public static volatile SingularAttribute<User, Boolean> isActive;
    public static volatile SingularAttribute<User, Integer> userID;
    public static volatile CollectionAttribute<User, Payment> paymentCollection;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> password;
    public static volatile CollectionAttribute<User, Cancelbooking> cancelbookingCollection;
    public static volatile CollectionAttribute<User, Packagebooking> packagebookingCollection;
    public static volatile SingularAttribute<User, String> contactNumber;
    public static volatile SingularAttribute<User, String> middleName;

}