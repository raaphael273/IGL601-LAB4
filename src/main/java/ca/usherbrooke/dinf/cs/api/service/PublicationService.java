package ca.usherbrooke.dinf.cs.api.service;

import ca.usherbrooke.dinf.cs.api.model.storage.Publication;
import ca.usherbrooke.dinf.cs.api.repository.PublicationRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PublicationService {
    private final UUID ANONYMOUS_USER_ID = new UUID(0L, 0L);

    private final PublicationRepository publicationRepository;

    public Collection<Publication> findAll() {
        return (Collection<Publication>) publicationRepository.findAll();
    }

    public Publication create(final Publication publication) {
        // Set a random id to this publication
        publication.setId(UUID.randomUUID());

        // Set the author to anonymous until an authentication mechanism
        // provides the authenticated user identifier
        if (Objects.isNull(publication.getCreatedBy()))
            publication.setCreatedBy(ANONYMOUS_USER_ID);

        // Marks the publication creation date
        publication.setCreatedOn(Instant.now());

        if (StringUtils.isBlank(publication.getTitle()))
            throw new IllegalArgumentException("The title cannot be blank");

        if (StringUtils.isBlank(publication.getContent()))
            throw new IllegalArgumentException("The publication's content cannot be blank");

        return publicationRepository.save(publication);
    }
}
