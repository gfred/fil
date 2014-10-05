package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity 
public class Message extends Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Formats.DateTime(pattern="dd/MM/yyyy HH:MM")
  public Date date = new Date();
  
  @Constraints.Required
  public String message;

  @Constraints.Required
  public Long fromUserId;
  
  @Constraints.Required
  public Long toUserId;
  
  public double latitude;
  public double longitude;
  
  public boolean seenByToUser = false;
  
  public boolean hasFromUserDeleted = false;
  public boolean hasToUserDeleted = false;
  
  public static Finder<Long,Message> find = new Finder<Long,Message>(
    Long.class, Message.class
  ); 
}