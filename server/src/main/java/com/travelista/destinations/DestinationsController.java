package com.travelista.destinations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class DestinationsController {

    @Autowired
    @Qualifier("dummyDataDestinationService")
    private DestinationsService service;

    @RequestMapping("/destinations")
    public List<Destination> getDestinations() {
        return service.getDestinations();
    }
}
