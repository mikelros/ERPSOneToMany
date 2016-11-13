package org.ros.hibernate.exam03.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Date date;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idflight")
	private List<Passenger> passengers;

	public Flight() {
		passengers = new ArrayList<Passenger>();
	}

	public Flight(Long id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		passengers = new ArrayList<Passenger>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public void addPassenger(Passenger passenger) {
		this.passengers.add(passenger);
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", name=" + name + ", date=" + date + "]";
	}

}
