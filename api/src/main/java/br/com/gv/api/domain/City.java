package br.com.gv.api.domain;

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
@Entity(name = "city")
@Table(name = "city", schema = "public")
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class City {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String cityName;
}
