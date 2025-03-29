package app.model.repository;


import app.model.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, UUID> {


//    @Query("""
//            SELECT n FROM Survey n WHERE n.userId = :userId AND n.isDeleted = false
//            """)
//    List<Survey> findAllByUserIdAndDeletedIsFalse(@Param("userId") UUID userId);

    List<Survey> findAllByUserId(UUID userId);
}
