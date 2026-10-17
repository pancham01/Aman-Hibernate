package com.learning.hbn.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.hbn.configuration.HibernateConfiguration;
import com.learning.hbn.entity.Address;
import com.learning.hbn.entity.Employee;


public class Main {

	public static void main(String[] args) {
		
		Address add1 = new Address();
		add1.setCity("Lucknow");
		add1.setState("UP");

		Employee emp1 = new Employee();
		emp1.setName("Ashish");
		emp1.setGender("Male");
		emp1.setSalary(90000);
		emp1.setAddress(add1);
		
		
		Session session = HibernateConfiguration.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		
		session.persist(emp1);
		
		
		transaction.commit();
		
		
		
	}

}
