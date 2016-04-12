package com.lxisoft.chakra.services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;

public class MailService 
{ 
    public static  void send(String to, String pass2)
    { 
    	final String user= "vishnuindira123@gmail.com";
    	final String pass = "DELL@444";
     //create an instance of Properties Class   
     Properties props = new Properties();
     
     /* Specifies the IP address of your default mail server
     	   for e.g if you are using gmail server as an email sever
           you will pass smtp.gmail.com as value of mail.smtp host. 
           As shown here in the code. 
           Change accordingly, if your email id is not a gmail id
        */
     props.put("mail.smtp.host", "smtp.gmail.com");
     //below mentioned mail.smtp.port is optional
     props.put("mail.smtp.port", "587");		
     props.put("mail.smtp.auth", "true");
     props.put("mail.smtp.starttls.enable", "true");
     
     /* Pass Properties object(props) and Authenticator object   
           for authentication to Session instance 
        */

    Session session = Session.getInstance(props,new javax.mail.Authenticator()
    {
  	  protected PasswordAuthentication getPasswordAuthentication() 
  	  {
  	 	 return new PasswordAuthentication(user,pass);
  	  }
   });
    
   try
   {
 
 	/* Create an instance of MimeMessage, 
 	      it accept MIME types and headers 
 	   */
  System.out.println("*********start  ********");
    MimeMessage message = new MimeMessage(session);
       message.setFrom(new InternetAddress(user));
       message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
       message.setSubject("PASSWORD RESENT");
       message.setText("hai your password is  "+pass2+" "+ " http://localhost:8080/Chakra/login.jsp ");

       /* Transport class is used to deliver the message to the recipients */
       
       Transport.send(message);
  System.out.println("SENTTTT!!!!!!");
 
    }
    catch(Exception e)
    {
    	 e.printStackTrace();
    }
  }  
}