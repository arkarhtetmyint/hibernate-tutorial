package com.datojt.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.datojt.hibernate.demo.entiry.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {


		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			Student tempStu = new Student("Ar","Kar","arkar@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(tempStu);
			
			// commit transaction
			session.getTransaction().commit();
					
		}
		finally {
			factory.close();
		}
		
		
	}

}
