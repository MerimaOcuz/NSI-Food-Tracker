package controllers;

<<<<<<< HEAD
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
=======
import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Food Tracker Application"));
    }
    
    public Result login() {
        return ok(login.render(Form.form(Login.class)));
    }
    
    public Result authenticate() {
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
        return ok();
    }
    
    public Result register() {
    	return ok(register.render(Form.form(Register.class)));
    }
    
    public Result registruj() {
    	Form<Register> registerForm = Form.form(Register.class).bindFromRequest();
    	return ok();
    }
    
    public static class Login {
    	
        public String email;
        public String password;

    }
    
    public static class Register {
    	
    	public String ime;
    	public String prezime;
    	public String spol;
    	public String email;
    	public String password;
    	
    	
    }
>>>>>>> origin/master

}
