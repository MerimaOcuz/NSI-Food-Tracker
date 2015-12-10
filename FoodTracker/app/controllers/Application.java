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
	static Form<Food> foodForm = form(Food.class);
	static Form<Exercise> exerciseForm = form(Exercise.class);
	
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
        String gender=null;
        String current_weight=null;
        String height=null;
        
        if(user != null)
        {
            name= User.getUser(user).getName();
            surname =User.getUser(user).getSurname();
            birth_date =User.getUser(user).getBirthDate();
            password =User.getUser(user).getPassword();
            gender =User.getUser(user).getGender();
            current_weight=User.getUser(user).getCurrent_weight();
            height=User.getUser(user).getHeight();
            
            
        }
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String birth = df.format(birth_date);
        return ok(profil.render(user, name, surname, birth, password, gender, current_weight, height));
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
            //String myUploadPath="C:/Users/Public/Pictures/Pictures/";
            String myUploadPath = Play.application().configuration().getString("myUploadPath");
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
    
    // metoda za unos nove vjezbe u bazu
    public static Result insertExercise() {
    	if (exerciseForm.hasErrors()) {
            String user = session("email");
            String role = session("role");
            return badRequest(exercise.render(user));
        } else {
            Form<ExerciseInput> inputExerciseForm = form(ExerciseInput.class).bindFromRequest();
            String title = inputExerciseForm.get().title;
            String description = inputExerciseForm.get().description;
            int calories_per_minute = inputExerciseForm.get().calories_per_minute;
            
            Exercise.insert(title, description, calories_per_minute);
            
            return redirect(
                routes.Application.exercise()
            );
        }
    }
    
    // metoda za renderanje exercise viewa koji sluzi za unos nove vjezbe u bazu
    public static Result exercise() {
    	String user = session("email");
        String name = null;
        if(user != null)
        {
            name= User.getUser(user).getName();
        }
    	return ok(exercise.render(name));
    }
    
    // meotda za renderanje viewa za prikaz procjene kalorija
    public static Result calorieConsumption() {
    	String user = session("email");
    	String name = null;
    	String gender = null;
    	String current_weight = null;
    	String height = null;
    	String desired_weight = null;
    	if(user != null) 
    	{
    		name = User.getUser(user).getName();
    		gender = User.getUser(user).getGender();
    		current_weight = User.getUser(user).getCurrent_weight();
    		height = User.getUser(user).getHeight();
    		
    		Double visina = Double.parseDouble(height);
    		Double ztezina = 0.0;
    		if(gender=="Male") {
    			ztezina = 52 + (1.9*((visina - 5*30.48)/2.54));
    			User.getUser(user).setDesired_weight(ztezina.toString(), user);
    			desired_weight = ztezina.toString();
    		}
    		else {
    			ztezina = 49 + (1.7*((visina - 5*30.48)/2.54));
    			User.getUser(user).setDesired_weight(ztezina.toString(), user);
    			desired_weight = ztezina.toString();
    		}
    	}
    	return ok(calorieConsumption.render(user, desired_weight));
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
			String gender=registerForm.get().gender;
			String current_weight=registerForm.get().current_weight;
			String height = registerForm.get().height;
			
	        User.insert(name, surname, birth_date, email, password, phone, address,gender,current_weight, height, "User");

            Mails mails = new Mails();
            //mails.sendEmail(mailerClient, email); //zakomentarisano zato sto trenutno baca null exception
            flash("success", "You've been registered!");
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
		public String gender;
		public String current_weight;
		public String height;
	}


    public static class FoodInput {
        public String name;
        public int calories;
        public String photo;
        //i jos fotka
    }
    
    // klasa za kreiranje forme za unos nove vjezbe u bazu - InsertExercise()
    public static class ExerciseInput {
    	public String title;
    	public String description;
    	public int calories_per_minute;
    }
    
    
    public static class InputUserExercise {
    	
    	public String title;
    	public Date timestamp;
    	public int duration_min;
    }
    
}
