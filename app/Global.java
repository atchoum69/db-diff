import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Construct;
import org.yaml.snakeyaml.constructor.Constructor;

import models.Database;
import play.*;

public class Global extends GlobalSettings {

	@Override
	public void onStart(Application app) {
		// Check if the database is empty
		if(Database.find.findRowCount() == 0) {
			Logger.info("Chargement des donnees initial dans la base de donnees.");
			
			// insertion manuelle via le fichier initial-data.yml
			Yaml yaml = new Yaml();
			try {
				ArrayList<Database> databases = (ArrayList<Database>) yaml.load(new FileInputStream(new File("app/initial-data.yml")));
				for (Database database : databases) {
					database.save();
				}
			} catch (FileNotFoundException e) {
				Logger.error(e.getMessage());
			}
			
		} else {
			Logger.info("Base de donnees deja chargee.");
		}
	}  

}