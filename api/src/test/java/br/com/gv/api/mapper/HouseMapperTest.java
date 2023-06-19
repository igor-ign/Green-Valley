package br.com.gv.api.mapper;

import br.com.gv.api.controller.request.HouseRequest;
import br.com.gv.api.domain.House;
import br.com.gv.api.domain.Neighborhood;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HouseMapperTest {
    @InjectMocks
    private HouseMapper houseMapper;

    @Test
    void toMap_toEntity_withSuccess() {
        // Arrange
        Neighborhood neighborhood = new Neighborhood();
        neighborhood.setId(UUID.randomUUID());
        HouseRequest request = new HouseRequest();
        request.setNeighborhoodId(UUID.randomUUID());
        request.setStreet("Sample Street");
        request.setNegociationType("SELL");
        request.setBuilding("HOUSE");
        request.setPrice(100000);
        request.setBedrooms(3);
        request.setBathrooms(2);
        request.setHouseSize(150);
        request.setDescription("Sample description");

        // Act
        House house = houseMapper.toEntity(request, neighborhood);

        // Assert
        assertEquals(request.getStreet(), house.getStreet());
        assertEquals("SELL", house.getHouseType());
        assertEquals("HOUSE", house.getBuilding());
        assertEquals(request.getPrice(), house.getPrice());
        assertEquals(request.getBedrooms(), house.getBedrooms());
        assertEquals(request.getBathrooms(), house.getBathrooms());
        assertEquals(request.getHouseSize(), house.getHouseSize());
        assertEquals(request.getDescription(), house.getDescription());
        assertEquals(neighborhood, house.getNeighborhood());
    }
}
