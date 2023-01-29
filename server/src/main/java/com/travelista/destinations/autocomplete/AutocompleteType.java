package com.travelista.destinations.autocomplete;

import com.google.maps.internal.StringJoin;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AutocompleteType implements StringJoin.UrlValue {
    COUNTRY("country"),
    LOCALITY("locality");

    private final String placeType;

    @Override
    public String toUrlValue() {
        return this.placeType;
    }
}
