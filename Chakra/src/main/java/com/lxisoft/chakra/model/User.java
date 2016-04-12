package com.lxisoft.chakra.model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;

import com.lxisoft.chakra.hibernateutils.HibernateUtil;

public class User implements Serializable {
	    
	    
	    private Long id;
	    private String firstName;
	    private String email;
	    private String userId;
	    private String password;

	    public User() {
	    }

	    
	    public User(String firstName, String email, String userId, String password) {
	        this.firstName = firstName;
	        this.email = email;
	        this.userId = userId;
	        this.password = password;
	    }


	    public Long getId() {
	        return id;
	    }

	     public void setId(Long id) {
	        this.id = id;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	   

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getUserId() {
	        return userId;
	    }

	    public void setUserId(String userId) {
	        this.userId = userId;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    } 
}