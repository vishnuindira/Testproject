package com.lxisoft.chakra.services;
import com.lxisoft.chakra.hibernateutils.*;
import com.lxisoft.chakra.model.*;


import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class LoginService {

		public boolean forgotauthenticateuser(String userId){
			User user = getUserByUserId(userId); 
			if(user!=null && user.getUserId().equals(userId)){
				return true;
				
			}else{
				return false;
			}
		}
	    public boolean authenticateUser(String userId, String password) {
	        User user = getUserByUserId(userId);          
	        if(user!=null && user.getUserId().equals(userId) && user.getPassword().equals(password)){
	            return true;
	        }else{ 
	            return false;
	        }
	    }

	    public User getUserByUserId(String userId) {
	        Session session = HibernateUtil.factory.openSession();
	        Transaction tx = null;
	        User user = null;
	        try {
	            tx = session.getTransaction();
	            tx.begin();
	            Query query = session.createQuery("from User where userId='"+userId+"'");
	            user = (User)query.uniqueResult();
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return user;
	    }
	    
	    public String getUserPassword(String userId) {
	        Session session = HibernateUtil.factory.openSession();
	        Transaction tx = null;
	        String password = null;
	        try {
	            tx = session.getTransaction();
	            tx.begin();
	            Query query = session.createQuery("select password from User where userId='"+userId+"'");
	            password = (String)query.uniqueResult();
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        System.out.println(password);
	        return password;
	    }
	    
	    
	    
	    public List<User> getListOfUsers(){
	        List<User> list = new ArrayList<User>();
	        Session session = HibernateUtil.factory.openSession();
	        Transaction tx = null;        
	        try {
	            tx = session.getTransaction();
	            tx.begin();
	            list = session.createQuery("from User").list();                        
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return list;
	    }
	}

