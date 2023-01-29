package com.travelista.destinations.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DestinationType {

    COUNTRY("country"),
    LOCALITY("locality");

    private final String name;
}
