package br.com.gv.api.controller;

import br.com.gv.api.controller.response.CityResponse;
import br.com.gv.api.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public Page<CityResponse> getAllCities(Pageable pageable) {
        return cityService.getCities(pageable);
    }
}
