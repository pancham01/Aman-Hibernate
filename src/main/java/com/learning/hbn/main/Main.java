package com.learning.hbn.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.learning.hbn.configuration.HibernateConfiguration;
import com.learning.hbn.entity.Employee;

public class Main {

	public static void main(String[] args) {

		Employee emp1 = new Employee("Yogesh Chawla", "male", 98000);
		Session session = HibernateConfiguration.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		
		Query<Employee> query = session.createQuery("from Employee",Employee.class);
		
		List<Employee> list = query.list();
		
		
		for(Employee e : list) {
			System.out.println(e);
			
			if(e.getName().equals("Neha Gupta")) {
				System.err.println("Yes We found her In our DB");
			}
		}
		
		
		System.err.println(">>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<");
		
//		Get Record with Pagination
		
		Query<Employee> query2 = session.createQuery("from Employee",Employee.class);
		
		query2.setFirstResult(5);
		query2.setMaxResults(10);
		
		List<Employee> list2 = query2.list();
		
		
		for(Employee e : list2) {
			System.out.println(e);
		}
		
		
		
		
		
		
	}

}
