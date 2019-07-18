package com.hibernatedemo;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) {
		
		SessionFactory factory =
				new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
//			//Select * from city = from city
//			List<String> countryCodes =
//					session.createQuery("select c.countryCode from City c GROUP BY c.countryCode").getResultList();
//			
//			for(String countryCode : countryCodes)
//			{
//				System.out.println(countryCode);
//			}
			//INSERT
//			City city = new City();
//			city.setName("Düzce 10");
//			city.setCountryCode("TUR");
//			city.setDistrict("Karadeniz");
//			city.setPopulation(100002);
//			
//			session.save(city);
			
			//UPDATE
//			City city = session.get(City.class, 172);
//			city.setPopulation(501230102);
//			session.save(city);
//			
			City city = session.get(City.class,172);
			session.delete(city);
			session.getTransaction().commit();
//			System.out.println("VT UPDATE!");
		}
		
		finally
		{
				factory.close();
		}
		
	}

}
