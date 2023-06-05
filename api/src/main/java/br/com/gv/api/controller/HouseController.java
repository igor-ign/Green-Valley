package br.com.gv.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/houses")
public class HouseController {

    @PostMapping("/add")
    public HttpStatus addNewHouse(@RequestBody HouseRequest request) {
        return houseService.addNewHouse();
    }
}
