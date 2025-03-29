package app.web.mapper;



import app.model.model.Survey;
import app.model.model.SurveyPreference;
import app.web.dto.SurveyPreferenceResponse;
import app.web.dto.SurveyResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DtoMapper {


    // Build dto from entity
    public static SurveyPreferenceResponse fromSurveyPreference(SurveyPreference entity) {

        return SurveyPreferenceResponse.builder()
                .id(entity.getId())
                .subject(entity.getSubject())
                .support(entity.getSupport())
                .userId(entity.getUserId())
                .build();
    }

//    public static SurveyResponse fromSurvey(Survey entity) {
//
//        // DTO building!
//        return SurveyResponse.builder()
//                .subject(entity.getSubject())
//                .support(entity.getSupport())
//                .build();
//    }
}
