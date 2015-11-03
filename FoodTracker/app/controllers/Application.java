package controllers;

import views.html.*;

import play.api.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    public Result index() {
		return ok(index.render("Food Tracker Application"));
    }
    
    /*
    public static Result login() {
    	return ok(login.render(form(Login.class)));
    }
    
    public static class Login {

        public String email;
        public String password;

    }
    
    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        return ok();
    }
    */

}
