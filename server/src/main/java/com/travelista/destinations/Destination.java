package com.travelista.destinations;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Destination {

    String name;
    String country;
    String type;
}
