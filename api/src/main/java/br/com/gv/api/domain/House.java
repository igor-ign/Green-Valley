package br.com.gv.api.domain;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

import static javax.persistence.FetchType.LAZY;

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

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "neighborhood_id", referencedColumnName = "id")
    private Neighborhood neighborhood;

    private String street;

    @Column(nullable = false)
    private String houseType;

    @Column(nullable = false)
    private String building;

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
