package entity;

import entity.Busdetails;
import entity.Managehotel;
import entity.State;
import entity.SubPlaces;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-24T09:55:44")
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile CollectionAttribute<City, Busdetails> busdetailsCollection1;
    public static volatile SingularAttribute<City, String> cityName;
    public static volatile SingularAttribute<City, State> stateID;
    public static volatile CollectionAttribute<City, Managehotel> managehotelCollection;
    public static volatile CollectionAttribute<City, SubPlaces> subPlacesCollection;
    public static volatile SingularAttribute<City, Integer> cityID;
    public static volatile CollectionAttribute<City, Busdetails> busdetailsCollection;

}