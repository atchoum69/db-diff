package controllers;

import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import com.avaje.ebean.OrderBy;

import play.*;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

import models.*;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render(Database.find.order("name asc").findList()));
	}

	public static Result lancerAnalyse(Long id, Long id2) {
		Database ref = Database.find.byId(id);
		Logger.debug("Database de reference : " + ref.name);
		Database toCompare = Database.find.byId(id2);
		Logger.debug("Database a comparer : " + toCompare.name);
		Analyse analyse = new Analyse(ref, toCompare);
		analyse.save();
		return ok("ok");
	}
	
	public static Result getListeAnalyses(String sidx, String sord) {
		// gestion du tri
		OrderBy<Analyse> order = new OrderBy<Analyse>();
		if ("asc".equals(sord)) {
			order.asc(sidx);
		} else {
			order.desc(sidx);
		}
		List<Analyse> liste = Analyse.find.setOrder(order).findList();
		
		// Converti la liste en JSON
		JsonNode noeudAna = Json.toJson(liste);
		// TODO : voir comment ajouter le noeud root (analyses)
		String jsonString = "{  \"analyses\": " + noeudAna.toString() + " }";  
		JsonNode noeud = Json.parse(jsonString);
		
		return ok(noeud);
	}
}