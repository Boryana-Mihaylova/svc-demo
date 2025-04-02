package app.model.repository;





import app.model.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.UUID;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, UUID> {


//    @Query("""
//            SELECT n FROM Survey n WHERE n.userId = :userId AND n.isDeleted = false
//            """)
//    List<Survey> findAllByUserIdAndDeletedIsFalse(@Param("userId") UUID userId);




//    List<Survey> findAllByUserId(UUID userId);
//
//    //from internet
//    @Query(
//            nativeQuery = true,
//            value
//                    = "SELECT ea.id, ea.city, ea.state FROM gfgmicroservicesdemo.address ea join gfgmicroservicesdemo.employee e on e.id = ea.employee_id where ea.employee_id=:employeeId")
//    Optional<Survey> findSurveyByUserId(@Param("userId") UUID userId);


    List<Survey> findByUserId(UUID userId);
}
