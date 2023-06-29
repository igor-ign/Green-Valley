package br.com.gv.api.mapper;

import br.com.gv.api.controller.request.HouseRequest;
import br.com.gv.api.controller.response.HouseResponse;
import br.com.gv.api.domain.House;
import br.com.gv.api.domain.Neighborhood;

import java.util.UUID;

import static br.com.gv.api.enumeration.Building.getBuildingType;
import static br.com.gv.api.enumeration.NegociationType.getNegociationType;

public class HouseMapper {

    public static House toEntity(HouseRequest request, Neighborhood neighborhood) {
        return House.builder()
                .id(UUID.randomUUID())
                .neighborhood(neighborhood)
                .street(request.getStreet())
                .houseType(getNegociationType(request.getNegociationType()))
                .building(getBuildingType(request.getBuilding()))
                .price(request.getPrice())
                .bedrooms(request.getBedrooms())
                .bathrooms(request.getBathrooms())
                .houseSize(request.getHouseSize())
                .description(request.getDescription())
                .build();
    }

    public static HouseResponse toResponse(House entity) {
        return HouseResponse.builder()
                .id(entity.getId())
                .type(entity.getHouseType())
                .location(entity.getNeighborhood().getNeighborhoodName() + "," + entity.getStreet())
                .price(entity.getPrice())
                .build();
    }
}
