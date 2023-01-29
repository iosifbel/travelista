package com.travelista.destinations.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DestinationInfo {

    String name;
    String country;
    String type;
}
