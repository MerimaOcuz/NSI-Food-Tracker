package controllers;

import views.html.*;
import static play.data.Form.*;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
	static Form<Login> loginForm = form(Login.class);

	public Result index() {
		return ok(index.render("Food Tracker Application"));
    }
	
    public static Result login() {
    	return ok(login.render(loginForm));
    }
    
    public static class Login {

        public String username;
        public String password;

    }
    /*
    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        return ok();
    }
    */

}
