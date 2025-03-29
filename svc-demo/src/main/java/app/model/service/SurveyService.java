package app.model.service;

import app.model.model.Survey;
import app.model.model.SurveyPreference;
import app.model.repository.SurveyPreferenceRepository;
import app.model.repository.SurveyRepository;


import app.web.dto.SurveyRequest;
import app.web.dto.UpsertSurveyPreference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class SurveyService {

    private final SurveyPreferenceRepository preferenceRepository;
    private final SurveyRepository surveyRepository;

    @Autowired
    public SurveyService(SurveyPreferenceRepository preferenceRepository, SurveyRepository surveyRepository) {
        this.preferenceRepository = preferenceRepository;

        this.surveyRepository = surveyRepository;
    }




    public SurveyPreference upsertPreference(UpsertSurveyPreference dto) {

        // upsert

        // 1. try to find if such exist in the database
        Optional<SurveyPreference> userSurveyPreferenceOptional = preferenceRepository.findByUserId(dto.getUserId());

        // 2. if exists - just update it
        if (userSurveyPreferenceOptional.isPresent()) {
            SurveyPreference preference = userSurveyPreferenceOptional.get();
            preference.setSupport(dto.getSupport());
            return preferenceRepository.save(preference);
        }

        // Here I build a new entity object!
        // 3. if does not exist - just create new one
       SurveyPreference surveyPreference = SurveyPreference.builder()
                .userId(dto.getUserId())
                .subject(dto.getSubject())
                .support(dto.getSupport())
                .build();

        return preferenceRepository.save(surveyPreference);
    }

    public SurveyPreference getPreferenceByUserId(UUID userId) {

        return preferenceRepository.findByUserId(userId).orElseThrow(() -> new NullPointerException("Survey preference for user id %s was not found.".formatted(userId)));
    }




//    public Survey sendSurvey(SurveyRequest surveyRequest) {
//
//        UUID userId = surveyRequest.getUserId();
//        //SurveyPreference userPreference = getPreferenceByUserId(userId);
//
//
//
//        // Entity building
//        Survey survey = Survey.builder()
//                .subject(surveyRequest.getSubject())
//                .support(surveyRequest.getSupport())
//                .userId(userId)
//                .build();
//
//
//        return surveyRepository.save(survey);
//    }

}
