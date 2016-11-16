package play.db;

import javax.inject.Inject;

import play.mvc.Controller;

public class JavaApplicationDatabase extends Controller {
	   private Database db;

	    @Inject
	    public JavaApplicationDatabase(Database db) {
	        this.db = db;
	    }
}
