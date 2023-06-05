package br.com.gv.api.domain;

import br.com.gv.api.enumeration.BuildingType;
import br.com.gv.api.enumeration.NegociationType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "house")
@Table(name = "house", schema = "public")
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class House {

    @Id
    private UUID id;

    @Column(nullable = false)
    private UUID neighborhoodId;

    private String street;

    @Column(nullable = false)
    private NegociationType houseType;

    @Column(nullable = false)
    private BuildingType buildingType;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int bedrooms;

    @Column(nullable = false)
    private int bathrooms;

    @Column(nullable = false)
    private int houseSize;

    private String description;

}
