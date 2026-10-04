package com.learning.hbn.configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateConfiguration {

	public static SessionFactory getSessionFactory() {
		Properties properties = new Properties();
		properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://localhost:3306/myjdbc");
		properties.put(Environment.JAKARTA_JDBC_USER, "root");
		properties.put(Environment.JAKARTA_JDBC_PASSWORD, "root");
		properties.put(Environment.HBM2DDL_AUTO, "update");
		properties.put("hibernate.show_sql", "true");

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(properties).build();
		Metadata metadata = new MetadataSources(ssr).addAnnotatedClass(com.learning.hbn.entity.Employee.class).getMetadataBuilder().build();
		return metadata.buildSessionFactory();
	}

}
