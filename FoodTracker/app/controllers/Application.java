package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Food Tracker :)"));
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

}
