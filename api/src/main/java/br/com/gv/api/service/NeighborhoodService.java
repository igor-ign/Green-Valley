package br.com.gv.api.service;

import br.com.gv.api.controller.response.NeighborhoodResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NeighborhoodService {
    public List<NeighborhoodResponse> getAllNeighborhoodsByCityId(UUID cityId) {
        return null;
    }
}
