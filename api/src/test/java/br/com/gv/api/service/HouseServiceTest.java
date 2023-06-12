package br.com.gv.api.service;

import br.com.gv.api.controller.request.HouseRequest;
import br.com.gv.api.domain.House;
import br.com.gv.api.repository.HouseRepository;
import br.com.gv.api.validator.HouseValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class HouseServiceTest {

    @Mock
    private HouseRepository houseRepository;

    @Mock
    private HouseValidator houseValidator;

    @InjectMocks
    private HouseService houseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void toAddNewHouse_withSuccess() {
        // Arrange
        UUID neighborhoodId = UUID.randomUUID();
        HouseRequest houseRequest = new HouseRequest();
        houseRequest.setNeighborhoodId(neighborhoodId);

        doNothing().when(houseValidator).validate(neighborhoodId);

        // Act
        HttpStatus status = houseService.addNewHouse(houseRequest);

        verify(houseValidator, times(1)).validate(neighborhoodId);
        verify(houseRepository, times(1)).save(any(House.class));

        // Assert
        assertEquals(HttpStatus.OK, status);
    }

    @Test
    void toAddNewHouse_withInvalidNeighborhoodId_withoutSuccess() {
        // Arrange
        UUID invalidNeighborhoodId = UUID.randomUUID();
        HouseRequest houseRequest = new HouseRequest();
        houseRequest.setNeighborhoodId(invalidNeighborhoodId);

        doThrow(new ResponseStatusException(HttpStatus.BAD_REQUEST, "This neighborhood ID does not exist."))
                .when(houseValidator).validate(invalidNeighborhoodId);

        // Act
        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> houseService.addNewHouse(houseRequest));

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
        assertEquals("This neighborhood ID does not exist.", exception.getReason());

        verify(houseValidator, times(1)).validate(invalidNeighborhoodId);
        verify(houseRepository, never()).save(any(House.class));
    }
}
