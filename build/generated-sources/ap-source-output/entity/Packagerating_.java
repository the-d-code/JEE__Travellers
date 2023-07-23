package entity;

import entity.Packages;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-24T09:55:44")
@StaticMetamodel(Packagerating.class)
public class Packagerating_ { 

    public static volatile SingularAttribute<Packagerating, Packages> packageID;
    public static volatile SingularAttribute<Packagerating, String> description;
    public static volatile SingularAttribute<Packagerating, User> userID;
    public static volatile SingularAttribute<Packagerating, Integer> ratingStar;
    public static volatile SingularAttribute<Packagerating, Integer> packageRatingID;

}