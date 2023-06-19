package br.com.gv.api.service;

import br.com.gv.api.controller.response.CityResponse;
import br.com.gv.api.domain.City;
import br.com.gv.api.repository.CityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
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
        List<City> cityList = new ArrayList<>();
        cityList.add(createCity(UUID.randomUUID(), "City 1"));
        cityList.add(createCity(UUID.randomUUID(), "City 2"));

        Pageable pageable = Pageable.unpaged();
        Page<City> cityPage = new PageImpl<>(cityList, pageable, cityList.size());
        when(cityRepository.findAll(pageable)).thenReturn(cityPage);

        // Act
        Page<CityResponse> responsePage = cityService.getCities(pageable);

        // Assert
        assertEquals(cityList.size(), responsePage.getTotalElements());
        assertEquals(cityList.size(), responsePage.getContent().size());
        assertEquals(cityList.get(0).getId(), responsePage.getContent().get(0).getId());
        assertEquals(cityList.get(0).getCityName(), responsePage.getContent().get(0).getName());
        assertEquals(cityList.get(1).getId(), responsePage.getContent().get(1).getId());
        assertEquals(cityList.get(1).getCityName(), responsePage.getContent().get(1).getName());
    }

    private City createCity(UUID id, String cityName) {
        return City.builder()
                .id(id)
                .cityName(cityName)
                .build();
    }
}
