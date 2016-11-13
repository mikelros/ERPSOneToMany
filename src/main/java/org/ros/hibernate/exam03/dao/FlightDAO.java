package org.ros.hibernate.exam03.dao;

import org.ros.hibernate.exam03.models.Flight;

public interface FlightDAO {
	public Flight selectById(Long id);

	public void insert(Flight flight);
}
