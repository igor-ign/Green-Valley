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
@Entity(name = "user_info")
@Table(name = "user_info", schema = "public")
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class UserInfo {

    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String userPassword;
}
