package br.com.gv.api.controller.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HouseResponse {

    private String location;

    private String type;

    private int price;
}
