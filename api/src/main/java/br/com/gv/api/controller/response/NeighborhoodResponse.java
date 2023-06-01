package br.com.gv.api.controller.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NeighborhoodResponse {
    private UUID id;
    private String name;
}
