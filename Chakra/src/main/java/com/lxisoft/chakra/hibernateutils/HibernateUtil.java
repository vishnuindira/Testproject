package com.lxisoft.chakra.hibernateutils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static SessionFactory factory;
	
	public HibernateUtil(){
		
		try{
					factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    
	}
}
   