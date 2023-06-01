package br.com.gv.api.controller;

import br.com.gv.api.controller.response.NeighborhoodResponse;
import br.com.gv.api.service.NeighborhoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/neighborhoods")
public class NeighborhoodController {

    @Autowired
    private NeighborhoodService neighborhoodService;

    @GetMapping("/{cityId}")
    public List<NeighborhoodResponse> getAllNeighborhoodsByCityId(@PathVariable UUID cityId) {
        return neighborhoodService.getAllNeighborhoodsByCityId(cityId);
    }
}
