package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;
import models.*;
import static play.data.Form.*;
import play.data.Form;
import play.mvc.Controller;

public class Application extends Controller {
	static Form<Register> registerForm = form(Register.class);

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
	        User.insert(name, surname, email, password, phone, address, "User");
	        return redirect(
	            routes.Application.index()
	        );
	    }
    }
    
  
    
    public static class Login {
    	
        public String email;
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

}
