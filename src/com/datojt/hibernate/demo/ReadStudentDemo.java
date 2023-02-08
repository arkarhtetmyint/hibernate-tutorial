package com.datojt.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.datojt.hibernate.demo.entiry.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {


		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		try {
			
			// create session
			Session session = factory.getCurrentSession();
			
			Student tempStu = new Student("Ar1","Kar1","arkar1@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(tempStu);
			
			// commit transaction
			session.getTransaction().commit();
			
			// find out the student's id: primary key
			// find out the student's id: primary key
			System.out.println("Saved student. Generated id: " + tempStu.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + tempStu.getId());
			
			Student myStudent = session.get(Student.class, tempStu.getId());
			
			System.out.println("Get complete: " + myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
			
					
		}
		finally {
			factory.close();
		}
		
		
	}

}
