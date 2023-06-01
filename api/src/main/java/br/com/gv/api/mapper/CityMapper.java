package br.com.gv.api.mapper;

import br.com.gv.api.controller.response.CityResponse;
import br.com.gv.api.domain.City;

public class CityMapper {
    public static CityResponse toResponse(City entity) {
        return CityResponse.builder()
                .id(entity.getId())
                .name(entity.getCityName())
                .build();
    }
}
