package com.zoo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Tester {
	
	public static void main(String[] args) {
		
		SessionFactory factory= HibernateSessionFactory.getSessionFactory();
		Session session=factory.openSession();


	}
}
