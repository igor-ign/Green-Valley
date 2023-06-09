package br.com.gv.api.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

import static java.util.Objects.isNull;

@Getter
@AllArgsConstructor
public enum NegociationType {
    SELL("SELL"),
    RENT("RENT");

    private String value;

    public static String getNegociationType(String type) {
        if (isNull(type)) {
            return SELL.getValue();
        }

        return String.valueOf(Arrays.stream(NegociationType.values())
                .filter(value -> value.getValue().equalsIgnoreCase(type))
                .findFirst()
                .orElse(SELL));
    }
}
