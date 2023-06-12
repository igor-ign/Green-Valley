package br.com.gv.api.repository;

import br.com.gv.api.domain.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NeighborhoodRepository extends JpaRepository<Neighborhood, UUID> {
    List<Neighborhood> findAllByCityId(UUID cityId);
    Neighborhood findByNeighborhoodId(UUID uuid);
}
