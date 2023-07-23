package entity;

import entity.Packages;
import entity.Places;
import entity.SubPlaces;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-24T09:55:44")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, String> image;
    public static volatile CollectionAttribute<Category, Packages> packagesCollection;
    public static volatile CollectionAttribute<Category, SubPlaces> subPlacesCollection;
    public static volatile SingularAttribute<Category, String> description;
    public static volatile CollectionAttribute<Category, Places> placesCollection;
    public static volatile SingularAttribute<Category, String> categoryName;
    public static volatile SingularAttribute<Category, Integer> categoryID;

}