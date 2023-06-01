package br.com.gv.api.domain;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "neighborhood")
@Table(name = "neighborhood", schema = "public")
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Neighborhood {

    @Id
    private UUID id;

    private UUID cityId;

    @Column(nullable = false)
    private String neighborhoodName;
}
