package br.com.gv.api.service;

import br.com.gv.api.controller.response.CityResponse;
import br.com.gv.api.domain.City;
import br.com.gv.api.repository.CityRepository;
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

class CityServiceTest {

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityService cityService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void getCities_withSuccess() {
        // Arrange
        City city1 = new City(UUID.randomUUID(), "City 1");
        City city2 = new City(UUID.randomUUID(), "City 2");
        List<City> cities = Arrays.asList(city1, city2);

        // Act
        when(cityRepository.findAll()).thenReturn(cities);

        List<CityResponse> cityResponses = cityService.getCities();
        CityResponse response1 = cityResponses.get(0);
        CityResponse response2 = cityResponses.get(1);

        // Assert
        assertEquals(2, cityResponses.size());
        assertEquals(city1.getId(), response1.getId());
        assertEquals(city1.getCityName(), response1.getName());
        assertEquals(city2.getId(), response2.getId());
        assertEquals(city2.getCityName(), response2.getName());

        verify(cityRepository).findAll();
    }
}
