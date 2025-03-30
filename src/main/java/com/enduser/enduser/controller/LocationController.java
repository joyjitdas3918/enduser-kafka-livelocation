package com.enduser.enduser.controller;

import com.enduser.enduser.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/locations") // Base path for all location endpoints
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public ResponseEntity<List<String>> getAllLocations() {
        List<String> locations = locationService.getAllLocations();
        if (locations.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content if no locations
        }
        return ResponseEntity.ok(locations); // 200 OK with locations
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getLocationById(@PathVariable int id) {
        try {
            String location = locationService.getLocationById(id);
            return ResponseEntity.ok(location);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found if location not found
        }
    }

    @GetMapping("/latest")
    public ResponseEntity<String> getLatestLocation(){
        try{
            String latestLocation = locationService.getLatestLocation();
            return ResponseEntity.ok(latestLocation);
        }catch(NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }
}