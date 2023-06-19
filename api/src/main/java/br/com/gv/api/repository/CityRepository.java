package br.com.gv.api.repository;

import br.com.gv.api.domain.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CityRepository extends JpaRepository<City, UUID> {
    Page<City> findAll(Pageable pageable);
}
