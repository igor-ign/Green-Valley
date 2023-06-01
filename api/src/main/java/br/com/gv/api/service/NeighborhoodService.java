package br.com.gv.api.service;

import br.com.gv.api.controller.response.NeighborhoodResponse;
import br.com.gv.api.mapper.NeighborhoodMapper;
import br.com.gv.api.repository.NeighborhoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NeighborhoodService {

    @Autowired
    private NeighborhoodRepository neighborhoodRepository;

    public List<NeighborhoodResponse> getAllNeighborhoodsByCityId(UUID cityId) {
        return neighborhoodRepository.findAllByCityId(cityId).stream().map(NeighborhoodMapper::toResponse).collect(Collectors.toList());
    }
}
