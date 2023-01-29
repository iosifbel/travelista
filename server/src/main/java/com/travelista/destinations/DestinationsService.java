package com.travelista.destinations;

import com.travelista.destinations.response.DestinationInfo;

import java.util.List;

public interface DestinationsService {

    List<DestinationInfo> autocompleteDestinations(String inputText);
}
