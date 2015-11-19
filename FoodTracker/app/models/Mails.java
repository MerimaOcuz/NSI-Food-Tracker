package models;

import play.libs.mailer.Email;
import play.libs.mailer.MailerClient;

import play.mvc.Result;

  public class Mails {

  public void sendEmail(MailerClient mailerClient, String userEmail) {
    Email email = new Email();
    email.setSubject("Simple email");
    email.setFrom("posiljaoc@gmail.com");
    email.addTo(userEmail);
    email.setBodyText("A text message");
   
    //String id = 
    mailerClient.send(email);
    //return ok("Email " + id + " sent!");
  }

}