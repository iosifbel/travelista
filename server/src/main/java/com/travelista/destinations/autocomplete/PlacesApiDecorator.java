package com.travelista.destinations.autocomplete;

import com.google.maps.GeoApiContext;
import com.google.maps.PlaceAutocompleteRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PlacesApiDecorator {

    public AutocompleteRequest placeAutocomplete(GeoApiContext context,
                                                 String input,
                                                 PlaceAutocompleteRequest.SessionToken sessionToken) {
        AutocompleteRequest request = new AutocompleteRequest(context);
        request.input(input);
        request.sessionToken(sessionToken);
        return request;
    }
}
