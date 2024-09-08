/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author Dina
 */
public class Email {
    String to;

    String from;
    
    String host = "localhost";
 
    Properties properties = System.getProperties();
    
    Email(String to, String from){
    	
    	this.from = from;
    	
    	this.to = to;
    	
    	properties.setProperty("mail.smtp.host", host);
    	  
    }
    
    void sendEmail(String SubjectString, String MessageString)
    {
    	Session session = Session.getDefaultInstance(properties);
    	
    	try {
    	MimeMessage message = new MimeMessage(session);
    	
    	message.setFrom(new InternetAddress(from));
    	
    	message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    	
    	message.setSubject(SubjectString);
    	
    	message.setText(MessageString);
    	
    	Transport.send(message);
    	   	
    	}catch(MessagingException mex) {
    		mex.printStackTrace();
    	}
    }
    
}
