package com.travelista.destinations;

import java.util.ArrayList;
import java.util.List;

public class DummyDataDestinationService implements DestinationsService {

    @Override
    public List<Destination> getDestinations() {
        List<Destination> destinations = new ArrayList<>();

        destinations.add(Destination.builder()
                .name("Prague")
                .country("Czech Republic")
                .type("city")
                .build());

        destinations.add(Destination.builder()
                .name("Bucharest")
                .country("Romania")
                .type("city")
                .build());

        destinations.add(Destination.builder()
                .name("Italy")
                .country("Italy")
                .type("country")
                .build());

        return destinations;
    }
}
