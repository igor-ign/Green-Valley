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
public class HouseFilterRequest {

    private UUID id;
    private UUID neighborhoodId;
    private int minPrice;
    private int maxPrice;
    private String type;
}
