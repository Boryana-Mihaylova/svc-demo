package app.model.service;




import app.model.model.Subject;
import app.model.model.Support;
import app.model.model.Survey;
import app.model.repository.SurveyRepository;


import app.web.dto.SurveyRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;


import java.util.UUID;

@Slf4j
@Service
public class SurveyService {


    private final SurveyRepository surveyRepository;

    @Autowired
    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }


    public Survey submitSurvey(SurveyRequest surveyRequest) {

        Subject subjectEnum = Subject.valueOf(surveyRequest.getSubject().toUpperCase());
        Support supportEnum = Support.valueOf(surveyRequest.getSupport().toUpperCase());


        Survey survey = Survey.builder()
                .subject(subjectEnum)
                .support(supportEnum)
                .userId(surveyRequest.getUserId())
                .build();

        log.info("Survey submitted successfully for user: {}", surveyRequest.getUserId());

        return surveyRepository.save(survey);
    }

    public Survey getSurvey(UUID userId) {

        Survey survey = surveyRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Survey not found for user: " + userId));

        log.info("Survey retrieved for user: {}", userId);

        return survey;
    }




//    public List<Survey> getAllSurveyRequests() {
//        return surveyRepository.findAll();
//    }
}
