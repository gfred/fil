package models;

import java.util.*;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity 
public class User extends Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Formats.DateTime(pattern="dd/MM/yyyy HH:MM")
  public Date date = new Date();
  
  @Constraints.Required
  public String displayName;
  
  public String name;
  public String lastName;
  
  public String pushToken;
  
  public String facebookId;
  public String googlePlusId;
  public String twitterId;
  
  public String mobileNumber;
  public String mailOne;
  public String mailTwo;
  public String mailThree;
  
  public static Finder<Long,User> find = new Finder<Long,User>(
    Long.class, User.class
  ); 
}