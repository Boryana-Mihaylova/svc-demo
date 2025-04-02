package app.model.service;




import app.model.model.Subject;
import app.model.model.Support;

import app.model.model.Survey;
import app.model.repository.SurveyRepository;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class SurveyService {


    private final SurveyRepository surveyRepository;

    @Autowired
    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }




    // 1. Създаване на нов избор за подкрепа
    public void createSupportRequest(UUID userId, Subject subject, Support support) {

        Survey survey = Survey.builder()
                .subject(subject)
                .support(support)
                .userId(userId)
                .build();

        surveyRepository.save(survey);
    }

    // 2. Извличане на всички избори
    public List<Survey> getAllSupportRequests() {
        return surveyRepository.findAll();
    }
}
