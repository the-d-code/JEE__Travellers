package entity;

import entity.City;
import entity.Packages;
import entity.State;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-24T09:55:44")
@StaticMetamodel(Managehotel.class)
public class Managehotel_ { 

    public static volatile SingularAttribute<Managehotel, String> image3;
    public static volatile CollectionAttribute<Managehotel, Packages> packagesCollection;
    public static volatile SingularAttribute<Managehotel, Integer> costPerRoom;
    public static volatile SingularAttribute<Managehotel, State> stateID;
    public static volatile SingularAttribute<Managehotel, String> description;
    public static volatile SingularAttribute<Managehotel, Integer> hotelID;
    public static volatile SingularAttribute<Managehotel, City> cityID;
    public static volatile SingularAttribute<Managehotel, String> image1;
    public static volatile SingularAttribute<Managehotel, String> hotelName;
    public static volatile SingularAttribute<Managehotel, String> image2;

}