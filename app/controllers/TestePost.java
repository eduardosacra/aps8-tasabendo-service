package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class TestePost extends Controller {
	 
	public Result testePost(){
		return ok("Funcionou");
	}
}
