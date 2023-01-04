package com.travelista.destinations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DestinationsConfiguration {

    @Bean
    public DestinationsService dummyDataDestinationService() {
        return new DummyDataDestinationService();
    }

}
