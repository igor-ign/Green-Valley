package br.com.gv.api.repository;

import br.com.gv.api.domain.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HouseRepository extends JpaRepository<House, UUID> {

}
