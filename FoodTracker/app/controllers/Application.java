package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;
import models.*;
import static play.data.Form.*;
import play.data.Form;
import play.mvc.Controller;
import java.util.Date;

public class Application extends Controller {
	static Form<Register> registerForm = form(Register.class);
	static Form<Login> loginForm = form(Login.class);
    public Result index() {
        return ok(index.render("Food Tracker Application"));
    }
    
    public Result login() {
         return ok(login.render(loginForm));
    }
    
    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session().clear();
            session("email", loginForm.get().email);
            return redirect(
                routes.Application.index()
            );
        }
    }
    
    
    /*public Result authenticate() {
        
    	Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
    	String email = loginForm.get().email;
    	String password = loginForm.get().password;
    	session().clear();
    	if ()
    	
    	{
    	
    	return redirect(
	            routes.Application.index()
	        );
    	}
       return ok();
    }*/
    
    public static Result register() {
    	String user = session("username");
		String role = session("role");
        return ok(
        	register.render(user, role, registerForm)
        	);
    }
	
	public static Result addUser() {        
	    if (registerForm.hasErrors()) {
	    	String user = session("email");
			String role = session("role");
	        return badRequest(register.render(user, role, registerForm));
	    } else {
		    Form<Register> registerForm = form(Register.class).bindFromRequest();
	        String name = registerForm.get().name;
	        String surname = registerForm.get().surname;
	        String email = registerForm.get().email;
	        String password = registerForm.get().password;
	        String phone = registerForm.get().phone;
	        String address = registerForm.get().address;
			Date birth_date = registerForm.get().birth_date;
			
	        User.insert(name, surname, birth_date, email, password, phone, address, "User");
	        return redirect(
	            routes.Application.index()
	        );
	    }
    }
    
  
    
    public static class Login {
    	
        public String email;
        public String password;
        public String validate() {
        	if (User.check(email,password) == null) {
        		return "Invalid user or password";
        	}
        	return null;
        }
    }
     
  
    
    public static class Register {
	    public String email;
	    public String name;
	    public String surname;
	    public String password;
	    public String phone;
	    public String address;
		public Date birth_date;
	}

}
