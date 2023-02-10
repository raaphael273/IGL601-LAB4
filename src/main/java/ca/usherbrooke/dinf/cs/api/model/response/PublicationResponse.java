package ca.usherbrooke.dinf.cs.api.model.response;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class PublicationResponse {
    private UUID id;

    private String title;

    private String content;

    private Instant createdOn;

    private UUID createdBy;
}
