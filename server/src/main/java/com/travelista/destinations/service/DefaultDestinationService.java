package com.travelista.destinations.service;

import com.google.maps.GeoApiContext;
import com.google.maps.PlaceAutocompleteRequest;
import com.google.maps.model.AutocompletePrediction;
import com.travelista.configuration.TravelistaProperties;
import com.travelista.destinations.DestinationsService;
import com.travelista.destinations.autocomplete.PlacesApiDecorator;
import com.travelista.destinations.mapper.DestinationsMapper;
import com.travelista.destinations.model.Destination;
import com.travelista.destinations.response.DestinationInfo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class DefaultDestinationService implements DestinationsService {

    private final GeoApiContext geoApiContext;
    private final Supplier<PlaceAutocompleteRequest.SessionToken> sessionSupplier;
    private final TravelistaProperties properties;
    private final DestinationsMapper mapper;

    @Override
    @SneakyThrows
    public List<DestinationInfo> autocompleteDestinations(String inputText) {
        var results = PlacesApiDecorator.placeAutocomplete(geoApiContext, inputText, sessionSupplier.get())
                                        .types(properties.getDestinationsCategories())
                                        .await();
        List<Destination> destinations = createDestinations(results);
        // TODO filter destinations by type
        return mapper.convertList(destinations);
    }

    private List<Destination> createDestinations(AutocompletePrediction[] results) {
        return Arrays.stream(results)
                .map(this::createDestination)
                .collect(Collectors.toList());
    }

    private Destination createDestination(AutocompletePrediction prediction) {
        var terms = prediction.terms;
        return Destination.builder()
                .id(prediction.placeId)
                .type(prediction.types[0])
                .name(terms[0].value)
                .country(terms[terms.length - 1].value)
                .build();
    }
}
