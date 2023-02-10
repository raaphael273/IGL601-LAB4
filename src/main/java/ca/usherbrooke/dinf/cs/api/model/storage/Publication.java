package ca.usherbrooke.dinf.cs.api.model.storage;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Publication {
    @Id
    @GeneratedValue
    private UUID id;

    private String title;

    @Lob
    private String content;

    private Instant createdOn;

    private UUID createdBy;
}
