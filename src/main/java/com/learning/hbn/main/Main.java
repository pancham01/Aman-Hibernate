package com.learning.hbn.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.hbn.entity.Employee;

public class Main {

	public static void main(String[] args) {

		Employee emp1 = new Employee(1, "Kunal Chawla", "male", 98000);

//		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//		
//		SessionFactory sessionFactory = cfg.buildSessionFactory();
//		
//		Session session = sessionFactory.openSession();

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfgg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		session.persist(emp1);

		transaction.commit();

	}

}
