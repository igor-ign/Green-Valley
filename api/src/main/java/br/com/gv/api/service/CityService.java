package br.com.gv.api.service;

import br.com.gv.api.controller.response.CityResponse;
import br.com.gv.api.mapper.CityMapper;
import br.com.gv.api.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<CityResponse> getCities() {
        return cityRepository.findAll().stream().map(CityMapper::toResponse).collect(Collectors.toList());
    }
}
