package br.com.gv.api.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HouseEditRequest {

    private UUID neighborhoodId;

    private String street;

    private String negociationType;

    private String building;

    private int price;

    private int bedrooms;

    private int bathrooms;

    private int houseSize;

    private String description;
}
