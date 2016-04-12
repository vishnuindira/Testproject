package com.lxisoft.chakra.services;
import com.lxisoft.chakra.hibernateutils.*;
import com.lxisoft.chakra.model.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RegisterService {
	
public boolean register(User user){
	 Session session = HibernateUtil.factory.openSession();
	 //if(isUserExists(user)) return false;	
	 org.hibernate.Transaction tx = null;
	 	
	 try {
		
		 tx = session.beginTransaction();
		 session.saveOrUpdate(user);		
		 tx.commit();
	 } catch (Exception e) {
		 if (tx != null) {
			 tx.rollback();
		 }
		 e.printStackTrace();
	 } finally {
		 session.close();
	 }	
	 return true;
}

public boolean isUserExists(User user){
	 Session session = HibernateUtil.factory.openSession();
	 boolean result = false;
	 Transaction tx = null;
	 try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from User where userId='"+user.getUserId()+"'");
		 User u = (User)query.uniqueResult();
		 tx.commit();
		 if(u!=null) result = true;
	 }catch(Exception ex){
		 if(tx!=null){
			 tx.rollback();
		 }
	 }finally{
		 session.close();
	 }
	 return result;
}
}