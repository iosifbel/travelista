package com.travelista.destinations.configuration;

import com.google.maps.GeoApiContext;
import com.google.maps.PlaceAutocompleteRequest;
import com.travelista.configuration.TravelistaProperties;
import com.travelista.destinations.service.DefaultDestinationService;
import com.travelista.destinations.mapper.DestinationsMapper;
import com.travelista.destinations.DestinationsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

@Configuration
public class DestinationsConfiguration {

    @Bean
    public DestinationsService defaultDestinationService(GeoApiContext geoApiContext,
                                                         Supplier<PlaceAutocompleteRequest.SessionToken> sessionSupplier,
                                                         TravelistaProperties properties,
                                                         DestinationsMapper destinationsMapper) {
        return new DefaultDestinationService(geoApiContext, sessionSupplier, properties, destinationsMapper);
    }

}
