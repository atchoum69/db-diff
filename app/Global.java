import java.util.List;
import java.util.Map;

import models.Database;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.libs.Yaml;

import com.avaje.ebean.Ebean;

public class Global extends GlobalSettings {

	@Override
	public void onStart(Application app) {
		// Verifie si la base est vide
	  if(Ebean.find(Database.class).findRowCount() == 0) {
			Logger.info("Chargement des donnees initial dans la base de donnees.");
			
			// chargement des donneees
			Map<String,List<Object>> all = (Map<String,List<Object>>) Yaml.load("initial-data.yml");
			
      // Insertion des donnees dans la base
      Ebean.save(all.get("databases"));
			
		} else {
			Logger.info("Base de donnees deja chargee.");
		}
	}  

}