package com.travelista.destinations.autocomplete;

import com.google.maps.GeoApiContext;
import com.google.maps.PlaceAutocompleteRequest;
import com.google.maps.internal.StringJoin;
import com.travelista.destinations.model.DestinationType;

import java.util.List;

public class AutocompleteRequest extends PlaceAutocompleteRequest {
    protected AutocompleteRequest(GeoApiContext context) {
        super(context);
    }

    public PlaceAutocompleteRequest types(List<DestinationType> types) {
        String[] typesArray = types.stream().map(DestinationType::getName).toArray(String[]::new);
        return this.param("types", StringJoin.join('|', typesArray));
    }

}
