package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;
import models.*;
import static play.data.Form.*;
import play.data.Form;
import play.mvc.Controller;
import java.util.*;

import play.db.ebean.*;
import com.avaje.ebean.*;
import javax.persistence.*;

public class Application extends Controller {
	static Form<Register> registerForm = form(Register.class);
	static Form<Login> loginForm = form(Login.class);
	static Form<InputUserExercise> inputUserExerciseForm = form(InputUserExercise.class);
	
	
    public Result index() {
        return ok(index.render("Food Tracker Application"));
    }
    
    public Result login() {
         return ok(login.render(loginForm));
    }
    
    public Result profil() {
        return ok(profil.render());
   }
   
    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session().clear();
            session("email", loginForm.get().email);
            return redirect(
                routes.Application.dashboard()
            );
        }
    }
    
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
            routes.Application.login()
        );
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
    
    public static Result dashboard() {
    	return ok(dashboard.render());
    }
    
    public static Result userExercise() { 	
    	String uid = session("email");	// email koji je unesen u formu i proslijedjen u sesiju metodom authenticate
    	List<UserExercise> userExercises = Ebean.find(UserExercise.class).where().eq("user_id", uid ).findList(); // trazi se lista aktivnosti samo onog korisnika koji je trenutno logiran
    	List<Exercise> exercises = Ebean.find(Exercise.class).findList(); // lista svih aktivnosti koje korisnik moze izabrati prilikom unosa
    	return ok(userExercise.render(userExercises, exercises, inputUserExerciseForm));
    }
    
    public static Result addUserExercise() {
    	String uid = session("email");	// email koji je unesen u formu i proslijedjen u sesiju metodom authenticate
    	
    	List<UserExercise> userExercises = Ebean.find(UserExercise.class).where().eq("user_id", uid ).findList(); // trazi se lista aktivnosti samo onog korisnika koji je trenutno logiran
    	List<Exercise> exercises = Ebean.find(Exercise.class).findList(); // lista svih aktivnosti koje korisnik moze izabrati prilikom unosa
    	if (inputUserExerciseForm.hasErrors()) {
    		String title = session("title");	// u sesiju se unosi i naziv vjezbe zbog dalje provjere
    		return badRequest(userExercise.render(userExercises, exercises, inputUserExerciseForm));
    	} else {
    		Form<InputUserExercise> inputUserExerciseForm = form(InputUserExercise.class).bindFromRequest();
    		String title = inputUserExerciseForm.get().title;
    		Date timestamp = inputUserExerciseForm.get().timestamp;
    		int duration_min = inputUserExerciseForm.get().duration_min;
    		
    		Exercise vjezba = Ebean.find(Exercise.class).where().eq("title", title).findUnique();	// unese se naziv vjezbe koja se radila pa se nadje vjezba u bazi sa tim nazivom
    		    		    		
    		if (vjezba !=null) UserExercise.insert(uid, vjezba.getId(), title, timestamp, duration_min);	// unos vjezbe u tabelu
    		return redirect(routes.Application.dashboard());
    	}
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
	            routes.Application.login()
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
    
    public static class InputUserExercise {
    	
    	public String title;
    	public Date timestamp;
    	public int duration_min;
    }
    
}
