package br.com.gv.api.service;

import br.com.gv.api.controller.request.HouseEditRequest;
import br.com.gv.api.controller.request.HouseFilterRequest;
import br.com.gv.api.controller.request.HouseRequest;
import br.com.gv.api.controller.response.HouseResponse;
import br.com.gv.api.domain.House;
import br.com.gv.api.domain.Neighborhood;
import br.com.gv.api.mapper.HouseMapper;
import br.com.gv.api.repository.HouseRepository;
import br.com.gv.api.repository.NeighborhoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static br.com.gv.api.mapper.HouseMapper.toEntity;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@Service
public class HouseService {

    private static final String INVALID_HOUSE_ID = "The house you're trying to edit does not exist.";
    private static final String INVALID_NEIGHBORHOOD_ID = "This neighborhood ID does not exist.";

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private NeighborhoodRepository neighborhoodRepository;

    public HttpStatus addNewHouse(HouseRequest request) {
        Neighborhood neighborhood = neighborhoodRepository.findNeighborhoodById(request.getNeighborhoodId());

        House entity = toEntity(request, neighborhood);
        houseRepository.save(entity);

        if (isNull(neighborhood)) {
            throw new ResponseStatusException(BAD_REQUEST, INVALID_NEIGHBORHOOD_ID);
        }

        return OK;
    }

    public HttpStatus edit(HouseEditRequest request) {
        House house = houseRepository.findHouseById(request.getHouseId());
        Neighborhood newNeighborhood;

        if (nonNull(request.getNeighborhoodId())) {
            newNeighborhood = neighborhoodRepository.findNeighborhoodById(request.getNeighborhoodId());
            house.setNeighborhood(newNeighborhood);
        }

        if (isNull(house)) {
            throw new ResponseStatusException(BAD_REQUEST,  INVALID_HOUSE_ID);
        }

        if (nonNull(request.getStreet())) {
            house.setStreet(request.getStreet());
        }

        if (nonNull(request.getNegociationType())) {
            house.setHouseType(request.getNegociationType());
        }

        if (nonNull(request.getBuilding())) {
            house.setBuilding(request.getBuilding());
        }

        if (request.getPrice() != 0) {
            house.setPrice(request.getPrice());
        }

        if (request.getBedrooms() != 0) {
            house.setBedrooms(request.getBedrooms());
        }

        if (request.getBathrooms() != 0) {
            house.setBathrooms(request.getBathrooms());
        }

        if (request.getHouseSize() != 0) {
            house.setHouseSize(request.getHouseSize());
        }

        if (nonNull(request.getDescription())) {
            house.setDescription(request.getDescription());
        }

        houseRepository.save(house);

        return OK;
    }

    public Page<HouseResponse> getHouses(HouseFilterRequest filters, Pageable pageable) {
        Specification<House> spec = Specification.where(null);

        if (filters.getId() != null) {
            spec = spec.and((root, query, builder) -> builder.equal(root.get("id"), filters.getId()));
        }

        if (filters.getNeighborhoodId() != null) {
            spec = spec.and((root, query, builder) -> builder.equal(root.get("neighborhood").get("id"), filters.getNeighborhoodId()));
        }

        if (filters.getMinPrice() != 0) {
            spec = spec.and((root, query, builder) -> builder.greaterThanOrEqualTo(root.get("price"), filters.getMinPrice()));
        }

        if (filters.getMaxPrice() != 0) {
            spec = spec.and((root, query, builder) -> builder.lessThanOrEqualTo(root.get("price"), filters.getMaxPrice()));
        }

        if (filters.getType() != null) {
            spec = spec.and((root, query, builder) -> builder.equal(root.get("houseType"), filters.getType()));
        }

        Page<House> houses = houseRepository.findAll(spec, pageable);

        return houses.map(HouseMapper::toResponse);
    }
}
