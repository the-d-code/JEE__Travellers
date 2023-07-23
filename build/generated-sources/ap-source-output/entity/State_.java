package entity;

import entity.City;
import entity.Managehotel;
import entity.Packages;
import entity.Places;
import entity.SubPlaces;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-24T09:55:44")
@StaticMetamodel(State.class)
public class State_ { 

    public static volatile CollectionAttribute<State, Packages> packagesCollection;
    public static volatile SingularAttribute<State, String> stateName;
    public static volatile SingularAttribute<State, Integer> stateID;
    public static volatile CollectionAttribute<State, Managehotel> managehotelCollection;
    public static volatile CollectionAttribute<State, City> cityCollection;
    public static volatile CollectionAttribute<State, SubPlaces> subPlacesCollection;
    public static volatile CollectionAttribute<State, Places> placesCollection;

}