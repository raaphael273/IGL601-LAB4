package ca.usherbrooke.dinf.cs.api.service;

import ca.usherbrooke.dinf.cs.api.model.storage.Publication;
import ca.usherbrooke.dinf.cs.api.repository.PublicationRepository;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Instant;
import java.util.UUID;

import static java.util.UUID.fromString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.internal.stubbing.answers.AnswerFunctionalInterfaces.toAnswer;

class PublicationServiceTest {

    public static final UUID UUID
            = fromString("64f1a56e-1ef0-458e-9358-2088283dc410");

    private final UUID ANONYMOUS_USER_ID = new UUID(0L, 0L);

    @Nested
    class Create {

        private PublicationService publicationService;

        @BeforeEach
        void setUp() {
            PublicationRepository publicationRepository
                    = Mockito.mock(PublicationRepository.class);
            publicationService
                    = new PublicationService(publicationRepository);

            given(publicationRepository.save(any()))
                    .will(toAnswer(p -> p));
        }

        @Test
        void GIVEN__a_publication_with_an_id__WHEN__create__THEN__a_new_id_replaces_the_given_id() {

        }

        @Test
        void GIVEN__a_publication_with_an_author__WHEN__create__THEN__the_author_did_not_change() {

        }

        @Test
        void GIVEN__a_publication_without_an_author__WHEN__create__THEN__the_author_is_anonymous() {
        }

        private Condition<Instant> between(
                final Instant start,
                final Instant end) {
            return new Condition<>(instant -> !start.isAfter(instant) && !end.isBefore(instant), "between %s and %s", start, end);
        }

        @Test
        void GIVEN__a_publication__WHEN__create__THEN__the_creation_date_is_set() {
 
 
        }

        @Test
        void GIVEN__a_publication_without_title__WHEN__create__THEN__throws_IllegalArgumentException() {
 
 
        }

        @Test
        void GIVEN__a_publication_without_content__WHEN__create__THEN__throws_IllegalArgumentException() {
 
 
        }
    }
}
