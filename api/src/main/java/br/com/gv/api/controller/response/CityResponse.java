package br.com.gv.api.controller.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityResponse {
    private UUID id;
    private String name;
}
