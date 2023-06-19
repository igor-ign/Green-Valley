package br.com.gv.api.service;

import br.com.gv.api.controller.request.HouseRequest;
import br.com.gv.api.domain.House;
import br.com.gv.api.domain.Neighborhood;
import br.com.gv.api.repository.HouseRepository;
import br.com.gv.api.repository.NeighborhoodRepository;
import br.com.gv.api.validator.HouseValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

class HouseServiceTest {

    @Mock
    private HouseRepository houseRepository;

    @Mock
    private HouseValidator houseValidator;

    @Mock
    private NeighborhoodRepository neighborhoodRepository;

    @InjectMocks
    private HouseService houseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void toAddNewHouse_withSuccess() {
        // Arrange
        Neighborhood neighborhood = new Neighborhood();
        neighborhood.setId(UUID.randomUUID());
        neighborhood.setCityId(UUID.randomUUID());
        neighborhood.setNeighborhoodName("NG 1");
        when(neighborhoodRepository.findNeighborhoodById(any(UUID.class))).thenReturn(neighborhood);

        // Act
        HouseRequest request = new HouseRequest(neighborhood.getId(), "Street 1", "SELL", "HOUSE", 100000, 3, 2, 150, "Description");
        HttpStatus status = houseService.addNewHouse(request);

        // Assert
        assertEquals(OK, status);
    }

    @Test
    void toAddNewHouse_withInvalidNeighborhoodId_withoutSuccess() {
        when(neighborhoodRepository.findNeighborhoodById(any(UUID.class))).thenReturn(null);

        // Call the service method
        HouseRequest request = new HouseRequest(UUID.randomUUID(), "Street 1", "SELL", "HOUSE", 100000, 3, 2, 150, "Description");

        // Assert that a ResponseStatusException is thrown
        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> houseService.addNewHouse(request));

        // Assert the status code of the exception
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
        assertEquals("This neighborhood ID does not exist.", exception.getReason());
    }
}
