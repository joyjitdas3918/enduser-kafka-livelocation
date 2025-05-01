package com.enduser.enduser.controller;


import com.enduser.enduser.service.LocationConsumerService;
import com.enduser.enduser.service.StatusConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EndUserController {

    @Autowired
    private LocationConsumerService locationConsumerService;

    @Autowired
    private StatusConsumerService statusConsumerService;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/location")
    public ResponseEntity<String> getLatestLocation(@RequestParam String deliveryBoyId) {
        String location = locationConsumerService.getLatestLocation(deliveryBoyId);
        return ResponseEntity.ok(location);
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/locations")
    public ResponseEntity<List<String>> getLocations(@RequestParam String deliveryBoyId) {
        List<String> location = locationConsumerService.getAllLocations(deliveryBoyId);
        return ResponseEntity.ok(location);
    }


    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/status")
    public ResponseEntity<String> getStatus(@RequestParam String deliveryBoyId) {
        String status = statusConsumerService.getLatestStatus(deliveryBoyId);
        return ResponseEntity.ok(status);
    }
}