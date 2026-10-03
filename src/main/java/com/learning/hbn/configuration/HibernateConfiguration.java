package com.learning.hbn.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateConfiguration {

	public static SessionFactory getSessionFactory() {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfgg.xml").build();

		Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

		return metadata.buildSessionFactory();

	}

}
