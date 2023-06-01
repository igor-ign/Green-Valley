package br.com.gv.api.service;

import br.com.gv.api.controller.response.NeighborhoodResponse;
import br.com.gv.api.domain.Neighborhood;
import br.com.gv.api.repository.NeighborhoodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class NeighborhoodServiceTest {

    @Mock
    private NeighborhoodRepository neighborhoodRepository;

    @InjectMocks
    private NeighborhoodService neighborhoodService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void toGetNeighborhoods_withCityId_withSuccess() {
        // Arrange
        UUID cityId = UUID.randomUUID();

        Neighborhood neighborhood1 = new Neighborhood(UUID.randomUUID(), cityId, "Neighborhood 1");
        Neighborhood neighborhood2 = new Neighborhood(UUID.randomUUID(), cityId, "Neighborhood 2");
        List<Neighborhood> neighborhoods = Arrays.asList(neighborhood1, neighborhood2);

        // Act
        when(neighborhoodRepository.findAllByCityId(cityId)).thenReturn(neighborhoods);

        List<NeighborhoodResponse> neighborhoodResponses = neighborhoodService.getAllNeighborhoodsByCityId(cityId);
        NeighborhoodResponse response1 = neighborhoodResponses.get(0);
        NeighborhoodResponse response2 = neighborhoodResponses.get(1);

        // Assert
        assertEquals(2, neighborhoodResponses.size());
        assertEquals(neighborhood1.getId(), response1.getId());
        assertEquals(neighborhood1.getNeighborhoodName(), response1.getName());
        assertEquals(neighborhood2.getId(), response2.getId());
        assertEquals(neighborhood2.getNeighborhoodName(), response2.getName());

        verify(neighborhoodRepository).findAllByCityId(cityId);
    }
}
