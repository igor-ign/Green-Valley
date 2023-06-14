package br.com.gv.api.validator;

import br.com.gv.api.domain.Neighborhood;
import br.com.gv.api.repository.NeighborhoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class HouseValidator {

    private static final String INVALID_NEIGHBORHOOD_ID = "This neighborhood ID does not exist.";

    @Autowired
    private NeighborhoodRepository neighborhoodRepository;

    public void validate(UUID neighborhoodId) {
        Neighborhood neighborhood = neighborhoodRepository.getReferenceById(neighborhoodId);

        if (isNull(neighborhood)) {
            throw new ResponseStatusException(BAD_REQUEST, INVALID_NEIGHBORHOOD_ID);
        }
    }
}
