package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Database extends Model {

    /**
	 * long serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    public Long id;

	@Required
	public String name;

	@Required
	public String user;

	@Required
	public String password;

	@Required
	public String url;

	public Database(Long id, String name, String user, String password, String url) {
		this.id = id;
		this.name = name;
		this.user = user;
		this.password = password;
		this.url = url;
	}

	public String toString() {
		return this.name;
	}
	
	/**
     * Generic query helper for entity Database with id Long
     */
    public static Finder<Long, Database> find = new Finder<Long, Database>(Long.class, Database.class);
    
    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Database d: Database.find.orderBy("name").findList()) {
            options.put(d.id.toString(), d.name);
        }
        return options;
    }
}
