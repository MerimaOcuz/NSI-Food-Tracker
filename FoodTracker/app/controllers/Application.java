package controllers;

import views.html.*;
import static play.data.Form.*;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
	static Form<Login> loginForm = form(Login.class);
	static Form<Register> registerForm = form(Register.class);

	public Result index() {
		return ok(index.render("Food Tracker Application"));
    }
	
    public static Result login() {
    	return ok(login.render(loginForm));
    }
	
	public static Result register() {
    	String user = session("username");
		String role = session("role");
        return ok(
        	register.render(user, role, registerForm)
        	);
    }
    
    public static class Login {
        public String username;
        public String password;
    }
	
	public static class Register {
	    public String email;
	    public String name;
	    public String surname;
	    public String password;
	    public String phone;
	    public String address;
	}
	
    /*
    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        return ok();
    }
    */

}
