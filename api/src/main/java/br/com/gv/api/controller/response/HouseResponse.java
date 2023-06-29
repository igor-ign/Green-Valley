package br.com.gv.api.controller.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HouseResponse {

    private UUID id;

    private String location;

    private String type;

    private int price;
}
