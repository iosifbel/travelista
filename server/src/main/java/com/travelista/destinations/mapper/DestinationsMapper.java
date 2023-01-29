package com.travelista.destinations.mapper;

import com.travelista.destinations.model.Destination;
import com.travelista.destinations.response.DestinationInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DestinationsMapper {

    //Needed for convertList method
    DestinationInfo convert(Destination destination);
    List<DestinationInfo> convertList(List<Destination> destinations);
}
