package com.learning.hbn.main;

import java.util.ArrayList;
import java.util.List;

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
		
		Address add2 = new Address();
		add2.setCity("Noida");
		add2.setState("UP");
		
		Address add3 = new Address();
		add3.setCity("GZB");
		add3.setState("UP");
		
		List<Address> listOfAdd = new ArrayList<>();
		listOfAdd.add(add1);
		listOfAdd.add(add2);
		listOfAdd.add(add3);
		
		
		Employee emp1 = new Employee();
		emp1.setName("Ashish");
		emp1.setGender("Male");
		emp1.setSalary(90000);
		emp1.setAddress(listOfAdd);
		
		
		add1.setEmployee(emp1);
		add2.setEmployee(emp1);
		add3.setEmployee(emp1);
		
		Session session = HibernateConfiguration.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
//		session.persist(emp1);
//		session.persist(add1);
//		session.persist(add2);
//		session.persist(add3);
//		transaction.commit();
		
		
		Employee employee = session.find(Employee.class, 1);
		System.out.println(employee);
		
		System.err.println("=======================");
		
		Address address1 = session.find(Address.class, 1);
		Address address2 = session.find(Address.class, 2);
		Address address3 = session.find(Address.class, 3);
		
		System.out.println(address1);
		System.out.println(address1.getEmployee());
		System.out.println(address2);
		System.out.println(address2.getEmployee());
		System.out.println(address3);
		System.out.println(address3.getEmployee());
		
	}

}
