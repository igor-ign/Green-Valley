package br.com.gv.api.mapper;

import br.com.gv.api.controller.response.CityResponse;
import br.com.gv.api.domain.City;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CityMapperTest {

    @Test
    void toMap_toResponseDto_WithSuccess() {
        // Arrange
        UUID cityId = UUID.randomUUID();
        String cityName = "Test City";
        City city = new City(cityId, cityName);

        // Act
        CityResponse cityResponse = CityMapper.toResponse(city);

        // Assert
        assertEquals(cityId, cityResponse.getId());
        assertEquals(cityName, cityResponse.getName());
    }
}

