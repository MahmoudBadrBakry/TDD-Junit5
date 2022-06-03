package com.mbadr.tddjunit5.airport;

import java.util.*;

public abstract class Flight {

	private String id;
	protected Set<Passenger> passengersSet;
	private long distance;

	public long getDistance() {
		return distance;
	}

	public void setDistance(long distance) {
		this.distance = distance;
	}

	public Flight(String id) {
		this.id = id;
		passengersSet = new HashSet<>();
	}

	public String getId() {
		return id;
	}

	public Set<Passenger> getPassengersSet() {
		return Collections.unmodifiableSet(passengersSet);
	}



	public abstract boolean addPassenger(Passenger passenger);

	public abstract boolean removePassenger(Passenger passenger);

}
