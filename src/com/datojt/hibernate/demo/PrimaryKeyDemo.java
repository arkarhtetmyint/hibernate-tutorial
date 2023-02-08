package com.datojt.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.datojt.hibernate.demo.entiry.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// changing the startding index
			// ALTER TABLE hb_student_tracker.student auto_increment=3000
			
			//truncate hb_student_tracker.student
			
			Student tempStu = new Student("tempStu","tempStu","tempStu@gmail.com");
			Student tempStu1 = new Student("stu1","stu1","stu1@gmail.com");
			Student tempStu2 = new Student("stu2","stu2","stu2@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(tempStu);
			session.save(tempStu1);
			session.save(tempStu2);
			
			// commit transaction
			session.getTransaction().commit();
					
		}
		finally {
			factory.close();
		}
			

	}

}
