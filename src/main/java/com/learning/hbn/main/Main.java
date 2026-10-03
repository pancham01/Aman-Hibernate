package com.learning.hbn.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learning.hbn.configuration.HibernateConfiguration;
import com.learning.hbn.entity.Employee;

public class Main {

	public static void main(String[] args) {

		Employee emp1 = new Employee("Yogesh Chawla", "male", 98000);

		Session session = HibernateConfiguration.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		session.persist(emp1);

		transaction.commit();

	}

}
