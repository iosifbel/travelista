package com.travelista.configuration;

import com.google.maps.GeoApiContext;
import com.google.maps.PlaceAutocompleteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.function.Supplier;

@Configuration
@RequiredArgsConstructor
public class TravelistaConfiguration {

    private final TravelistaProperties travelistaProperties;

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public GeoApiContext geoApiContext() {
        return new GeoApiContext.Builder()
                .apiKey(travelistaProperties.getGoogleApiKey())
                .queryRateLimit(1)
                .build();
    }

    @Bean
    public Supplier<PlaceAutocompleteRequest.SessionToken> session() {
        return PlaceAutocompleteRequest.SessionToken::new;
    }
}
