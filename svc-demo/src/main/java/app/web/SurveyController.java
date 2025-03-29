package app.web;

import app.model.model.SurveyPreference;
import app.model.service.SurveyService;
import app.web.dto.SurveyPreferenceResponse;
import app.web.dto.UpsertSurveyPreference;
import app.web.mapper.DtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/surveys")
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }


    @PostMapping("/user-support")
    public ResponseEntity<SurveyPreferenceResponse> submitSurveySupport(@RequestBody UpsertSurveyPreference upsertSurveyPreference) {


        SurveyPreference surveyPreference = surveyService.upsertPreference(upsertSurveyPreference);
        SurveyPreferenceResponse responseDto = DtoMapper.fromSurveyPreference(surveyPreference);


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }


    @GetMapping("/user-support")
    public ResponseEntity<SurveyPreferenceResponse> getSurveySupport(@RequestParam(name = "userId") UUID userId) {

        SurveyPreference surveyPreference = surveyService.getPreferenceByUserId(userId);

        SurveyPreferenceResponse responseDto = DtoMapper.fromSurveyPreference(surveyPreference);

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(responseDto);
    }
}
