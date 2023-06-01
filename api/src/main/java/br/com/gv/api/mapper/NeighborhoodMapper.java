package br.com.gv.api.mapper;

import br.com.gv.api.controller.response.NeighborhoodResponse;
import br.com.gv.api.domain.Neighborhood;

public class NeighborhoodMapper {
    public static NeighborhoodResponse toResponse(Neighborhood entity) {
        return NeighborhoodResponse.builder()
                .id(entity.getId())
                .name(entity.getNeighborhoodName())
                .build();
    }
}
