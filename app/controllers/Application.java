package controllers;

import play.*;
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
}