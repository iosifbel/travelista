package com.travelista.destinations.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Destination {

    String id;
    String name;
    String country;
    String type;
}
