package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Analyse extends Model {

	/**
	 * long serialVersionUID.
	 */
	private static final long serialVersionUID = 2L;
	
	@Id
    public Long id;
	
	@ManyToOne
    public Database databaseRef;
	
	@ManyToOne
    public Database databaseAComparer;
	
	public Analyse() {
	}
	
	public Analyse(Database databaseRef, Database databaseAComparer) {
		this.databaseRef = databaseRef;
		this.databaseAComparer = databaseAComparer;
	}
	
	public Analyse(Long id, Database databaseRef, Database databaseAComparer) {
		this.id = id;
		this.databaseRef = databaseRef;
		this.databaseAComparer = databaseAComparer;
	}

	public String toString() {
		return this.databaseRef.name + " - " + this.databaseAComparer.name;
	}
	
	/**
     * Generic query helper for entity Database with id Long
     */
    public static Finder<Long, Analyse> find = new Finder<Long, Analyse>(Long.class, Analyse.class);
}
