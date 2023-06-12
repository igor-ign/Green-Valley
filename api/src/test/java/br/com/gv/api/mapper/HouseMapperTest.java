package br.com.gv.api.mapper;

import br.com.gv.api.controller.request.HouseRequest;
import br.com.gv.api.domain.House;
import br.com.gv.api.enumeration.BuildingType;
import br.com.gv.api.enumeration.NegociationType;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HouseMapperTest {
    @Test
    void toMap_toEntity_withSuccess() {
        // Arrange
        UUID neighborhoodId = UUID.randomUUID();
        String street = "Test Street";
        NegociationType houseType = NegociationType.SELL;
        BuildingType buildingType = BuildingType.HOUSE;
        int price = 100000;
        int bedrooms = 3;
        int bathrooms = 2;
        int houseSize = 150;
        String description = "Test Description";

        HouseRequest houseRequest = new HouseRequest();
        houseRequest.setNeighborhoodId(neighborhoodId);
        houseRequest.setStreet(street);
        houseRequest.setNegociationType(houseType);
        houseRequest.setBuildingType(buildingType);
        houseRequest.setPrice(price);
        houseRequest.setBedrooms(bedrooms);
        houseRequest.setBathrooms(bathrooms);
        houseRequest.setHouseSize(houseSize);
        houseRequest.setDescription(description);

        // Act
        House house = HouseMapper.toEntity(houseRequest);

        // Assert
        assertEquals(neighborhoodId, house.getNeighborhoodId());
        assertEquals(street, house.getStreet());
        assertEquals(houseType, house.getHouseType());
        assertEquals(buildingType, house.getBuildingType());
        assertEquals(price, house.getPrice());
        assertEquals(bedrooms, house.getBedrooms());
        assertEquals(bathrooms, house.getBathrooms());
        assertEquals(houseSize, house.getHouseSize());
        assertEquals(description, house.getDescription());
    }
}
