package com.enduser.enduser.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LocationService {

    private List<String> locationData = new ArrayList<>(); // In-memory storage (for demonstration)

    public void storeLocation(String location) {
        locationData.add(location);
    }

    public List<String> getAllLocations() {
        return locationData;
    }

    public String getLocationById(int id) {
        if (id >= 0 && id < locationData.size()) {
            return locationData.get(id);
        } else {
            throw new NoSuchElementException("Location not found with id: " + id);
        }
    }

    public String getLatestLocation(){
        if(locationData.isEmpty()){
            throw new NoSuchElementException("No locations found");
        }
        return locationData.get(locationData.size()-1);
    }
}