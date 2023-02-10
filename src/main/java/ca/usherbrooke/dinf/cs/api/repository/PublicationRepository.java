package ca.usherbrooke.dinf.cs.api.repository;

import ca.usherbrooke.dinf.cs.api.model.storage.Publication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PublicationRepository
        extends CrudRepository<Publication, UUID> {
}
