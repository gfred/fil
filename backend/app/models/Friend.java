package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity 
public class Friend extends Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Constraints.Required
  public Long userId;
  
  @Constraints.Required
  public Long friendId;
  
  public static Finder<Long,Friend> find = new Finder<Long,Friend>(
    Long.class, Friend.class
  ); 
}