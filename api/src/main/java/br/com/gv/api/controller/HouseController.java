package br.com.gv.api.controller;

import br.com.gv.api.controller.request.HouseRequest;
import br.com.gv.api.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/houses")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @PostMapping("/add")
    public HttpStatus addNewHouse(@Valid @RequestBody HouseRequest request) {
        return houseService.addNewHouse(request);
    }

    @PutMapping("/edit")
    public HttpStatus editHouse(@RequestBody HouseEditRequest request) {
        return houseService.edit(request);
    }

}
