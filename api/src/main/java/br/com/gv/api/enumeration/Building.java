package br.com.gv.api.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

import static java.util.Objects.isNull;

@Getter
@AllArgsConstructor
public enum Building {
    HOUSE("HOUSE"),
    APARTMENT("APARTMENT");

    private String value;

    public static String getBuildingType(String type) {
        if (isNull(type)) {
            return HOUSE.getValue();
        }

        return String.valueOf(Arrays.stream(Building.values())
                .filter(value -> value.getValue().equalsIgnoreCase(type))
                .findFirst()
                .orElse(HOUSE));
    }
}
