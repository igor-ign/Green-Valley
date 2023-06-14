package br.com.gv.api.service;

import br.com.gv.api.controller.request.HouseRequest;
import br.com.gv.api.domain.House;
import br.com.gv.api.domain.Neighborhood;
import br.com.gv.api.repository.HouseRepository;
import br.com.gv.api.repository.NeighborhoodRepository;
import br.com.gv.api.validator.HouseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.gv.api.mapper.HouseMapper.toEntity;
import static org.springframework.http.HttpStatus.OK;

@Service
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private HouseValidator houseValidator;

    @Autowired
    private NeighborhoodRepository neighborhoodRepository;

    public HttpStatus addNewHouse(HouseRequest request) {
        Neighborhood neighborhood = neighborhoodRepository.findNeighborhoodById(request.getNeighborhoodId());
        houseValidator.validate(request.getNeighborhoodId());

        House entity = toEntity(request, neighborhood);
        houseRepository.save(entity);

        return OK;
    }
}
