package com.mbadr.tddjunit5.database;

import com.mbadr.tddjunit5.airport.Flight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private Map<String, String> registeredUsers;
    private List<List<String>> queriedData;

    public Database() {
        registeredUsers = new HashMap<>();
        queriedData = new ArrayList<>();
    }

    public boolean login(Credentials credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();
        return registeredUsers.containsKey(username) && registeredUsers.get(username).equals(password);
    }

    public List<List<String>> queryFlightDatabase() {
        return queriedData;
    }

    public double averageDistance(List<Flight> flightList) {
        return flightList.stream()
                .mapToDouble(Flight::getDistance)
                .average()
                .getAsDouble();
    }

    public long minDistance(List<Flight> flightList) {
        return flightList.stream()
                .mapToLong(Flight::getDistance)
                .min()
                .getAsLong();
    }

    public long maxDistance(List<Flight> flightList) {
        return flightList.stream()
                .mapToLong(Flight::getDistance)
                .max()
                .getAsLong();
    }
}
