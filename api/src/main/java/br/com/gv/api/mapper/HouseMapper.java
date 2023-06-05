package br.com.gv.api.mapper;

import br.com.gv.api.controller.request.HouseRequest;
import br.com.gv.api.domain.House;

import java.util.UUID;

public class HouseMapper {

    public static House toEntity(HouseRequest request) {
        return House.builder()
                .id(UUID.randomUUID())
                .neighborhoodId(request.getNeighborhoodId())
                .street(request.getStreet())
                .houseType(request.getNegociationType())
                .buildingType(request.getBuildingType())
                .price(request.getPrice())
                .bedrooms(request.getBedrooms())
                .bathrooms(request.getBathrooms())
                .houseSize(request.getHouseSize())
                .description(request.getDescription())
                .build();
    }
}
