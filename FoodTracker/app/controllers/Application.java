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
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

import play.db.ebean.*;
import com.avaje.ebean.*;
import javax.persistence.*;

import javax.inject.Inject;
import play.libs.mailer.MailerClient;
import play.mvc.Http.*;
import play.mvc.Http.MultipartFormData.*;
import java.lang.Object;
import java.io.File;
import java.util.List;


public class Application extends Controller {

    @Inject static MailerClient mailerClient;

	static Form<Register> registerForm = form(Register.class);
	static Form<Login> loginForm = form(Login.class);
	static Form<InputUserExercise> inputUserExerciseForm = form(InputUserExercise.class);
	static Form<Food> foodForm =form(Food.class);
	
    public Result index() {
        return ok(index.render("Food Tracker Application"));
    }
    
    public Result login() {
         return ok(login.render(loginForm));
    }
    
    public Result profil() {
        String user = session("email");
        String name = null;
        String surname = null;
        Date birth_date =null;
        String password =null;
        if(user != null)
        {
            name= User.getUser(user).getName();
            surname =User.getUser(user).getSurname();
            birth_date =User.getUser(user).getBirthDate();
            password =User.getUser(user).getPassword();
        }
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String birth = df.format(birth_date);
        return ok(profil.render(user, name, surname, birth, password));
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
        String user = session("email");
        String name = null;
        if(user != null)
        {
            name= User.getUser(user).getName();
        }
        List<UserExercise> userExercises = Ebean.find(UserExercise.class).where().eq("user_id", user).findList(); // trazi se lista aktivnosti samo onog korisnika koji je trenutno logiran
    	return ok(dashboard.render(user, name, userExercises));
    }

    public static Result lastAccActivity() {
        String user = session("email");
        String name = null;
        List<UserExercise> userExercises = Ebean.find(UserExercise.class).where().eq("user_id", user).findList(); // trazi se lista aktivnosti samo onog korisnika koji je trenutno logiran
        if(user != null)
        {
            name= User.getUser(user).getName();
        }
        return ok(lastAccActivity.render(name, userExercises));
    }

    public static Result insertFood() {        
        if (foodForm.hasErrors()) {
            String user = session("email");
            String role = session("role");
            return badRequest(food.render(user));
        } else {
            Form<FoodInput> inputFoodForm = form(FoodInput.class).bindFromRequest();
            String name = inputFoodForm.get().name;
            int calories = inputFoodForm.get().calories;
            MultipartFormData body = request().body().asMultipartFormData();
            String myUploadPath="C:/Users/Public/Pictures/Pictures";
            FilePart picture = body.getFile("image");
                File file = picture.getFile();
                String fileName = picture.getFilename();
                file.renameTo(new File(myUploadPath, fileName));
                Food.insert(name, calories, fileName);
            //i jos image prihvatiti
            
            
            //Food.insert(name, calories);

            return redirect(
                routes.Application.food()
            );
        }
    }
    

    public static Result food(){
        String user = session("email");
        String name = null;
        if(user != null)
        {
            name= User.getUser(user).getName();
        }
        return ok(food.render(name));
    }
    
    public static Result userExercise() { 	
    	String uid = session("email");	// email koji je unesen u formu i proslijedjen u sesiju metodom authenticate
    	String name=null;
        if(uid != null)
        {
            name= User.getUser(uid).getName();
        }
        List<UserExercise> userExercises = Ebean.find(UserExercise.class).where().eq("user_id", uid ).findList(); // trazi se lista aktivnosti samo onog korisnika koji je trenutno logiran
    	List<Exercise> exercises = Ebean.find(Exercise.class).findList(); // lista svih aktivnosti koje korisnik moze izabrati prilikom unosa
    	return ok(userExercise.render(name, userExercises, exercises, inputUserExerciseForm));
    }
    
    public static Result addUserExercise() {
    	String uid = session("email");	// email koji je unesen u formu i proslijedjen u sesiju metodom authenticate
    	String name=null;
        if(uid != null)
        {
            name= User.getUser(uid).getName();
        }
    	List<UserExercise> userExercises = Ebean.find(UserExercise.class).where().eq("user_id", uid ).findList(); // trazi se lista aktivnosti samo onog korisnika koji je trenutno logiran
    	List<Exercise> exercises = Ebean.find(Exercise.class).findList(); // lista svih aktivnosti koje korisnik moze izabrati prilikom unosa
    	if (inputUserExerciseForm.hasErrors()) {
    		String title = session("title");	// u sesiju se unosi i naziv vjezbe zbog dalje provjere
    		return badRequest(userExercise.render(name, userExercises, exercises, inputUserExerciseForm));
    	} else {
    		Form<InputUserExercise> inputUserExerciseForm = form(InputUserExercise.class).bindFromRequest();
    		String title = inputUserExerciseForm.get().title;
    		Date timestamp = inputUserExerciseForm.get().timestamp;
    		int duration_min = inputUserExerciseForm.get().duration_min;
    		
    		Exercise vjezba = Ebean.find(Exercise.class).where().eq("title", title).findUnique();	// unese se naziv vjezbe koja se radila pa se nadje vjezba u bazi sa tim nazivom
    		    		    		
    		if (vjezba !=null) UserExercise.insert(uid, vjezba.getId(), title, timestamp, duration_min);	// unos vjezbe u tabelu
    		return redirect(routes.Application.userExercise());
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

            Mails mails = new Mails();
            //mails.sendEmail(mailerClient, email); //zakomentarisano zato sto trenutno baca null exception

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


    public static class FoodInput {
        public String name;
        public int calories;
        public String photo;
        //i jos fotka
    }
    
    public static class InputUserExercise {
    	
    	public String title;
    	public Date timestamp;
    	public int duration_min;
    }
    
}
