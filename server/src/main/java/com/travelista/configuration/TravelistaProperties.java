package com.travelista.configuration;

import com.travelista.destinations.model.DestinationType;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Configuration
public class TravelistaProperties {

    @Value("${api.google.googleApiKey}")
    private String googleApiKey;

    @Value("${destinations.categories}")
    private List<DestinationType> destinationsCategories;

}
