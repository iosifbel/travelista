package com.travelista.destinations;

import com.travelista.destinations.response.DestinationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/destinations")
public class DestinationsController {

    @Autowired
    @Qualifier("defaultDestinationService")
    private DestinationsService service;

    @GetMapping("/autocomplete")
    public List<DestinationInfo> autocompleteDestinations(@RequestParam String input) {
       return service.autocompleteDestinations(input);
    }
}
