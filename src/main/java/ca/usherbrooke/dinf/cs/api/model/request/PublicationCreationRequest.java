package ca.usherbrooke.dinf.cs.api.model.request;

import lombok.Data;

import java.util.UUID;

@Data
public class PublicationCreationRequest {
    private String title;

    private String content;

    private UUID createdBy;
}
