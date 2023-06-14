package br.com.gv.api.mapper;

import br.com.gv.api.controller.request.HouseRequest;
import br.com.gv.api.domain.House;
import br.com.gv.api.enumeration.Building;
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
        String houseType = NegociationType.SELL.getValue();
        String building = Building.HOUSE.getValue();
        int price = 100000;
        int bedrooms = 3;
        int bathrooms = 2;
        int houseSize = 150;
        String description = "Test Description";

        HouseRequest houseRequest = new HouseRequest();
        houseRequest.setNeighborhoodId(neighborhoodId);
        houseRequest.setStreet(street);
        houseRequest.setNegociationType(houseType);
        houseRequest.setBuilding(building);
        houseRequest.setPrice(price);
        houseRequest.setBedrooms(bedrooms);
        houseRequest.setBathrooms(bathrooms);
        houseRequest.setHouseSize(houseSize);
        houseRequest.setDescription(description);

        // Act
        House house = HouseMapper.toEntity(houseRequest, );

        // Assert
        assertEquals(neighborhoodId, house.getNeighborhood().getId());
        assertEquals(street, house.getStreet());
        assertEquals(houseType, house.getHouseType());
        assertEquals(building, house.getBuilding());
        assertEquals(price, house.getPrice());
        assertEquals(bedrooms, house.getBedrooms());
        assertEquals(bathrooms, house.getBathrooms());
        assertEquals(houseSize, house.getHouseSize());
        assertEquals(description, house.getDescription());
    }
}
