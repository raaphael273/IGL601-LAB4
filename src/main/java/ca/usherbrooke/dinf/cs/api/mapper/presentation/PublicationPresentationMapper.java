package ca.usherbrooke.dinf.cs.api.mapper.presentation;

import ca.usherbrooke.dinf.cs.api.model.request.PublicationCreationRequest;
import ca.usherbrooke.dinf.cs.api.model.response.PublicationResponse;
import ca.usherbrooke.dinf.cs.api.model.storage.Publication;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface PublicationPresentationMapper {
    Publication convert(final PublicationCreationRequest request);

    PublicationResponse convert(final Publication publication);

    Collection<PublicationResponse> convert(
            final Collection<Publication> publications);
}
