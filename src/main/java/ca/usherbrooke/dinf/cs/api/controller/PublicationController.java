package ca.usherbrooke.dinf.cs.api.controller;

import ca.usherbrooke.dinf.cs.api.mapper.presentation.PublicationPresentationMapper;
import ca.usherbrooke.dinf.cs.api.model.request.PublicationCreationRequest;
import ca.usherbrooke.dinf.cs.api.model.response.PublicationResponse;
import ca.usherbrooke.dinf.cs.api.model.storage.Publication;
import ca.usherbrooke.dinf.cs.api.service.PublicationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/publications")
@AllArgsConstructor
public class PublicationController {
    private final PublicationPresentationMapper publicationPresentationMapper;

    private final PublicationService publicationService;

    @GetMapping
    Collection<PublicationResponse> findAll() {
        return publicationPresentationMapper.convert(publicationService.findAll());
    }

    @PostMapping
    public PublicationResponse publish(
            @RequestBody final PublicationCreationRequest request) {
        final Publication publication = publicationService.create(
                publicationPresentationMapper.convert(request));

        return publicationPresentationMapper.convert(publication);
    }
}
