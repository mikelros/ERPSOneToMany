package org.ros.hibernate.exam03;

import java.util.Date;
import java.util.List;

import org.ros.hibernate.exam03.dao.FlightDAO;
import org.ros.hibernate.exam03.impl.HibernateFlightDAO;
import org.ros.hibernate.exam03.models.Flight;
import org.ros.hibernate.exam03.models.Passenger;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Flight flight = new Flight();
		flight.setDate(new Date(97, 10, 22));
		flight.setName("First Flight");

		Passenger passenger1 = new Passenger();
		passenger1.setName("A");
		passenger1.setPhone("12346789");
		
		Passenger passenger2 = new Passenger();
		passenger2.setName("B");
		passenger2.setPhone("98765431");
		
		Passenger passenger3 = new Passenger();
		passenger3.setName("C");
		passenger3.setPhone("666666666");
		
		Passenger passenger4 = new Passenger();
		passenger4.setName("D");
		passenger4.setPhone("159357486");
		
		flight.addPassenger(passenger1);
		flight.addPassenger(passenger2);
		flight.addPassenger(passenger3);
		flight.addPassenger(passenger4);

		FlightDAO aircraftDAO = new HibernateFlightDAO();
		aircraftDAO.insert(flight);

		Flight flightToShow = aircraftDAO.selectById(1L);
		System.out.println("Id: " + flightToShow.getId());
		System.out.println("	Name: " + flightToShow.getName());
		System.out.println("	Date: " + flightToShow.getDate().toString());
		System.out.println("	Passengers: ");
		List<Passenger> passengers = flightToShow.getPassengers();
		
		for (Passenger passenger: passengers) {
			System.out.println("		-" + passenger.toString());
		}

	}
}
