package org.ros.hibernate.exam03.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ros.hibernate.exam03.HibernateSession;
import org.ros.hibernate.exam03.dao.FlightDAO;
import org.ros.hibernate.exam03.models.Flight;

public class HibernateFlightDAO implements FlightDAO {
	public Flight selectById(Long id) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		Flight flight = (Flight) session.get(Flight.class, id);
		session.close();
		return flight;
	}

	public void insert(Flight flight) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.persist(flight);

		session.getTransaction().commit();
		session.close();
	}
}
