package br.com.gv.api.service;

import br.com.gv.api.controller.request.HouseRequest;
import br.com.gv.api.domain.House;
import br.com.gv.api.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static br.com.gv.api.mapper.HouseMapper.toEntity;
import static org.springframework.http.HttpStatus.OK;

@Service
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;

    public HttpStatus addNewHouse(HouseRequest request) {
        House entity = toEntity(request);
        houseRepository.save(entity);

        return OK;
    }
}
