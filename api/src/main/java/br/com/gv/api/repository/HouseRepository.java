package br.com.gv.api.repository;

import br.com.gv.api.domain.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface HouseRepository extends JpaRepository<House, UUID> {

    House findHouseById(UUID uuid);

    @Query(value = "SELECT id, neighborhood_id, price, house_type FROM house AS h WHERE (h.id = COALESCE(?1, h.id)) " +
            "AND (h.neighborhood_id = COALESCE(?2, h.neighborhood_id)) " +
            "AND (h.price >= COALESCE(?3, h.price)) " +
            "AND (h.price <= COALESCE(?4, h.price)) " +
            "AND (h.house_type = COALESCE(?5, h.house_type))")
    Page<House> findHousesWithFilters(UUID id, UUID neighborhoodId, int minPrice, int maxPrice, String houseType, Pageable pageable);
}
