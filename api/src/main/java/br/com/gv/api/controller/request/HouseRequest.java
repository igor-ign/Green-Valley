package br.com.gv.api.controller.request;

import br.com.gv.api.enumeration.Building;
import br.com.gv.api.enumeration.NegociationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HouseRequest {

    @NotNull(message = "Please, inform the neighborhood of this house.")
    private UUID neighborhoodId;

    private String street;

    @NotNull(message = "Please, inform the negociation type of this house (SELL / RENT).")
    private String negociationType;

    @NotNull(message = "Please, inform the building type of this house (HOUSE / APARTMENT).")
    private String building;

    @NotNull(message = "Please, inform the price of this house.")
    private int price;

    @NotNull(message = "Please, inform the number of bedrooms of this house.")
    private int bedrooms;

    @NotNull(message = "Please, inform the number of bathrooms of this house.")
    private int bathrooms;

    @NotNull(message = "Please, inform the size of this house.")
    private int houseSize;

    private String description;
}
