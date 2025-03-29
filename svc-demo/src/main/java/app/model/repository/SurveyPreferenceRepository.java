package app.model.repository;



import app.model.model.SurveyPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SurveyPreferenceRepository extends JpaRepository<SurveyPreference, UUID> {

    Optional<SurveyPreference> findByUserId(UUID userId);
}
