package br.com.gv.api.mapper;

import br.com.gv.api.controller.response.NeighborhoodResponse;
import br.com.gv.api.domain.Neighborhood;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NeighborhoodMapperTest {

    @Test
    void toMap_toResponseDto_WithSuccess() {
        // Arrange
        UUID neighborhoodId = UUID.randomUUID();
        String neighborhoodName = "Test Neighborhood";
        Neighborhood neighborhood = new Neighborhood(neighborhoodId, UUID.randomUUID(), neighborhoodName);

        // Act
        NeighborhoodResponse neighborhoodResponse = NeighborhoodMapper.toResponse(neighborhood);

        // Assert
        assertEquals(neighborhoodId, neighborhoodResponse.getId());
        assertEquals(neighborhoodName, neighborhoodResponse.getName());
    }
}
